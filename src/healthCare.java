import java.util.Scanner;

public class healthCare {
	private static final int Admin = 1;
	private static final int LOGIN = 2;
    private static final int EXIT = 3;
    static final Scanner scanner=new Scanner(System.in);
    private static healthCareDb log=new healthCareDb();
    public static void main(String[] args) throws Exception{
    	System.out.println("\n\n=================== Welcome To The HealthCare Management System ====================");
        System.out.println();
        int choice=0; 
        while(choice!=3) {
        	System.out.println("Enter Your Choice :");
        	System.out.println("");
        	System.out.println("1. Admin");
            System.out.println("2. Log in");
        	System.out.println("3. Exit ");
        	choice=scanner.nextInt();
	        scanner.nextLine();
        	switch(choice){
        	case Admin:
        		System.out.println("Enter your id :");
        		int id=scanner.nextInt();
        		scanner.nextLine();
        		System.out.println("Enter your password :");
        		String Apassword=scanner.nextLine();
        		log.setUserId(id);
        		log.setUserPassword(Apassword);
        		if(log.checkadmin(log)) {
        		    adminlogin();
        		}
        		break;
        	case LOGIN:
        		    System.out.println("------------------------------------");
        		    System.out.println();
        		    System.out.println("Enter your User Id   :");
        	        int userId=scanner.nextInt();
        	        scanner.nextLine();
        	        System.out.println("Enter your Password  :");
        	        String password=scanner.nextLine();
        	        log.setUserId(userId);
        	        log.setUserPassword(password);
        	        String position=log.checkLogin(log);
        	        switch(position) {
        	        case "User":
        	        	Menu Homepage=new Menu();
        	        	Homepage.mainMenu();
        	        	System.out.println();
        	        	break;
        	        case "Doctor":
        	        	 System.out.println("\n------------------------------------");
        	        	 System.out.println("      Welcome to Doctor Login\n");
        	        	int option=0;
        	        	while(option!=2) { 
        	        		System.out.println("Enter your Choice(1-2)");
           	        	 System.out.println("1. View Patient");
           	        	 System.out.println("2. Exit Doctor login");
        	        		option=healthCare.scanner.nextInt();
        	        		healthCare.scanner.nextLine();
        	        	 switch(option) {
        	              case 1: 
        	        	        log.doctorPatient(log);
        	                    break;
        	              case 2:
        	            	  System.out.println();
        	            	  System.out.println("Exiting Doctor Login....");
        	            	   break;
        	        	}
        	            }
        	        	break;
        	        default:
        	        	System.out.println("Access Denied...Try Again....\n\n");
        	        }
            		break;
        	 case EXIT:
        		 System.out.println();
        		 System.out.println("============ welcome Back ============");
        		 break;
        	default:
        		System.out.println("Invalid choice Try Again.....");
        	}
        }
        
        scanner.close();
	
    }
    
    static void adminlogin() throws Exception {
		
		int choice=0;
		while(choice!=3) {
			System.out.println("Enter Your Choice :\n");
			System.out.println("1. Add User");
			System.out.println("2. Doctor Record");
			System.out.println("3. Exit Admin Login");
			choice=scanner.nextInt();
			scanner.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Enter User Id :");
			int id=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter User Name :");
			String u_name=scanner.nextLine();
			System.out.println("Enter User password");
			String u_paswrd=scanner.nextLine();
			log.setUserPassword(u_paswrd);
			if(log.isStrongPassword(log)) {
			   log=new healthCareDb(id,u_name,u_paswrd);
			   if(log.createUserId(log)) {
				   System.out.println("User Id Created Successfully");
				   System.out.println();
		           System.out.println("------------------------------------");
			   }
			   else {
			     	System.out.println("Error In Creating User Account");
			    	System.out.println();
			   }
			}else {
				System.out.println("The password is weak. It should contain at least 8 characters, including uppercase and lowercase letters, numbers, and special characters.");
		            
			}
			break;
		case 2:
			doctor s2=new doctor();
    	    s2.doctorRecord();
        	break;
		case 3:
			System.out.println();
			System.out.println("Exiting Admin Login");
			System.out.println();
	        System.out.println("----------------------------------");
			break;
		default:
			System.out.println();
			System.out.println("Enter a Valid Choice.........");
		 }
	   }
    }
    
    
}
