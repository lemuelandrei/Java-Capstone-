import java.time.LocalDate;

/**
 * @author LemuelLimuco
 *
 */
public class PolicyHolder {
	String firstName;
	String lastName;
	LocalDate birthDate;
	String address;
	String driversLicenseNo;
	LocalDate driversLicenseFirstIssued;
	
	public PolicyHolder(String firstName, String lastName, LocalDate birthDate, String address, String driversLicenseNo, LocalDate driversLicenseFirstIssued) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.driversLicenseNo = driversLicenseNo;
		this.driversLicenseFirstIssued = driversLicenseFirstIssued;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getDriversLicense() {
		return driversLicenseNo;
	}
	
	public LocalDate getDriversLicenseFirstIssued() {
		return driversLicenseFirstIssued;
	}
}
