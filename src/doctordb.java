 import java.sql.*;
public class doctordb {
	private int DoctorId;
    private String DoctorName;
    private String DoctorQualification;
    private String DoctorSpeciality;
    private String DoctorAvailabilty;
    private String DoctorPhoneNumber;
    public doctordb() {
    	this.DoctorId=0;
        this.DoctorName="";
        this.DoctorQualification="";
        this.DoctorSpeciality="" ;
        this.DoctorAvailabilty="";
        this.DoctorPhoneNumber="";
    }
    public doctordb(int DoctorId,String DoctorName,String DoctorQualification,String DoctorSpeciality,String DoctorAvailabilty,String DoctorPhoneNumber){
   	   this.DoctorId=DoctorId;
       this.DoctorName=DoctorName;
       this.DoctorQualification=DoctorQualification;
       this.DoctorSpeciality=DoctorSpeciality ;
       this.DoctorAvailabilty=DoctorAvailabilty;
       this.DoctorPhoneNumber=DoctorPhoneNumber;
    }
    public void setDoctorId(int DoctorId) {
   	this.DoctorId=DoctorId;
    }
    public int getDoctorId() {
   	 return this.DoctorId;
    }
    public void setDoctorName(String DoctorName) {
   	 this.DoctorName=DoctorName;
    }
    public String getDoctorName() {
   	 return this.DoctorName;
    }
    public void setDoctorQualification(String DoctorQualification) {
   	 this.DoctorQualification=DoctorQualification;
    }
    
    public String getDoctorQualification() {
   	 return this.DoctorQualification;
    }
    public void setDoctorSpeciality(String DoctorSpeciality) {
   	 this.DoctorSpeciality=DoctorSpeciality;
    }
    public String getDoctorSpeciality() {
   	 return this.DoctorSpeciality;
    }
    public void setDoctorAvailabilty(String DoctorAvailabilty) {
   	 this.DoctorAvailabilty=DoctorAvailabilty;
    }
    public String getDoctorAvailabilty() {
   	 return this.DoctorAvailabilty;
    }
    public void setDoctorPhoneNumber(String DoctorPhoneNumber) {
   	 this.DoctorPhoneNumber=DoctorPhoneNumber;
    }
    public String getDoctorPhoneNumber() {
   	 return this.DoctorPhoneNumber;
    }
    public  void addDoctorDetail(doctordb doctor) throws Exception {
 	   Connection con=Connection_Establishment.getConnect();
 	   String qry="INSERT INTO doctor_record (Doctor_Id,Doctor_Name,Doctor_Qualification,Doctor_Specialization,Doctor_Availability,Doctor_PhoneNumber) VALUES(?,?,?,?,?,?)";
 	 try {
           PreparedStatement pst = con.prepareStatement(qry);
           pst.setInt(1, getDoctorId());
           pst.setString(2, getDoctorName());
           pst.setString(3, getDoctorQualification());
           pst.setString(4, getDoctorSpeciality());
           pst.setString(5, getDoctorAvailabilty());
           pst.setString(6, getDoctorPhoneNumber());

           int res = pst.executeUpdate();
           if (res >= 0) {
               System.out.println("Record added successfully!");
           } else {
               System.out.println("Record could not be added!");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    public void displayDoctorTable() throws Exception{
	    Connection con=Connection_Establishment.getConnect();
	    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	String query="select *from doctor_record";
    	ResultSet rs=st.executeQuery(query);
    	if(rs.next()==false) {
    		System.out.println("No Doctor Record Found....");
    	}else {
    	System.out.println("========== Doctors Records ==========");
    	rs.beforeFirst();
        while(rs.next()) {
       	System.out.println();
    		System.out.println("Doctor ID              : " + rs.getInt(1));
           System.out.println("Doctor Name            : " + rs.getString(2));
           System.out.println("Doctor Qualification   : " + rs.getString(3));
           System.out.println("Doctor Speciality      : " + rs.getString(4));
           System.out.println("Doctor Availabilty     : " +rs.getString(5));
           System.out.println("Doctor Phone Number    : " + rs.getString(6));
           System.out.println();
           System.out.println("----------------------------------");
           }
       }
  }
    public  void updateDoctorRecord(doctordb doctor,String fieldName)throws Exception {
      	  Connection con=Connection_Establishment.getConnect();
      	 String qry = "UPDATE doctor_record SET " + fieldName + " = ? WHERE Doctor_Id = ?";
      	try {
      		PreparedStatement pst = con.prepareStatement(qry);
            if(fieldName.equals("Doctor_Name")) {
        	pst.setString(1, getDoctorName());
        }else if(fieldName.equals("Doctor_Qualification")) {
        	pst.setString(1,getDoctorQualification());
        }else if(fieldName.equals("Doctor_Specialization")) {
        	pst.setString(1, getDoctorSpeciality());
        }else if(fieldName.equals("Doctor_Availability")) {
        	pst.setString(1,getDoctorAvailabilty());
        }else if(fieldName.equals("Doctor_PhoneNumber")) {
        	pst.setString(1,getDoctorPhoneNumber());
        }
            pst.setInt(2,getDoctorId());
            
    		  int res=pst.executeUpdate(qry);
    		  if(res==1) {
    			   System.out.println(fieldName.replace("_"," ")+" Updated..");
    			    System.out.println();
    	            System.out.println("----------------------------------");
    		   }
    		  }catch(Exception e) {
    			  System.out.println("Error In Updation :"+e);
    		  }
    		System.out.println();
         }
    public  void deleteDoctorRecord(doctordb doctor) throws Exception {
    	   Connection con=Connection_Establishment.getConnect();
   		  String qry="DELETE FROM doctor_Record WHERE doctor_Id= ?";
   		  try {
   			PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, getDoctorId());
            int res = pst.executeUpdate();
   		  if(res>=0){
   			  System.out.println("Doctor Data Deleted Successfully");
   			 System.out.println();
   	            System.out.println("----------------------------------");
   		  }
       }catch(Exception e) { 
   			  System.out.println("Error In Deletion :"+e);
   		  }
   		 System.out.println();
       }
      
    }
	

