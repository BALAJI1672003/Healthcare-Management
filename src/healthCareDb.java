import java.sql.*;
public class healthCareDb {
	private int userId;
	private String userName;
	private String userPassword;
	public healthCareDb() {
		this.userId=0;
		this.userName="";
		this.userPassword="";
	}
	public healthCareDb(int userId,String userName,String userPassword) {
		this.userId=userId;
		this.userName=userName;
		this.userPassword=userPassword;
	}
	public void setUserId(int userId) {
		this.userId=userId;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword=userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String  getUserPassword() {
		return userPassword;
	}
	
	public String checkLogin(healthCareDb user)throws Exception {
	  	   Connection con=Connection_Establishment.getConnect();
	  	   String qry="SELECT User_Name,User_Password,Position FROM login_record WHERE User_Id="+user.getUserId();
	  	   try {
	  	    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	 	    	ResultSet rs=st.executeQuery(qry);
		    	while(rs.next()==true) {
				   String passworddb=rs.getString("User_Password");
				   String username=rs.getString("User_Name");
				   String Position=rs.getString("Position");
				   if(passworddb.equals(user.getUserPassword())) {
					     System.out.println();
					     System.out.println("      WelcomeBack  "+username);
					     System.out.println("------------------------------------");
	   	            return Position;
				   }
			   }
		    	
				   System.out.println("No User Id Found ... Please Try Again....\n\n");
			 
	  	   }
	  	   catch(Exception e) {
	  		   System.out.println("Error: "+e);
	         }
	  	   return "";
	     }
	     public boolean  checkadmin(healthCareDb user) throws Exception{
	 		Connection con=Connection_Establishment.getConnect();
	  	   String qry="SELECT User_Name,User_Password FROM login_record WHERE User_Id="+user.getUserId()+" and Position='Deen'";
	  	   try {
	  	    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	 	    	ResultSet rs=st.executeQuery(qry);
	 	    	if(rs.next()==true) {
	 			   String passworddb=rs.getString("User_Password");
	 			   String username=rs.getString("User_Name");
	 			   if(passworddb.equals(user.getUserPassword())) {
	 				System.out.println();
	 				System.out.println("Welcome Admin "+username); 
	 				System.out.println();
			        System.out.println("----------------------------------");
	   	            return true;
	 			   }else {
	 				   System.out.println("Invalid Admin PassWord");
	 				   return false;
	 			   }
	 		   }else {
	 			   System.out.println("No Admin Id Found ...");
	 			   
	 		   }
	  	   }
	  	   catch(Exception e) {
	  		   System.out.println("Error: "+e);
	         }
	  	   return false;
	     }
	     public boolean  createUserId(healthCareDb user) throws Exception{
	  		Connection con=Connection_Establishment.getConnect();
	   	   String qry="INSERT INTO login_record (User_Id,User_Name,User_Password,Position) Values("+user.getUserId()+",'"+user.getUserName()+"','"+user.getUserPassword()+"','User')";
	   	  try {
	     	   Statement st=(Statement)con.createStatement();
	  		   int res=st.executeUpdate(qry);
	  		   if(res==1) {
	      	       return true;
	  		   }
	   	   }
	     	   catch(Exception e) {
	     		   System.out.println("Error: "+e);
	     	   }
	     	   return false;
	      }
	     public boolean  createDoctorId(healthCareDb user) throws Exception{
		  		Connection con=Connection_Establishment.getConnect();
		   	   String qry="INSERT INTO login_record (User_Id,User_Name,User_Password,Position) Values("+user.getUserId()+",'"+user.getUserName()+"','"+user.getUserPassword()+"','Doctor')";
		   	  try {
		     	   Statement st=(Statement)con.createStatement();
		  		   int res=st.executeUpdate(qry);
		  		   if(res==1) {
		      	       return true;
		  		   }
		   	   }
		     	   catch(Exception e) {
		     		   System.out.println("Error: "+e);
		     	   }
		     	   return false;
		      }
	     public void doctorPatient(healthCareDb user )  throws Exception {
	    	 	    Connection con=Connection_Establishment.getConnect();
	    	 	    String query="select appointment_Id,P.Patient_Name,Medical_Reason,appointment_Status "
	    	 	    		+ "from appointment_record A join patient_record P  on A.patient_Id=P.patient_Id "
	    	 	    		+ "where doctor_Id="+user.getUserId();

	    			    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    		        ResultSet rs=st.executeQuery(query);
	    		    	if(rs.next()==false) {
	    		    		System.out.println("Patient Record is Empty....");
	    		    		System.out.println();
	    		    		System.out.println("-----------------------------\n");
	    		    	}else {
	    		    	rs.beforeFirst();
	    		    	System.out.println();
	    		    	System.out.println("     Patient Record");
	    		    	System.out.println("-----------------------------");
	    		         while(rs.next()) {
	    		        	System.out.println("Appointment Id     : "+rs.getInt("appointment_Id"));  
	    		        	System.out.println("Patient Name       : "+rs.getString("Patient_name"));  
	    		        	System.out.println("Medical Reason     : "+rs.getString("Medical_Reason"));  
	    		        	System.out.println("Appointment Status : "+rs.getString("appointment_Status"));
	    		        	System.out.println();
	    		            System.out.println("----------------------------------");
	    		            System.out.println();
	    		
	    		        }
	    	      }
	    	 
	     }
	     public boolean isStrongPassword(healthCareDb user) {
	         String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	         return user.getUserPassword().matches(pattern);
	     }
}
