//import java.util.Scanner;

public class Menu {
	private static final int PATIENT_RECORDS = 1;
    private static final int APPOINTMENT_SCHEDULE = 2;
    private static final int EXIT = 3;
    
    public void mainMenu() throws Exception{
        
        int choice =0;
        do {
            System.out.println("========== Healthcare Management System ==========");
            System.out.println();
            System.out.println("1. Patient Records");
            System.out.println("2. Appointment Schedule");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice (1-3): ");
            System.out.println();
            choice = healthCare.scanner.nextInt();
            healthCare.scanner.nextLine();
 		    switch (choice) {
                case PATIENT_RECORDS :
                	patient s1=new  patient();
                	s1.patientRecord();
                    break;
                /*case DOCTOR_RECORDS:
                	doctor s2=new doctor();
                	s2.doctorRecord();
                    break;*/
                case APPOINTMENT_SCHEDULE:
                	appointment s3= new appointment();
                	s3.manageAppointment();
                    break;
                case EXIT:
                    System.out.println("Exiting User Login...Welcome Back");
                    System.out.println();
                    System.out.println("------------------------------------");
        		    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again...");
                    
            }
            
        } while (choice!=3);
        
        //scanner.close();
    }
}
