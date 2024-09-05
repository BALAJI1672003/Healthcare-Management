public class patient {
	public patientdb patient;
	public appointmentdb appointment;
	public  patient() {
		 patient=new patientdb();
		 appointment=new appointmentdb();
	}
    public void patientRecord() throws Exception {
    	int choice = 0;
        do {
            System.out.println("========== Manage Patient Records ==========");
            System.out.println();
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient Records");
            System.out.println("3. Update Patient Record");
            System.out.println("4. Delete Patient Record");
            System.out.println("5. Back to Main Menu");
            System.out.println();
            System.out.print("Enter your choice (1-5): ");
            System.out.println();
            choice = healthCare.scanner.nextInt();
            healthCare.scanner.nextLine();

            switch (choice){
                case 1:
                     // Add new patient record
                    System.out.print("Enter patient ID: ");
                    int patientId = healthCare.scanner.nextInt();
                    healthCare.scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String patientName = healthCare.scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    String patientAge =healthCare.scanner.nextLine();
                    System.out.print("Enter patient address: ");
                    String patientAddress = healthCare.scanner.nextLine();
                    System.out.print("Enter patient phone number: ");
                    String patientPhoneNumber = healthCare.scanner.nextLine();

                     this.patient = new patientdb(patientId, patientName, patientAge, patientAddress, patientPhoneNumber);
                     patient.insertPatientRecord(this.patient);
                    
                    System.out.println("Enter your Choice");
                    System.out.println("1. Add Appointment...");
                    System.out.println("2. Exit Add patient");
                    int appointmentChoice = healthCare.scanner.nextInt();
                    healthCare.scanner.nextLine();
                    if(appointmentChoice == 1){
                        System.out.println("Enter Medical Reason : ");
                        String medicalReason =healthCare.scanner.nextLine();
                        if(appointment.displayDoctorRecord()) {
                            System.out.println("Enter Appointment Id : ");
                            int appointmentId =healthCare.scanner.nextInt();
                            System.out.println("Enter Doctor Id : ");
                            int doctorId = healthCare.scanner.nextInt();
                            this.appointment= new appointmentdb(appointmentId, patientId,doctorId,medicalReason);
                            appointment.addAppointment(this.appointment);
                            
                        }else {
                            System.out.println("Please Wait ..");
                        }
                    }    
                    break;
                case 2:
                    // View patient records
                    System.out.println("");
                    patient.displayPatientTable();
                    break;
               
                case 3:
	            	   System.out.println("Enter the patient_ID to Update..");
	            	   int PatientId=healthCare.scanner.nextInt(),update_choice=0;
	            	   healthCare.scanner.nextLine();
	            	   patient.setPatientId(PatientId);
    			    
      		       while(update_choice!=5){
	            			   System.out.println("=========Update Patient Records=========");
	            			   System.out.println("1. Update Patient Name");
	            			   System.out.println("2. Update Patient Age");
	            			   System.out.println("3. Update Patient Address");
	            			   System.out.println("4. Update Patient Phone Number");
	            			   System.out.println("5. Back to Manage Patient Record"); 
		            		   System.out.print("Enter your choice (1-5): ");
		            		   System.out.println();
	            		       update_choice=healthCare.scanner.nextInt(); 
	            		       healthCare.scanner.nextLine();
		            		   switch(update_choice) {
		            		   case 1:
		            			     System.out.println("Enter Name to Update               :");
		            			     String PatientName=healthCare.scanner.nextLine();
		            			     patient.setPatientName(PatientName);
		            			     patient.updatePatientRecord(patient,"Patient_Name");
		            			     break;
		            		   case 2:
		            			     System.out.println("Enter Age to Update                 :");
		            			     String PatientAge=healthCare.scanner.nextLine();
		            			     patient.setPatientAge(PatientAge);
		            			     patient.updatePatientRecord(patient,"patient_Age");
		            			     break;
		            		   case 3:
		            			     System.out.println("Enter Address to Update             :");
		            			     String PatientAddress=healthCare.scanner.nextLine();
		            			     patient.setPatientAddress(PatientAddress);
		            			     patient.updatePatientRecord(patient,"patient_Address");
		            			     break;
		            		   case 4:
		            			     System.out.println("Enter Phone Number to Update         :");
		            			     String PatientPhoneNumber=healthCare.scanner.nextLine();
		            			     patient.setPatientPhoneNumber(PatientPhoneNumber);
		            			     patient. updatePatientRecord(patient,"patient_PhoneNumber");
		            			     break;
		            		   
		            		   case 5:
		            			     System.out.println("Exiting Update Record..");
		            			     System.out.println();
		            			     System.out.println();
		            			     break;
	            			   default:
	            				     System.out.println("Invalid Choice to Update...");
	            			    	 
		            		    }
	                          }
      		       break;   
	             case 4:
	            	  System.out.println("Enter the patient_ID to Delete the Record..");
	            	  int patient_id=healthCare.scanner.nextInt();
	            	  patient.setPatientId(patient_id);
	            	  patient.deletePatientRecord(patient);
	            	  healthCare.scanner.nextLine();
	            	  break;
	              case 5:
	            	  System.out.println("Back To Main Menu...");
	            	  System.out.println();
	  	              System.out.println("----------------------------------");
	            	  System.out.println();
	            	  break;
	              default:
	            	   System.out.println("Invalid Choice to Manage Patient Record..");
	            	   System.out.println();
   			           
	                }

	        }while(choice!= 5);
	    //scanner.close();
      }   


    
}
