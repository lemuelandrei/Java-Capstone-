import java.time.LocalDate;
import java.util.Random;

/**
 * 
 */

/**
 * @author LemuelLimuco
 *
 */
public class Claim {
	int claimNo;
	LocalDate accidentDate; 
	String accidentAddress;
	String accidentDescription;
	String damageDescription;
	double costOfRepairs;
	
	public Claim(String accidentDate, String accidentAddress, String accidentDescription, String damageDescription, double costOfRepairs) {
		setClaimNo();
		setAccidentDate(accidentDate);
		setAccidentAddress(accidentAddress);
		setAccidentDescription(accidentDescription);
		setDamageDescription(damageDescription);
		setCostOfRepairs(costOfRepairs);
	}
	
	public void setClaimNo() {
		Random rnd = new Random();
		int number = rnd.nextInt(99999);
		this.claimNo = number;
	}
	
	public String getClaimNo() {
		String claimNumber = String.format("C%05d", claimNo);
		return claimNumber;
	}
	
	public void setAccidentDate(String accidentDate) {
		LocalDate dateOfAccident = LocalDate.parse(accidentDate);
		this.accidentDate = dateOfAccident;
	}
	
	public LocalDate getAccidentDate() {
		return accidentDate;
	}
	
	public void setAccidentAddress(String accidentAddress) {
		this.accidentAddress = accidentAddress;
	}
	
	public String getAccidentAddress() {
		return accidentAddress;
	}
	
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	
	public String getAccidentDescription() {
		return accidentDescription;
	}
	
	public void setDamageDescription(String damageDescription) {
		this.damageDescription = damageDescription;
	}
	
	public String getDamageDescription() {
		return damageDescription;
	}
	
	public void setCostOfRepairs(double costOfRepairs) {
		this.costOfRepairs = costOfRepairs;
	}
	
	public double getCostOfRepairs() {
		return this.costOfRepairs;
	}
	
}
