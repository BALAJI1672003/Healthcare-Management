import java.sql.*;
public class appointmentdb {
	 private int AppointmentId;
     private int PatientId;
     private int DoctorId;
     private String MedicalReason;
     private String DoctorDescription;
     public appointmentdb() {
    	this.AppointmentId=0;
      	this.PatientId=0;
      	this.DoctorId=0;
      	this.MedicalReason="";
     }
     public appointmentdb(int AppointmentId,int PatientId,int DoctorId,String MedicalReason) {
     	this.AppointmentId=AppointmentId;
     	this.PatientId=PatientId;
     	this.DoctorId=DoctorId;
     	this.MedicalReason=MedicalReason;
     }
     public void setAppointmentId(int AppointmentId) {
     	this.AppointmentId=AppointmentId;
     }
     public int getAppointmentId() {
     	return AppointmentId;
     }
     public void setPatientId(int PatientId) {
     	this.PatientId=PatientId;
     }
     public int getPatientId() {
     	return PatientId;
     }
     public void setDoctorId(int DoctorId) {
     	this.DoctorId=DoctorId;
     }
     public int getDoctorId() {
     	return DoctorId;
     }
     public void setMedicalReason(String MedicalReason) {
     	this.MedicalReason=MedicalReason;
     }
     public String getMedicalReason() {
     	return MedicalReason;
     }
     public void setDoctorDescription(String DoctorDescription) {
     	this.DoctorDescription=DoctorDescription;
     }public String getDoctorDescription() {
     	return DoctorDescription;
     }
     
     void addAppointment(appointmentdb Appointment)throws Exception{
    	 Connection con=Connection_Establishment.getConnect();
    	 String upqry="UPDATE doctor_Record SET Doctor_Availability='no' WHERE doctor_Id="+Appointment.getDoctorId();  
    		 String query="INSERT INTO appointment_record(appointment_Id, patient_Id,doctor_Id, Medical_Reason, appointment_Status, Entry_Date_Time) VALUES ("+Appointment.getAppointmentId()+","+Appointment.getPatientId()+","+Appointment.getDoctorId()+",'"+Appointment.getMedicalReason()+"','To Visit', NOW())";
               Statement st=(Statement)con.createStatement();
               try {
               int updateres=st.executeUpdate(upqry);
		       int res=st.executeUpdate(query);
		       if(updateres>=0 && res>=0) {
			       System.out.println("Appointment Scheduled....");
			       System.out.println();
			       System.out.println("--------------------------------------");
			       
		       }
               }catch(Exception e){
			       System.out.println("Problem In Appointment...");
		       }
    	 
	 }
     void displayAppointment() throws Exception {
 	    Connection con=Connection_Establishment.getConnect();
 	    String query="SELECT appointment_Id, Patient_name, Doctor_name, Medical_Reason,Entry_Date_Time,Exit_Date_Time,doctor_Description\r\n"
 	    		+ " from appointment_record as a"
 	    		+ " join patient_record as p"
 	    		+ " ON a.patient_Id=p.patient_Id"
 	    		+ " join doctor_record as d"
 	    		+ "  ON a.doctor_Id=d.doctor_Id;"
 	    		+ "";

		    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        ResultSet rs=st.executeQuery(query);
	    	if(rs.next()==false) {
	    		System.out.println("Appointment History is Empty....");
	    	}else {
	    	rs.beforeFirst();
	         while(rs.next()) {
	        	System.out.println("Appointment Id     : "+rs.getInt("appointment_Id"));  
	        	System.out.println("Patient Name       : "+rs.getString("Patient_name"));  
	        	System.out.println("Doctor Name        : "+rs.getString("Doctor_name"));  
	        	System.out.println("Medical Reason     : "+rs.getString("Medical_Reason"));  
	        	System.out.println("Entry Date & Time  : "+rs.getString("Entry_Date_Time"));  
	        	System.out.println("Exit Date & Time   : "+rs.getString("Exit_Date_Time"));  
	        	System.out.println("Doctor Description : "+rs.getString("doctor_Description"));
	        	System.out.println();
	            System.out.println("----------------------------------");
	            System.out.println();
	
	        }
      }
 }
    
     void updateAppointment(appointmentdb Appointment) throws Exception {
		 Connection con=Connection_Establishment.getConnect();
		 String docup="SELECT doctor_Id from appointment_record where appointment_id="+Appointment.getAppointmentId();
    	 String upqry="UPDATE appointment_record SET doctor_Description='"+Appointment.getDoctorDescription()+"',Exit_Date_Time=NOW(),appointment_Status='visited' where appointment_Id="+Appointment.getAppointmentId();  
		try {
    	 Statement st=(Statement)con.createStatement();
    	 Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	     ResultSet rs=st1.executeQuery(docup);
	     int doctor_Id=-1;
	     while(rs.next()) {
	    	 doctor_Id=rs.getInt("doctor_Id");
	     }
	     String updateaval="UPDATE doctor_record SET Doctor_Availability='yes' WHERE doctor_Id="+doctor_Id;
	     int res1=st.executeUpdate(updateaval);
	     int res=st.executeUpdate(upqry);
	     if(res>=1 && res1>=1){
		       System.out.println("Appointment Updated....");
		       System.out.println();
	            System.out.println("----------------------------------");
	       }
		}catch(Exception e){
		       System.out.println("Problem In Updatation...");
	       }
		System.out.println();
	 }
     boolean displayDoctorRecord()throws Exception {
		  Connection con=Connection_Establishment.getConnect();
		  String query="SELECT *FROM doctor_Record where Doctor_Availability='yes'";
		  Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    	ResultSet rs=st.executeQuery(query);
	    	if(rs.next()==false) {
	    		System.out.println("No Doctors Available....");
	    		System.out.println();
	            System.out.println("----------------------------------");
	    		return false;
	    	}
	    	else {
	    	rs.beforeFirst();
	    	System.out.println("========== List of Doctors Available ============");
	         while(rs.next()) {
	        	 System.out.println("Doctor Id             : "+rs.getInt("Doctor_Id"));
	        	 System.out.println("Doctor Name           : "+rs.getString("Doctor_Name"));
	    	     System.out.println("Doctor  Specialization: "+rs.getString("Doctor_Specialization"));
	    	     System.out.println();
	             System.out.println("----------------------------------");
	         }
        }
	    	System.out.println();
	    	return true;
	 }
}
