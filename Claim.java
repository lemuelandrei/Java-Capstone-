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
	private int claimNo;
	private LocalDate accidentDate; 
	private String accidentAddress;
	private String accidentDescription;
	private String damageDescription;
	double costOfRepairs;
	
	public Claim(LocalDate accidentDate, String accidentAddress, String accidentDescription, String damageDescription, double costOfRepairs) {
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
	
	public void setAccidentDate(LocalDate accidentDate) {
		this.accidentDate = accidentDate;
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
