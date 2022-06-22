import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDate;

/**
 * @author LemuelLimuco
 *
 */
public class Policy {
	private int policyNo;
	private LocalDate effectiveDate;
	private LocalDate expirationDate;
	private PolicyHolder policyHolder;
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	private Claim claim;
//	private ArrayList<Claim> claims = new ArrayList<>();
	static double policyPremium = 0;
	
	public Policy(String effectiveDate) {
		setPolicyNo();
		setEffectiveDate(effectiveDate);
		setExpirationDate(effectiveDate);
	}
	
	public void setPolicyNo() {
		// It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    this.policyNo = number;
	}
	
	public String getPolicyNo() {
		String policyNum = String.format("%06d", policyNo);
		return policyNum;
	}
	
	public void setEffectiveDate(String effectiveDate) {
		LocalDate startDate = LocalDate.parse(effectiveDate);
		this.effectiveDate = startDate;
	}
	
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setExpirationDate(String effectiveDate) {
		LocalDate startDate = LocalDate.parse(effectiveDate);
		this.expirationDate = startDate.plusMonths(6);
	}
	
	public void setNewExpirationDate(String expirationDate) {
		LocalDate newExpirationDate = LocalDate.parse(expirationDate);
		this.expirationDate = newExpirationDate;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public void setPolicyHolder(String firstName, String lastName, LocalDate birthDate, String address, String driversLicenseNo, LocalDate licenseDateFirstIssued) {
		policyHolder = new PolicyHolder(firstName, lastName, birthDate, address, driversLicenseNo, licenseDateFirstIssued);
	}
	
	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}
	
	public void addVehicles(String make, String model, int year, String type, String fuelType, double purchasePrice, String color, double premiumCharge) {
		vehicles.add(new Vehicle(make, model, year, type, fuelType, purchasePrice, color, premiumCharge));
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setClaim(LocalDate accidentDate, String accidentAddress, String accidentDescription, String damageDescription, double costOfRepairs) {
		claim = new Claim(accidentDate, accidentAddress, accidentDescription, damageDescription, costOfRepairs);
	}
	
	public Claim getClaim() {
		return claim;
	}
	
//	public void addClaims(LocalDate accidentDate, String accidentAddress, String accidentDescription, String damageDescription, double costOfRepairs) {
//		claims.add(new Claim(accidentDate, damageDescription, damageDescription, damageDescription, costOfRepairs));
//	}
//	
//	public ArrayList<Claim> getClaims() {
//		return claims;
//	}
	
	public static double getPolicyPremium() {
		return policyPremium;
	}
	
	public static void setPolicyPremium(double pOlicyPremium) {
		policyPremium += pOlicyPremium;
	}
}
