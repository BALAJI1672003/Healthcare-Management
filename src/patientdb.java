import java.sql.*;
public class patientdb{
	private int patientId;
    private String patientName;
    private String patientAge;
    private String patientAddress;
    private String patientPhoneNumber;
   public patientdb() {
	   this.patientId =0;
       this.patientName = "";
       this.patientAge ="";
       this.patientAddress ="";
       this.patientPhoneNumber = "";
   }
   public patientdb(int patientId,String patientName,String patientAge,String patientAddress,String patientPhoneNumber ){
        this.patientId =patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientAddress = patientAddress;
        this.patientPhoneNumber = patientPhoneNumber;
       
    }
    public int getPatientId() {
        return patientId;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public String getPatientAge() {
        return patientAge;
    }
    
    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }
    
    public String getPatientAddress() {
        return patientAddress;
    }
    
    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }
    
    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }
    
    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }
    public void insertPatientRecord(patientdb patient) throws Exception {
        Connection con = Connection_Establishment.getConnect();
         String query = "INSERT INTO patient_Record (Patient_Id,Patient_Name,Patient_Age,"
             + "Patient_Address,Patient_PhoneNumber) VALUES (?, ?, ?, ?, ?)";
         try {
             PreparedStatement pst = con.prepareStatement(query);
             pst.setInt(1,    patient.getPatientId());
             pst.setString(2, patient.getPatientName());
             pst.setString(3, patient.getPatientAge());
             pst.setString(4, patient.getPatientAddress());
             pst.setString(5, patient.getPatientPhoneNumber());
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
    public void displayPatientTable() throws Exception{
 	    Connection con=Connection_Establishment.getConnect();
 		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
     	String query="select *from patient_Record";
     	ResultSet rs=st.executeQuery(query);
     	if(rs.next()==false) {
     		System.out.println("No Patients Record Found....");
     	}else {
     	System.out.println("========== Patient Records ==========");
     	rs.beforeFirst();
          while(rs.next()) {
         	System.out.println();
     		System.out.println("Patient ID      : " + rs.getInt(1));
             System.out.println("Name            : " + rs.getString(2));
             System.out.println("Age             : " + rs.getString(3));
             System.out.println("Address         : " + rs.getString(4));
             System.out.println("Phone Number    : " + rs.getString(5));
             System.out.println();
             System.out.println("----------------------------------");
             
          }
         }
   }
    public void updatePatientRecord(patientdb patient,String fieldName) throws Exception {
         Connection con = Connection_Establishment.getConnect();
         String query = "UPDATE patient_Record SET " + fieldName + " = ? WHERE Patient_Id = ?";
         try {
             PreparedStatement pst = con.prepareStatement(query);
             if(fieldName.equals("Patient_Name")) {
             	pst.setString(1, patient.getPatientName());
             }else if(fieldName.equals("patient_Age")) {
             	pst.setString(1, patient.getPatientAge());
             }else if(fieldName.equals("patient_Address")) {
             	pst.setString(1, patient.getPatientAddress());
             }else if(fieldName.equals("patient_PhoneNumber")) {
             	pst.setString(1, patient.getPatientPhoneNumber());
             }
             pst.setInt(2, patient.getPatientId());
             int res = pst.executeUpdate();
             if (res >= 0) {
                 System.out.println("Record updated successfully!");
             } else {
                 System.out.println("Record could not be updated!");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
    public void deletePatientRecord(patientdb patient) throws Exception {
         Connection con = Connection_Establishment.getConnect();
         String query = "DELETE FROM patient_Record WHERE Patient_Id = ?";
         try {
             PreparedStatement pst = con.prepareStatement(query);
             pst.setInt(1, patient.getPatientId());
             int res = pst.executeUpdate();
             if (res >= 0) {
                 System.out.println("Record deleted successfully!");
             } else {
                 System.out.println("Record could not be deleted!");
             }
         } catch (Exception e) {
         	e.printStackTrace();
         }
     }
}
