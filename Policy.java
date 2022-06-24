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
	private ArrayList<Claim> claims = new ArrayList<>();
	private double totalPolicyPremium;
	
	public Policy(LocalDate effectiveDate) {
		setPolicyNo();
		setEffectiveDate(effectiveDate);
		setExpirationDate(effectiveDate);
	}
	
	public void setPolicyNo() {
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999); // It will generate 6 digit random number from 0 to 999999
	    this.policyNo = number;
	}
	
	public String getPolicyNo() {
		String policyNum = String.format("%06d", policyNo); //Includes zeroes at the beginning of policy number
		return policyNum;
	}
	
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setExpirationDate(LocalDate effectiveDate) {
		this.expirationDate = effectiveDate.plusMonths(6);
	}
	
	public void setNewExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
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
	
	public void addClaims(LocalDate accidentDate, String accidentAddress, String accidentDescription, String damageDescription, double costOfRepairs) {
		claims.add(new Claim(accidentDate, damageDescription, damageDescription, damageDescription, costOfRepairs));
	}
	
	public ArrayList<Claim> getClaims() {
		return claims;
	}
	
	public void setPremiumTotal(double premiumTotal) {
		this.totalPolicyPremium = premiumTotal; 
	}
	
	public double getPremiumTotal() { 
		return this.totalPolicyPremium;
	}
	
}
