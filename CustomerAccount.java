import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author LemuelLimuco
 *
 */
public class CustomerAccount {
	private ArrayList <Policy> policies = new ArrayList<>();
	private int accountNo;
	private String firstName;
	private String lastName;
	private String address;
	
	public CustomerAccount(String firstName, String lastName, String address) {
		setAccNo();
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
	}
	
	private void setAccNo() {
	    Random rnd = new Random();
	    int number = rnd.nextInt(9999); //Generates a 4-digit random number.
	    this.accountNo = number;
	}
	
	public String getAccNo() {
		String accNo = String.format("%04d", accountNo); //Includes zeroes at the beginning of account number
		return accNo;
	}
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	private void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void addPolicy(LocalDate effectiveDate) {
		policies.add(new Policy(effectiveDate));
	}
	
	public ArrayList <Policy> getPolicies() {
		return policies;
	}
	
}




