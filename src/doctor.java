public class doctor {
	
	public doctordb doctor;
	public healthCareDb log;
	public doctor() {
		doctor=new doctordb();
		log=new healthCareDb();
	}
	public  void doctorRecord() throws Exception{
	    	 
	    	 int choice = 0;
	 	     do { 
	 	        System.out.println("========== Manage Doctor Records ==========");
	 	        System.out.println();
	 	        System.out.println("1. Add Doctor");
	 	        System.out.println("2. View Doctor Records");
	 	        System.out.println("3. Update Doctor Record");
	 	        System.out.println("4. Delete Doctor Record");
	 	        System.out.println("5. Back to Main Menu");
	 	        System.out.print("Enter your choice (1-5): ");
	 	        System.out.println();
	 	        choice=healthCare.scanner.nextInt();
	 	        switch(choice) {
	 	          case 1:
	 	        	    System.out.print("Enter Doctor ID: ");
		                int DoctorId =healthCare.scanner.nextInt();
		                healthCare.scanner.nextLine();
	      		        System.out.print("Enter Doctor name: ");
		                String DoctorName = healthCare.scanner.nextLine();
		                System.out.print("Enter Doctor Qualification: ");
		                String DoctorQualification= healthCare.scanner.nextLine();
		                System.out.print("Enter Doctor Speciality : ");
		                String DoctorSpeciality = healthCare.scanner.nextLine();
		                System.out.print("Enter Doctor Availability : ");
		                String DoctorAvailabilty = healthCare.scanner.nextLine();
		                System.out.print("Enter Doctor phone number: ");
		                String DoctorPhoneNumber=healthCare.scanner.nextLine();
		                this.doctor=new doctordb(DoctorId,DoctorName,DoctorQualification,DoctorSpeciality,DoctorAvailabilty,DoctorPhoneNumber);
		                doctor.addDoctorDetail(this.doctor);
		                System.out.println("Enter Strong Password");
		                String UserPassword=healthCare.scanner.nextLine();
		                log.setUserPassword(UserPassword);
		                if(log.isStrongPassword(log)) {
		     			   log=new healthCareDb(DoctorId,DoctorName,UserPassword);
		     			   if(log.createDoctorId(log)) {
		     				   System.out.println("Doctor Id Created Successfully");
		     				   System.out.println();
		     		           System.out.println("----------------------------------");
		     			   }
		     			   else {
		     			     	System.out.println("Error In Creating Doctor Account");
		     			    	System.out.println();
		     			   }
		     			}else {
		     				System.out.println("The password is weak. It should contain at least 8 characters, including uppercase and lowercase letters, numbers, and special characters.");
		     		            
		     			}
		                break;
	 	          case 2:
	 	        	 doctor.displayDoctorTable();
	 	        	  break;
	 	          case 3:
	 	        	 System.out.println("Enter the Doctor_ID to Update..");
	          	     int Doctor_ID=healthCare.scanner.nextInt(),update_choice=0;
	          	     healthCare.scanner.nextLine();
	          	     doctor.setDoctorId(Doctor_ID);
	      		     while(update_choice!=6){
	          			   System.out.println("=========Update Doctor Records=========");
	          			   System.out.println();
	          			   System.out.println("1. Update Doctor Name");
	          			   System.out.println("2. Update Doctor Qualification:");
	          			   System.out.println("3. Update Doctor Speciality : ");
	          			   System.out.println("4. Update Doctor Availability : ");
	          			   System.out.println("5. Update Doctor phone number:");
	          			   System.out.println("6. Back to Manage Doctor Record"); 
	          			   System.out.println();
		            	   System.out.print("Enter your choice (1-6): ");
		            	   System.out.println();
	          		       update_choice=healthCare.scanner.nextInt(); 
	          		       healthCare.scanner.nextLine();
		            		   switch(update_choice) {
		            		   case 1:
		            			     System.out.println("Enter Doctor Name to Update :");
		            			     String Doctor_Name=healthCare.scanner.nextLine();
		            			     doctor.setDoctorName(Doctor_Name);
		            			     doctor.updateDoctorRecord(doctor,"Doctor_Name");
		            			     break;
		            		   case 2:
		            			     System.out.println("Enter Doctor Qualification to Update :");
		            			     String Doctor_Qualification=healthCare.scanner.nextLine();
		            			     doctor.setDoctorQualification(Doctor_Qualification);
		            			     doctor.updateDoctorRecord(doctor,"Doctor_Qualification");
		            			     break;
		            		   case 3:
		            			     System.out.println("Enter Doctor Speciality to Update :");
		            			     String Doctor_Specialization=healthCare.scanner.nextLine();
		            			     doctor.setDoctorSpeciality(Doctor_Specialization);
		            			     doctor.updateDoctorRecord(doctor,"Doctor_Specialization");
		            			     break;
		            		   case 4:
		            			     System.out.println("Enter Doctor Availability to Update :");
		            			     String DoctorAvailability=healthCare.scanner.nextLine();
		            			     doctor.setDoctorAvailabilty(DoctorAvailability);
		            			     doctor.updateDoctorRecord(doctor,"Doctor_Availability");
		            			     break;
		            		   case 5:
	          			            System.out.println("Enter Doctor phone number to Update :");
	          			            String Doctorphonenumber=healthCare.scanner.nextLine();
	          			            doctor.setDoctorPhoneNumber(Doctorphonenumber);
	          			            doctor.updateDoctorRecord(doctor,"Doctor_PhoneNumber");
	          			            break;
		            		   case 6:
		            			     System.out.println("Exiting Update Doctor Record..");
		            			     break;
	          			   default:
	          				     System.out.println("Invalid Choice to Update...");
	          			    	 
		            		    }
	                        }
	      		            break;
	 	          case 4:
	 	        	  System.out.println("Enter the Doctor Id to Delete The Record ");
	 	        	  int Doctor_id=healthCare.scanner.nextInt();
	 	        	  healthCare.scanner.nextLine();
	 	        	  doctor.setDoctorId(Doctor_id);
	 	        	  doctor.deleteDoctorRecord(doctor);
	 	        	  break;
	 	          case 5:
	 	        	  System.out.println("Existing Doctor Record Management..\n");
	 	        	  break;
	 	           default:
	 	        	   System.out.println("\nInvalid ...Please Enter Between (1-5)\n");
	          		  }
	 	    }while(choice!=5);
	     }
	
	      
}
