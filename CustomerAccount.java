import java.util.ArrayList;
import java.util.Random;

/**
 * @author LemuelLimuco
 *
 */
public class CustomerAccount {
	ArrayList <Policy> policies = new ArrayList<>();
	private int accountNo;
	String firstName;
	String lastName;
	String address;
	
	public CustomerAccount(String firstName, String lastName, String address) {
		setAccNo();
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
	}
	
	private void setAccNo() {
		// It will generate 4 digit random Number.
	    Random rnd = new Random();
	    int number = rnd.nextInt(9999);
	    this.accountNo = number;
	}
	
	public String getAccNo() {
		String accNo = String.format("%04d", accountNo);
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
	
	public void addPolicy(String effectiveDate) {
		policies.add(new Policy(effectiveDate));
	}
	
	public ArrayList <Policy> getPolicies() {
		return policies;
	}
	
}




