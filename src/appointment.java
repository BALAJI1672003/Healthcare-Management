public class appointment {
	public appointmentdb appointment;
	public appointment(){
		appointment=new appointmentdb();
	}
	public void manageAppointment() throws Exception{
        System.out.println("============= Manage Appointment Records =============");
        int choice=0;
        while (choice!=4) {
        	System.out.println("1. Add appointment");
            System.out.println("2. Update appointment");
            System.out.println("3. View all appointments");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (1-3): ");
            
            choice = healthCare.scanner.nextInt();
            
            switch (choice) {
                case 1:
                	System.out.println("Enter Patient Id: ");
                	int p_id=healthCare.scanner.nextInt();
                	healthCare.scanner.nextLine();
                	System.out.println("Enter Medical Reason : ");
                	String medicalReason=healthCare.scanner.nextLine();
                	if(appointment.displayDoctorRecord()){
                		System.out.println("Enter your choice(1-2)");
                		System.out.println("1.Add Appointment");
                		System.out.println("2. Cancel Appointment");
                		int choic=healthCare.scanner.nextInt();
                		switch(choic) {
                		case 1:
                			 System.out.println("Enter Appointment Id : ");
                             int app_id=healthCare.scanner.nextInt();
                             System.out.println("Enter Doctor Id : ");
                             int doc_id=healthCare.scanner.nextInt();
                             this.appointment= new appointmentdb(app_id,p_id,doc_id,medicalReason);
                             appointment.addAppointment(this.appointment);
                             break;
                		case 2:
                			System.out.println("Appointment Cancelled");
                			break;
                		default:
                			System.out.println("Invalid Choice");
                			break;
                		}
                		
                    }else {
                       	System.out.println("Please Wait ...");
                     }
                	break;
                case 2:
                	System.out.println("Enter appointment details:");
                	System.out.println();
                	System.out.println("Enter Appointment ID :");
                	int app_id=healthCare.scanner.nextInt();
                	healthCare.scanner.nextLine();
                	System.out.println("Enter Doctor Description : ");     
        	        String description = healthCare.scanner.nextLine();
        	        appointment.setAppointmentId(app_id);
        	        appointment.setDoctorDescription(description);
        	        appointment.updateAppointment(appointment);
                    break;
                case 3:
                	System.out.println("================ Appointment Records ============");
                	System.out.println();
                	appointment.displayAppointment();
                    break;
                case 4:    
                	System.out.println("Exiting Appointment Manager..");
                    break;
                default:
                    System.out.println("Invalid option... Please try again...");
            }
        
        }
    
  }
	
}
