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
		ArrayList<CustomerAccount> customerList = new ArrayList<>(); //creates a new customerList array
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("============================================");
			System.out.println("                 PAS SYSTEM");
			System.out.println("============================================");
			System.out.println("1 - Create a new Customer Account");
			System.out.println("2 - Get a policy quote and buy the policy");
			System.out.println("3 - Cancel a specific policy");
			System.out.println("4 - File an accident claim against a policy");
			System.out.println("5 - Search for a Customer account");
			System.out.println("6 - Search for and display a specific policy");
			System.out.println("7 - Search for and display a specific claim");
			System.out.println("8 - Exit the PAS System");
			System.out.println("============================================");
			choice = (int) validateNumber("Enter your choice <1-8>: "); //validates number
			switch(choice) {
			  case 1:
				  System.out.println();
				  System.out.print("Enter first name: ");
				  String firstName = sc.next() + sc.nextLine();
				  System.out.print("Enter last name: ");
				  String lastName = sc.next() + sc.nextLine();
				  System.out.print("Enter address: ");
				  String address = sc.next() + sc.nextLine();
				  customerList.add(new CustomerAccount(firstName, lastName, address)); //adds a CustomerAccount object into customerList array
				  String currentAccNo = customerList.get(customerList.size()-1).getAccNo(); //gets the account number of newly created CustomerAccount object
				  System.out.println();
				  System.out.println("********ACCOUNT CREATED SUCCESSFULLY********");
				  System.out.println();
				  System.out.println("New account created with account no: " + currentAccNo);
				  System.out.println();
				  break;
			    
			  case 2:
				  System.out.println();
				  System.out.print("Enter your 4-digit account number: ");
				  String customerAccNo = sc.next() + sc.nextLine();
				  System.out.println();
				  int match = 0; //checks if an account exists
				  for(CustomerAccount cus : customerList) {
					  if(cus.getAccNo().equals(customerAccNo)) { //checks if entered account number matches with existing account number before allowing user to get a policy quote and buy the policy
						  match++;
						  String fName = null;
						  String lName = null;
						  String policyHolderAddress = null;
						  LocalDate bday = null;
						  String driversLicenseNo = null;
						  LocalDate licenseDateFirstIssued = null;
						  
						  boolean isEffDateValid; //validates date
						  do {
							  isEffDateValid = false;
							    try {
							    	  System.out.print("Enter effective date (yyyy-mm-dd): ");
									  String effDate = sc.next();
									  LocalDate effectiveDate = LocalDate.parse(effDate);
									  if(effectiveDate.isBefore(LocalDate.now())) {
										  System.out.println("********EFFECTIVE DATE CANNOT BE A PREVIOUS DATE********");
										  isEffDateValid = true;
									  } else {
										  cus.addPolicy(effectiveDate);
										  LocalDate policyExpirationDate = cus.getPolicies().get(cus.getPolicies().size()-1).getExpirationDate();
										  System.out.println("Your policy coverage will expire on " + policyExpirationDate);
										  System.out.println();
									  }
									  sc.nextLine();
							    } catch (Exception e) {
							    	System.out.println("********PLEASE ENTER DATE ACCORDING TO REQUIRED DATE FORMAT********"); 
							        isEffDateValid = true; //This is what will get the prompt to loop back
							        sc.nextLine();
							    }
							} while (isEffDateValid);
						  
						  boolean isAnsValid; //validates answer
						  do {
							  isAnsValid = false;
							  System.out.print("Are you also the policy holder? <y/n>: ");
							  String answer = sc.next() + sc.nextLine();
							  System.out.println();
							  if(answer.equalsIgnoreCase("y")) { //doesn't ask for policy holder's first name, last name, and address anymore if customer account is the same with the policy holder
								  fName = cus.getFirstName();
								  lName = cus.getLastName();
								  policyHolderAddress = cus.getAddress();
								  System.out.println("First Name: " + fName.toUpperCase());
								  System.out.println("Last Name: " + lName.toUpperCase());
								  System.out.println("Address: " + policyHolderAddress.toUpperCase());
								  bday = validateDate("Enter date of birth (yyyy-mm-dd): ");
								  System.out.print("Enter driver's license no: ");
								  driversLicenseNo = sc.next() + sc.nextLine();
								  licenseDateFirstIssued = validateDate("Enter date on which driver’s license was first issued (yyyy-mm-dd): ");
							  } else if (answer.equalsIgnoreCase("n")) { 
								  System.out.println("~ Policy Holder Details ~");
								  System.out.print("Enter first name: ");
								  fName = sc.next() + sc.nextLine();
								  System.out.print("Enter last name: ");
								  lName = sc.next() + sc.nextLine();
								  bday = validateDate("Enter date of birth (yyyy-mm-dd): ");
								  System.out.print("Enter address: ");
								  policyHolderAddress = sc.next() + sc.nextLine();
								  System.out.print("Enter driver's license no: ");
								  driversLicenseNo = sc.next() + sc.nextLine();
								  licenseDateFirstIssued = validateDate("Enter date on which driver’s license was first issued (yyyy-mm-dd): ");
							  } else {
								  System.out.println("********PLEASE ENTER Y OR N ONLY********");
								  isAnsValid = true;
							  }
						  } while(isAnsValid);
						  
						  cus.getPolicies().get(cus.getPolicies().size()-1).setPolicyHolder(fName, lName, bday, policyHolderAddress, driversLicenseNo, licenseDateFirstIssued); //adds a new policy holder object to the current policy object
						
						  int numOfVehicle = 0;
						  numOfVehicle = (int) validateNumber("Please enter number of vehicles: ");
						  System.out.println();
						  if(numOfVehicle == 1) {
							  System.out.println("~ Vehicle Details ~");
						  } else if(numOfVehicle > 1) {
							  System.out.println("~ Vehicles Details ~");
						  } else {
							  System.out.println("********NUMEBR CANNOT BE NEGATIVE********");
							  numOfVehicle = (int) validateNumber("Please enter number of vehicles: ");
							  System.out.println();
						  }
						  
						  RatingEngine ratingEngine = null;
						  for(int i = 0; i < numOfVehicle; i++) { //loops depend on number of vehicle entered
							  System.out.println("Vehicle " + (i + 1));
							  System.out.print("Enter make: ");
							  String make = sc.next() + sc.nextLine();
							  System.out.print("Enter model: ");
							  String model = sc.next() + sc.nextLine();
							  int year = (int) validateNumber("Enter year (yyyy): ");
							  System.out.print("Enter type: ");
							  String type = sc.next() + sc.nextLine();
							  System.out.print("Enter fuel type: ");
							  String fuelType = sc.next() + sc.nextLine();
							  double purchasePrice = validateNumber("Enter purchase price: ");
							  System.out.print("Enter color: ");
							  String color = sc.next() + sc.nextLine();
							
							  ratingEngine = new RatingEngine(year, purchasePrice, licenseDateFirstIssued); //creates a new ratingEngine object that calculates the premium for each vehicle
							  System.out.print("Premium charged for this specific vehicle: " + String.format("$%.2f", ratingEngine.getCalculatedPremium()));
							  System.out.println();
							  cus.getPolicies().get(cus.getPolicies().size()-1).addVehicles(make, model, year, type, fuelType, purchasePrice, color, ratingEngine.getCalculatedPremium()); //adds vehicle object/s to the current policy object
							  cus.getPolicies().get(cus.getPolicies().size()-1).setPremiumTotal(ratingEngine.getPremiumTotal()); //sets the total policy premium of the current policy object
							  System.out.println();
						  }
						  System.out.println("============================================");
						  System.out.println("Policy premium amount: " + String.format("$%.2f", cus.getPolicies().get(cus.getPolicies().size()-1).getPremiumTotal()));
						  System.out.println("============================================");
						  ratingEngine.resetPremiumTotal(); //sets the premium total to zero
						  String policyNum = cus.getPolicies().get(cus.getPolicies().size()-1).getPolicyNo();
						  System.out.println();
						  
						  boolean isAnswerValid; 
						  do {
							  isAnswerValid = false;
							  System.out.print("Buy Policy? <y/n>: ");
							  String ans = sc.next() + sc.nextLine();
							  System.out.println();
							  if(ans.equalsIgnoreCase("y")) {
								  System.out.println("********POLICY BOUGHT SUCCESSFULLY********");
								  System.out.println();
								  System.out.println("New policy bought with policy no: " + policyNum);
							  } else if(ans.equalsIgnoreCase("n")) {
								  cus.getPolicies().remove(cus.getPolicies().size()-1);
								  System.out.println("********THANK YOU FOR INQUIRING********");
							  } else {
								  System.out.println("********PLEASE ENTER Y OR N ONLY********");
								  isAnswerValid = true;
							  }
						  } while (isAnswerValid);
						  System.out.println();
					  }
				  }
					if(match == 0) { 
						System.out.println("********ACCOUNT NOT FOUND. PLEASE TRY AGAIN********");
						System.out.println();
						match = 0;
					}
				  break;
				
			  case 3:
				  System.out.println();
				  System.out.print("Enter your 6-digit policy no: ");
				  String policyNo = sc.next() + sc.nextLine();
				  System.out.println();
				  int policyMatch = 0;
				  for(CustomerAccount cust : customerList) {
					  for(Policy policy : cust.getPolicies()) {
						  if(policy.getPolicyNo().equals(policyNo)) { //checks if entered policy number matches with existing policy number before allowing user to cancel a policy
							  policyMatch++;
							  System.out.println("--------------------------------------------");
							  System.out.println("Effective Date: " + policy.getEffectiveDate());
							  System.out.println("--------------------------------------------");
							  System.out.println("Current Expiration date: " + policy.getExpirationDate());
							  System.out.println("--------------------------------------------");
							  System.out.println();
							  
							  boolean invalidInput; //validates expiration date entered
							  do {
								    invalidInput = false;
								    try {
								    	System.out.print("Enter new expiration date (yyyy-mm-dd): ");
										String newExpDate = sc.next();
										LocalDate newExpirationDate = LocalDate.parse(newExpDate);
										 if(newExpirationDate.isBefore(policy.getEffectiveDate())) {
											  System.out.println("********NEW EXPIRATION DATE CANNOT BE EARLIER THAN EFFECTIVE DATE********");
											  invalidInput = true;
										  } else if(newExpirationDate.isEqual(policy.getEffectiveDate())) {
											  System.out.println("********NEW EXPIRATION DATE CANNOT BE THE SAME WITH EFFECTIVE DATE*********");
											  invalidInput = true;
										  } else if(newExpirationDate.isAfter(policy.getExpirationDate())) {
											  System.out.println("********NEW EXIPIRATION DATE CANNOT BE LATER THAN CURRENT EXPIRATION DATE********");
											  invalidInput = true;
										  } else if(newExpirationDate.isEqual(policy.getExpirationDate())) {
											  System.out.println("********PLEASE ENTER NEW EXPIRATION DATE EARLIER THAN CURRENT EXPIRATION DATE********");
											  invalidInput = true;
										  } else {
											  policy.setNewExpirationDate(newExpirationDate);
											  System.out.println();
											  System.out.println("********POLICY CANCELLED SUCCESSFULLY********");
											  System.out.println();
											  System.out.println("The policy's new expiration date is: " + policy.getExpirationDate());
										  }
								    } catch (Exception e) {
								    	System.out.println("********PLEASE ENTER DATE ACCORDING TO REQUIRED DATE FORMAT********"); 
								        invalidInput = true;
								        sc.nextLine();
								    }
								} while (invalidInput);
							  System.out.println();
						  }
					  }
				  }
				  if(policyMatch == 0) {
					  System.out.println("********POLICY NOT FOUND. PLEASE TRY AGAIN********");
					  System.out.println();
					  policyMatch = 0;
				  }
				break;
				
			  case 4:
				  System.out.println();
				  System.out.print("Enter your 6-digit policy number: ");
				  String policyNum = sc.next() + sc.nextLine();
				  System.out.println();
				  int polMatch = 0;
				  for(CustomerAccount customer : customerList) {
					  for(int i = 0; i < customer.getPolicies().size(); i++) {
						  if(customer.getPolicies().get(i).getPolicyNo().equals(policyNum)) { //checks if entered policy number matches with existing policy number before allowing user to file a claim
							  polMatch++;
							  LocalDate accidentDate = validateDate("Enter date of accident (yyyy-mm-dd): ");
							  System.out.print("Enter address where accident happened: ");
							  String accidentAddress = sc.next() + sc.nextLine();
							  System.out.print("Enter description of accident: ");
							  String accidentDescription = sc.next() + sc.nextLine();
							  System.out.print("Enter description of damage to vehicle: ");
							  String damageDescription = sc.nextLine();
							  double costOfRepairs = validateNumber("Enter estimated cost of repairs: ");
							 
							  customer.getPolicies().get(i).addClaims(accidentDate, accidentAddress, accidentDescription, damageDescription, costOfRepairs); //creates a new claim
							  
							  ArrayList<Claim> claims = customer.getPolicies().get(i).getClaims();
							  String currentClaimNo = customer.getPolicies().get(i).getClaims().get(claims.size()-1).getClaimNo();
							  System.out.println();
							  System.out.println("********CLAIM CREATED SUCCESSFULLY********");
							  System.out.println();
							  System.out.println("New claim created with Claim No: " + currentClaimNo);
						  }
					  }
				  }
				  if(polMatch == 0) {
					  System.out.println("********POLICY NOT FOUND. PLEASE TRY AGAIN********");
					  System.out.println();
					  polMatch = 0;
				  }
				  System.out.println();
				break;
				
			  case 5:	  
				  System.out.println();
				  System.out.print("Enter first name: ");
				  String cusFName = sc.next() + sc.nextLine();
				  System.out.print("Enter last name: ");
				  String cusLName = sc.next() + sc.nextLine();
				  System.out.println();
				  int matchName = 0;
				  for(CustomerAccount cusAcc : customerList) {
					  if(cusAcc.getFirstName().equals(cusFName) && cusAcc.getLastName().equals(cusLName)) { //displays all the details of a customer account
						  matchName++;
						  System.out.println("--------------------------------------------");
						  System.out.println("~ Customer Account Details ~");
						  System.out.println("--------------------------------------------");
						  System.out.println("Account No: " + cusAcc.getAccNo());
						  System.out.println("First Name: " + cusAcc.getFirstName().toUpperCase());
						  System.out.println("Last Name: " + cusAcc.getLastName().toUpperCase());
						  System.out.println("Address: " + cusAcc.getAddress().toUpperCase());
						  System.out.println();
						  System.out.println("--------------------------------------------");
						  System.out.println("~ List of Policy Holders and their Policies ~");
						  System.out.println("--------------------------------------------");
						  if(cusAcc.getPolicies().size() != 0) {
							  int count = 0;
							  for(Policy pol : cusAcc.getPolicies()) {
								  count++;
								  String cusFirstName = pol.getPolicyHolder().getFirstName();
								  String cusLastName = pol.getPolicyHolder().getLastName();
								  System.out.println(count + ". " + cusFirstName.toUpperCase() + " " + cusLastName.toUpperCase() + " - " + pol.getPolicyNo());
								  System.out.println();
							  }
						  } else {
							  System.out.println("--");
						  }
					  }
				  }
				  if(matchName == 0) {
					  System.out.println("********ACCOUNT NOT FOUND. PLEASE TRY AGAIN********");
					  matchName = 0;
				  }
				  System.out.println();
				  break;
				
			  case 6:
				  System.out.println();
				  System.out.print("Enter policy number: ");
				  String policyNumber = sc.next() + sc.nextLine();
				  System.out.println();
				  int polNumMatch = 0;
				  for(CustomerAccount customerAcc : customerList) {
					  for(Policy policy : customerAcc.getPolicies()) {
						  if(policy.getPolicyNo().equals(policyNumber)) { //displays all the information associated with policy
							  polNumMatch++;
							  System.out.println("--------------------------------------------");
							  System.out.println("~ Policy Details ~");
							  System.out.println("--------------------------------------------");
							  System.out.println("Policy No: " + policy.getPolicyNo());
							  System.out.println("Effective Date: " + policy.getEffectiveDate());
							  System.out.println("Expiration Date: " + policy.getExpirationDate());
							  System.out.println();
							  System.out.println("--------------------------------------------");
							  System.out.println("~ Policy Holder Details ~");
							  System.out.println("--------------------------------------------");
							  System.out.println("First Name: " + policy.getPolicyHolder().getFirstName().toUpperCase());
							  System.out.println("Last Name: " + policy.getPolicyHolder().getLastName().toUpperCase());
							  System.out.println("Birthday: " + policy.getPolicyHolder().getBirthDate());
							  System.out.println("Address: " + policy.getPolicyHolder().getAddress().toUpperCase());
							  System.out.println("Driver’s License Number: " + policy.getPolicyHolder().getDriversLicense());
							  System.out.println("Date on which driver’s license was first issued: " + policy.getPolicyHolder().getDriversLicenseFirstIssued());
							  System.out.println();
							  System.out.println("--------------------------------------------");
							  System.out.println("~ Vehicle Details ~");
							  System.out.println("--------------------------------------------");
							  int count = 0;
							  for(Vehicle veh : policy.getVehicles()) {
								  count++;
								  System.out.println("Vehicle " + count);
								  System.out.println("Make: " + veh.getMake());
								  System.out.println("Model: " + veh.getModel());
								  System.out.println("Year: " + veh.getYear());
								  System.out.println("Type: " + veh.getType());
								  System.out.println("Fuel Type: " + veh.getFuelType());
								  System.out.println("Purchase Price: " + String.format("$%.2f", veh.getPurchasePrice()));
								  System.out.println("Color: " + veh.getColor());
								  System.out.println("Premium Charge: " + String.format("$%.2f", veh.getPremiumCharge()));
								  System.out.println();
							  }
							  System.out.println("============================================");
							  System.out.println("Policy premium amount: " + String.format("$%.2f", policy.getPremiumTotal()));
							  System.out.println("============================================");
							  System.out.println();
							  System.out.println("--------------------------------------------");
							  System.out.println();
						  }
					  }
				  }
				  if(polNumMatch == 0) {
					  System.out.println("********POLICY NOT FOUND. PLEASE TRY AGAIN.********");
					  System.out.println();
					  polNumMatch = 0;
				  }
				  break;
				
			  case 7:
				  System.out.println();
				  System.out.print("Enter claim number: ");
				  String claimNo = sc.next() + sc.nextLine();
				  System.out.println();
				  int claimMatch = 0;
				  for(CustomerAccount cusAcc : customerList) {			  
					  for(Policy policy : cusAcc.getPolicies()) {
						  for(Claim claim : policy.getClaims()) {
							  if(claim.getClaimNo().equals(claimNo)) { //displays claim details if user entered claim number matches with existing claim number
								  claimMatch++;
								  System.out.println("--------------------------------------------");
								  System.out.println("~ Claim Details ~");
								  System.out.println("--------------------------------------------");
								  System.out.println("Claim No: " + claim.getClaimNo()); 
								  System.out.println("Date of Accident: " + claim.getAccidentDate());
								  System.out.println("Address Where Accident Happened: " + claim.getAccidentAddress());
								  System.out.println("Description of Accident: " + claim.getAccidentDescription());
								  System.out.println("Description of Damage to Vehicle: " + claim.getDamageDescription());
								  System.out.println("Estimated Cost of Repairs: " + String.format("$%.2f", claim.getCostOfRepairs()));
								  System.out.println();
							  }
						  }
					  }
				  }
				  if(claimMatch == 0) {
					  System.out.println("********CLAIM NOT FOUND. PLEASE TRY AGAIN********");
					  System.out.println();
					  claimMatch = 0;
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
	
	public static double validateNumber(String prompt) { //method for number validation
		Scanner sc = new Scanner(System.in);
		
		 boolean isNumber;
		  do {
			  isNumber = false;
			  try {
				  System.out.print(prompt);
				  if(prompt.contains("year")) {
					  int year = sc.nextInt();
					  LocalDate dateNow = LocalDate.now();
					  int currentYear = dateNow.getYear();
					  if(year >= 1885 && year <= currentYear) {
						  return year;
					  } else {
						  System.out.println("********PLEASE ENTER A VALID YEAR********");
						  return validateNumber(prompt);
					  }
				  } else if(prompt.contains("choice") || prompt.contains("number")) {
					  int number;
					  String userInput = sc.nextLine();
					  number = Integer.parseInt(userInput);
					  return number;
				  } else if(prompt.contains("price") || prompt.contains("cost")) {
					  double number = sc.nextDouble();
					  if(number == 0) {
						  System.out.println("********0 IS NOT ALLOWED. PLEASE ENTER A VALUE MORE THAN ZERO********");
						  return validateNumber(prompt);
					  } else if(number < 1) {
						  System.out.println("********NEGATIVE VALUE IS NOT ALLOWED. PLEASE ENTER A VALUE MORE THAN ZERO********");
						  return validateNumber(prompt);
					  } 
					  else {
						  return number;
					  }
				  }
			  } catch(Exception e) {
				  if(prompt.contains("year")) {
					  System.out.println("********INVALID INPUT. PLEASE ENTER YEAR IN NUMBERS********");
					  sc.next();
					  isNumber = true; //This is what will get the prompt to loop back
				  } else if(prompt.contains("choice")) {
					  System.out.println("********INVALID INPUT. PLEASE ENTER A NUMBER FROM 1-8********");
					  isNumber = true;
				  } else if(prompt.contains("price") || prompt.contains("cost")) {
					  System.out.println("********INVALID INPUT. PLEASE ENTER NUMBERS ONLY********");
					  sc.next();
					  isNumber = true;
				  } else {
					  System.out.println("********INVALID INPUT. PLEASE ENTER NUMBERS ONLY********");
					  isNumber = true;
				  }
			  }
		  } while(isNumber);
		  sc.close();
		return 0;
	}
	
	public static LocalDate validateDate(String prompt) { //method for date validation
		Scanner sc = new Scanner(System.in);
		boolean isDateFormatValid;
		  do {
			  isDateFormatValid = false;
			    try {
			    	System.out.print(prompt);
			    	if(prompt.contains("birth")) {
			    		String dateEntered = sc.next();
						LocalDate date = LocalDate.parse(dateEntered);
						if(date.isBefore(LocalDate.now())) {
							return date;
						} else {
							System.out.println("********BIRTHDATE CANNOT BE A FUTURE DATE********");
							return validateDate(prompt);
						}
			    	} else if(prompt.contains("license")) {
			    		String dateEntered = sc.next();
						LocalDate date = LocalDate.parse(dateEntered);
			    		if(date.isAfter(LocalDate.now())) {
			    			System.out.println("********DRIVER'S LICENSE FIRST ISSUED DATE CANNOT BE A FUTURE DATE********");
			    			return validateDate(prompt);
			    		} else {
			    			return date;
			    		}
			    	} else if(prompt.contains("accident")) {
			    		String dateEntered = sc.next();
						LocalDate date = LocalDate.parse(dateEntered);
			    		if(date.isAfter(LocalDate.now())) {
			    			System.out.println("********ACCIDENT DATE CANNOT BE A FUTURE DATE********");
			    			return validateDate(prompt);
			    		} else {
			    			return date;
			    		}
			    	} else {
			    		String dateEntered = sc.next();
						LocalDate date = LocalDate.parse(dateEntered);
						return date;
			    	}
			    } catch (Exception e) {
			    	System.out.println("********PLEASE ENTER DATE ACCORDING TO REQUIRED DATE FORMAT********"); 
			        isDateFormatValid = true;
			    }
			} while (isDateFormatValid);
		sc.close();
		return null;
	}
}

