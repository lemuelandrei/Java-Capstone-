import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Java Course 4, Module 3, Norima Java Developer Course Capstone Project
 * 
 * A simple Automobile Insurance Policy and Claims Administration system (PAS) that manages customer automobile insurance policies and as well as accident claims for an insurance company. 
 * 
 * @author LemuelLimuco
 *
 */
public class PASApp {
	
	public static void main(String[] args) {
		ArrayList<CustomerAccount> customerList = new ArrayList<>();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("--------------------------------------------");
			System.out.println("                 PAS SYSTEM");
			System.out.println("--------------------------------------------");
			System.out.println("1 - Create a new Customer Account");
			System.out.println("2 - Get a policy quote and buy the policy");
			System.out.println("3 - Cancel a specific policy");
			System.out.println("4 - File an accident claim against a policy");
			System.out.println("5 - Search for a Customer account");
			System.out.println("6 - Search for and display a specific policy");
			System.out.println("7 - Search for and display a specific claim");
			System.out.println("8 - Exit the PAS System");
			System.out.println("--------------------------------------------");
			System.out.print("Enter your choice <1-8>: ");
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				sc.next();
				choice = 0;
			}
			
			switch(choice) {
			  case 1:
				  System.out.println();
				  System.out.print("Enter first name: ");
				  String firstName = sc.nextLine() + sc.nextLine();
				  System.out.print("Enter last name: ");
				  String lastName = sc.nextLine();
				  System.out.print("Enter address: ");
				  String address = sc.nextLine();
				  customerList.add(new CustomerAccount(firstName, lastName, address));
				  String currAccNum = customerList.get(customerList.size()-1).getAccNo();
				  System.out.println();
				  System.out.println("********ACCOUNT CREATED SUCCESSFULLY********");
				  System.out.println("New account created with account no: " + currAccNum);
				  System.out.println();
				  break;
			    
			  case 2:
				  System.out.println();
				  System.out.print("Enter account number: ");
				  String customerAccNo = sc.next();
				  int match = 0;
				  for(CustomerAccount cus : customerList) {
					  if(cus.getAccNo().equals(customerAccNo)) {
						  match++;
						  String fName = null;
						  String lName = null;
						  String policyHolderAddress = null;
						  LocalDate bday = null;
						  String driversLicenseNo = null;
						  LocalDate licenseDateFirstIssued = null;
						  int licenseYear = 0;
						  
						  boolean isEffDateValid;
						  do {
							  isEffDateValid = false;
							    try {
							    	 System.out.print("Enter effective date (yyyy-mm-dd): ");
									  String effectiveDate = sc.next();
									  cus.addPolicy(effectiveDate);
									  LocalDate policyExpirationDate = cus.policies.get(cus.policies.size()-1).getExpirationDate();
									  System.out.println("Your policy coverage will expire on " + policyExpirationDate);
									  System.out.println();
									  sc.nextLine();
							    } catch (Exception e) {
							        System.out.println("********PLEASE ENTER DATE ACCORDING TO REQURED DATE FORMAT********"); 
							        isEffDateValid = true;  // This is what will get the program to loop back
							        sc.nextLine();
							    }
							} while (isEffDateValid);
						  
						  System.out.print("Are you also the policy holder? <y/n>: ");
						  String answer = sc.next();
						  System.out.println();
						  if(answer.equalsIgnoreCase("y")) {
							  fName = cus.getFirstName();
							  lName = cus.getLastName();
							  policyHolderAddress = cus.getAddress();
							  
							  boolean isBdayValid;
							  do {
								  isBdayValid = false;
								    try {
								    	System.out.print("Enter date of birth (yyyy-mm-dd): ");
										String birthday = sc.next();
										bday = LocalDate.parse(birthday);
								    } catch (Exception e) {
								    	System.out.println("********PLEASE ENTER DATE ACCORDING TO REQURED DATE FORMAT********"); 
								        isBdayValid = true;  // This is what will get the program to loop back
								        sc.nextLine();
								    }
								} while (isBdayValid);
							  
							  System.out.print("Enter driver's license no: ");
							  driversLicenseNo = sc.next();
							  
							  boolean isLicenseValid;
							  do {
								  isLicenseValid = false;
								    try {
										System.out.print("Enter date on which driver’s license was first issued (yyyy-mm-dd): ");
										String licenseDateIssued = sc.next();
										System.out.println();
										licenseDateFirstIssued = LocalDate.parse(licenseDateIssued);
										licenseYear = licenseDateFirstIssued.getYear();
								    } catch (Exception e) {
								    	System.out.println("********PLEASE ENTER DATE ACCORDING TO REQURED DATE FORMAT********"); 
								        isLicenseValid = true;  // This is what will get the program to loop back
								        sc.nextLine();
								    }
								} while (isLicenseValid);
						  } else if (answer.equalsIgnoreCase("n")) {
							  System.out.println("~ Policy Holder Details ~");
							  System.out.print("Enter first name: ");
							  fName = sc.nextLine() + sc.nextLine();
							  System.out.print("Enter last name: ");
							  lName = sc.nextLine();
							  
							  boolean isBdayValid;
							  do {
								  isBdayValid = false;
								    try {
								    	System.out.print("Enter date of birth (yyyy-mm-dd): ");
										String birthday = sc.next();
										bday = LocalDate.parse(birthday);
								    } catch (Exception e) {
								    	System.out.println("********PLEASE ENTER DATE ACCORDING TO REQURED DATE FORMAT********"); 
								        isBdayValid = true;  // This is what will get the program to loop back
								        sc.nextLine();
								    }
								} while (isBdayValid);
							  
							  System.out.print("Enter address: ");
							  policyHolderAddress = sc.nextLine() + sc.nextLine();
							  System.out.print("Enter driver's license no: ");
							  driversLicenseNo = sc.next();
							  
//							  boolean isLicenseValid;
//							  do {
//								  isLicenseValid = false;
//								    try {
//										  System.out.print("Enter date on which driver’s license was first issued (yyyy-mm-dd): ");
//										  String licenseDateIssued = sc.next();
//										  System.out.println();
//										  licenseDateFirstIssued = LocalDate.parse(licenseDateIssued);
//										  licenseYear = licenseDateFirstIssued.getYear();
//								    } catch (Exception e) {
//								        System.out.println("Please enter date according to required date format."); 
//								        isLicenseValid = true;  // This is what will get the program to loop back
//								        sc.nextLine();
//								    }
//								} while (isLicenseValid);
							  
//							  System.out.print("Enter date on which driver’s license was first issued (yyyy-mm-dd): ");
//							  String licenseDateIssued = sc.nextLine();
//							  licenseDateFirstIssued = LocalDate.parse(licenseDateIssued);
//							  licenseYear = licenseDateFirstIssued.getYear();
						  }
						  cus.policies.get(cus.policies.size()-1).setPolicyHolder(fName, lName, bday, policyHolderAddress, driversLicenseNo, licenseDateFirstIssued);
						
						  
						  int numOfVehicle = 0;
						  numOfVehicle = validateNumber("Please enter number of vehicle: ");
//						  boolean isNumber;
//						  do {
//							  isNumber = false;
//							  try {
//								  System.out.print("Please enter number of vehicle: ");
//								  numOfVehicle = sc.nextInt();
//							  } catch(Exception e) {
//								  System.out.println("********INVALID INPUT. PLEASE ENTER A NUMBER********");
//								  sc.next();
//								  isNumber = true;
//							  }
//						  } while(isNumber);
						 
						  
						  System.out.println();
						  if(numOfVehicle <= 1) {
							  System.out.println("~ Vehicle Details ~");
						  } else {
							  System.out.println("~ Vehicles Details ~");
						  }
						  
						  for(int i = 0; i < numOfVehicle; i++) {
							  System.out.println("Vehicle " + (i + 1));
							  System.out.print("Enter make: ");
							  String make = sc.nextLine() + sc.nextLine();
							  System.out.print("Enter model: ");
							  String model = sc.nextLine();
							  int year = validateNumber("Enter year: ");
							  System.out.print("Enter type: ");
							  String type = sc.nextLine();
							  System.out.print("Enter fuel type: ");
							  String fuelType = sc.nextLine();
							  System.out.print("Enter purchase price: ");
							  double purchasePrice = sc.nextDouble();
							  sc.nextLine();
							  System.out.print("Enter color: ");
							  String color = sc.next();
							
							  RatingEngine ratingEngine = new RatingEngine(year, purchasePrice, licenseYear);
							  System.out.print("Premium charged for this specific vehicle: " + String.format("$%.2f", ratingEngine.getCalculatedPremium()));
							  System.out.println();
							  cus.policies.get(cus.policies.size()-1).addVehicles(make, model, year, type, fuelType, purchasePrice, color, ratingEngine.getCalculatedPremium());
							  
							  Policy.policyPremium += ratingEngine.getCalculatedPremium();
							  System.out.println();
						  }
						  System.out.println("===============================");
						  System.out.println("Policy premium amount: " + String.format("$%.2f", Policy.policyPremium));
						  System.out.println("===============================");
						  Policy.policyPremium = 0;
						  String policyNum = cus.policies.get(cus.policies.size()-1).getPolicyNo();
						  System.out.println();
						  System.out.print("Buy Policy? <y/n>: ");
						  String ans = sc.next();
						  System.out.println();
						  if(ans.equalsIgnoreCase("y")) {
							  System.out.println("********POLICY CREATED SUCCESSFULLY********");
							  System.out.println("New policy created with policy no: " + policyNum);
						  } else if(ans.equalsIgnoreCase("n")) {
							  cus.policies.remove(cus.policies.size()-1);
							  System.out.println("********THANK YOU FOR INQUIRING********");
						  } else {
							  System.out.println("Please enter Y or N only");
						  }
						  System.out.println();
					  }
				  }
					if(match == 0) {
						System.out.println("********ACCOUNT NOT FOUND. PLEASE TRY AGAIN********");
						match = 0;
						System.out.println();
					}
				  break;
				
			  case 3:
				  System.out.println();
				  System.out.print("Enter policy no: ");
				  String policyNo = sc.next();
				  int policyMatch = 0;
				  for(CustomerAccount cust : customerList) {
					  for(int i = 0; i < cust.policies.size(); i++) {
						  if(cust.policies.get(i).getPolicyNo().equals(policyNo)) {
							  policyMatch++;
							  System.out.println("********POLICY FOUND********");
							  System.out.println("Current Effective Date: " + cust.policies.get(i).getEffectiveDate());
							  System.out.println("Current Expiration Date: " + cust.policies.get(i).getExpirationDate());

							  boolean invalidInput;
							  do {
								    invalidInput = false;
								    try {
								    	System.out.print("Enter new expiration Date (yyyy-mm-dd): ");
										String newExpirationDate = sc.next();
										LocalDate newExpDate = LocalDate.parse(newExpirationDate);
										 if(newExpDate.isBefore(cust.policies.get(i).getEffectiveDate())) {
											  System.out.println("exp date cannot be earlier than effective date");
										  } else if(newExpDate.isAfter(cust.policies.get(i).getExpirationDate())) {
											  System.out.println("exp date cannot be later than current expiration date");
										  } else {
											  cust.policies.get(i).setNewExpirationDate(newExpirationDate);
											  System.out.println("********POLICY CANCELLED********");
											  System.out.println("The new expiration date is: " + cust.policies.get(i).getExpirationDate());
										  }
								    } catch (Exception e) {
								        System.out.println("Please enter date according to required date format."); 
								        invalidInput = true;  // This is what will get the program to loop back
								        sc.nextLine();
								    }
								} while (invalidInput);
							  System.out.println();
						  }
					  }
				  }
				  if(policyMatch == 0) {
					  System.out.println("********POLICY NOT FOUND. PLEASE TRY AGAIN********");
					  policyMatch = 0;
					  System.out.println();
				  }
				break;
				
			  case 4:
				  System.out.println();
				  System.out.print("Enter policy number: ");
				  String policyNum = sc.next();
				  int polMatch = 0;
				  for(CustomerAccount customer : customerList) {
					  for(int i = 0; i < customer.policies.size(); i++) {
						  if(customer.policies.get(i).getPolicyNo().equals(policyNum)) {
							  polMatch++;
							  System.out.println("Policy Found!");
							  System.out.print("Enter date of accident (yyyy-mm-dd): ");
							  String accidentDate = sc.next() + sc.nextLine();
							  System.out.print("Enter address where accident happened: ");
							  String accidentAddress = sc.nextLine();
							  System.out.print("Enter description of accident: ");
							  String accidentDescription = sc.nextLine();
							  System.out.print("Enter description of damage to vehicle: ");
							  String damageDescription = sc.nextLine();
							  System.out.print("Enter estimated cost of repairs: ");
							  double costOfRepairs = sc.nextDouble();
							  customer.policies.get(i).setClaim(accidentDate, accidentAddress, accidentDescription, damageDescription, costOfRepairs);
							  String currClaimNo = customer.policies.get(customer.policies.size()-1).claim.getClaimNo();
							  System.out.println("New claim created with Claim No: " + currClaimNo);
						  }
					  }
				  }
				  if(polMatch == 0) {
					  System.out.println("********POLICY NOT FOUND. PLEASE TRY AGAIN.********");
					  polMatch = 0;
					  System.out.println();
				  }
				  System.out.println();
				break;
				
			  case 5:	  
				  System.out.println();
				  sc.nextLine();
				  System.out.print("Enter first name: ");
				  String cusFName = sc.nextLine();
				  System.out.print("Enter last name: ");
				  String cusLName = sc.nextLine();
				  System.out.println();
				  int matchName = 0;
				  for(CustomerAccount cusAcc : customerList) {
					  if(cusAcc.getFirstName().equals(cusFName) && cusAcc.getLastName().equals(cusLName)) {
						  matchName++;
						  System.out.println("~ Customer Account Details ~");
						  System.out.println("Account no: " + cusAcc.getAccNo());
						  System.out.println("First name: " + cusAcc.getFirstName());
						  System.out.println("Last name: " + cusAcc.getLastName());
						  System.out.println("Address: " + cusAcc.getAddress());
						  System.out.println();
						  System.out.println("~ List of Policies ~");
						  if(cusAcc.policies.size() != 0) {
							  for(Policy pol : cusAcc.getPolicies()) {
								  System.out.println(pol.getPolicyNo() + " -> " + pol.getPolicyHolder().getFirstName() + " " + pol.getPolicyHolder().getLastName());
							  }
						  } else {
							  System.out.println("--");
						  }
					  }
				  }
				  if(matchName == 0) {
					  System.out.println("********ACCOUNT NOT FOUND. PLEASE TRY AGAIN.********");
					  matchName = 0;
					  
				  }
				  System.out.println();
				  break;
				
			  case 6:
				  System.out.println();
				  System.out.print("Enter policy number: ");
				  String policyNumber = sc.nextLine() + sc.nextLine();
				  System.out.println();
				  int polNumMatch = 0;
				  for(CustomerAccount customerAcc : customerList) {
					  for(int i = 0; i < customerAcc.policies.size(); i++) {
						  if(customerAcc.policies.get(i).getPolicyNo().equals(policyNumber)) {
							  polNumMatch++;
							  System.out.println();
							  System.out.println("~ Policy Details ~");
							  String polNum = customerAcc.policies.get(i).getPolicyNo();
							  System.out.println("Policy No: " + polNum);
							  LocalDate effDate = customerAcc.policies.get(i).getEffectiveDate();
							  System.out.println("Effective Date: " + effDate);
							  LocalDate expirationDate = customerAcc.policies.get(i).getExpirationDate();
							  System.out.println("Expiration Date: " + expirationDate);
							  System.out.println();
							  System.out.println("~ Policy Holder Details ~");
							  PolicyHolder policyHolder = customerAcc.policies.get(i).getPolicyHolder();
							  String fName = policyHolder.getFirstName();
							  String lName = policyHolder.getLastName();
							  LocalDate bday = policyHolder.getBirthDate();
							  String polHolderAddress = policyHolder.getAddress();
							  String licenseNo = policyHolder.getDriversLicense();
							  LocalDate driversLicenseFirstIssued = policyHolder.getDriversLicenseFirstIssued();
							  System.out.println("First Name: " + fName);
							  System.out.println("Last Name: " + lName);
							  System.out.println("Birthday: " + bday);
							  System.out.println("Address: " + polHolderAddress);
							  System.out.println("Driver’s license number: " + licenseNo);
							  System.out.println("Date on which driver’s license was first issued: " + driversLicenseFirstIssued);
							  System.out.println();
							  System.out.println("~ Vehicle Details ~");
							  for(Vehicle veh : customerAcc.policies.get(i).getVehicles()) {
								  System.out.println("Make: " + veh.getMake());
								  System.out.println("Model: " + veh.getModel());
								  System.out.println("Year: " + veh.getYear());
								  System.out.println("Type: " + veh.getType());
								  System.out.println("Fuel Type: " + veh.getFuelType());
								  System.out.println("Purchase Price: " + String.format("$%.2f", veh.getPurchasePrice()));
								  System.out.println("Color: " + veh.getColor());
								  System.out.println("Premium Charge: " + String.format("$%.2f", veh.getPremiumCharge()));
								  Policy.policyPremium += veh.getPremiumCharge();
								  System.out.println();
							  }
							  System.out.println("===============================");
							  System.out.println("Policy premium amount: " + String.format("$%.2f", Policy.policyPremium));
							  System.out.println("===============================");
							  Policy.policyPremium = 0; //reset
							  System.out.println();
						  }
					  }
				  }
				  if(polNumMatch == 0) {
					  System.out.println("********POLICY NOT FOUND. PLEASE TRY AGAIN.********");
					  polNumMatch = 0;
					  System.out.println();
				  }
				  break;
				
			  case 7:
				  System.out.println();
				  System.out.print("Enter claim number: ");
				  String claimNo = sc.next();
				  System.out.println();
				  int claimMatch = 0;
				  for(CustomerAccount cusAcc : customerList) {
					  for(int i = 0; i < cusAcc.policies.size(); i++) {
						  if(cusAcc.policies.get(i).getClaim() == null) {
							  System.out.println("CLAIM NOT FOUND!!!");
						  }
						  else if(cusAcc.policies.get(i).getClaim().getClaimNo().equals(claimNo)) {
							  claimMatch++;
							  System.out.println("~ Claim Details ~");
							  String claimNum = cusAcc.policies.get(i).getClaim().getClaimNo();
							  System.out.println("Claim Number: " + claimNum);
							  LocalDate dateOfAccident = cusAcc.policies.get(i).getClaim().getAccidentDate();
							  System.out.println("Date of accident: " + dateOfAccident);
							  String addressOfAccident = cusAcc.policies.get(i).getClaim().getAccidentAddress();
							  System.out.println("Address where accident happened: " + addressOfAccident);
							  String descriptionOfAccident = cusAcc.policies.get(i).getClaim().getAccidentDescription();
							  System.out.println("Description of accident: " + descriptionOfAccident);
							  String descriptionOfDamage = cusAcc.policies.get(i).getClaim().getDamageDescription();
							  System.out.println("Description of damage to vehicle: " + descriptionOfDamage);
							  double estCostOfRepairs = cusAcc.policies.get(i).getClaim().getCostOfRepairs();
							  System.out.println("Estimated cost of repairs: " + String.format("$%.2f", estCostOfRepairs));
							  System.out.println();
						  }
					  }
				  }
				  if(claimMatch == 0) {
					  System.out.println("⚠CLAIM NOT FOUND. PLEASE TRY AGAIN.⚠");
					  claimMatch = 0;
					  System.out.println();
				  }
				break;
				
			  case 8: 
				  System.out.println();
				  System.out.println("*****************THANK YOU!*****************");
				  break;
				
			  default:
				  System.out.println();
				  System.out.println("********PLEASE ENTER A NUMBER FROM 1-8*********");
				  System.out.println();
				  break;
			}
			
		} while(choice != 8);
		sc.close();
	}
	
	public static int validateNumber(String userInput) {
		Scanner sc = new Scanner(System.in);
		
		 boolean isNumber;
		  do {
			  isNumber = false;
			  try {
				  System.out.print(userInput);
				  int num = sc.nextInt();
				  return num;
			  } catch(Exception e) {
				  System.out.println("********INVALID INPUT. PLEASE ENTER A NUMBER********");
				  sc.next();
				  isNumber = true;
			  }
		  } while(isNumber);
		  sc.close();
		return 0;
	}
	
//	public static LocalDate validateDate(String userInput) {
//		Scanner sc = new Scanner(System.in);
//		boolean isDateFormatValid;
//		  do {
//			  isDateFormatValid = false;
//			    try {
//			    	 System.out.print("Enter effective date (yyyy-mm-dd): ");
//					  String effectiveDate = sc.next();
//					  cus.addPolicy(effectiveDate);
//					  LocalDate policyExpirationDate = cus.policies.get(cus.policies.size()-1).getExpirationDate();
//					  System.out.println("Your policy coverage will expire on " + policyExpirationDate);
//					  System.out.println();
//					  sc.nextLine();
//			    } catch (Exception e) {
//			        System.out.println("********PLEASE ENTER DATE ACCORDING TO REQURED DATE FORMAT********"); 
//			        isDateFormatValid = true;  // This is what will get the program to loop back
//			        sc.nextLine();
//			    }
//			} while (isDateFormatValid);
//		
//		return LocalDate.now();
//	}
	
	
	
	
}

