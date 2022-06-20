/**
 * @author LemuelLimuco
 *
 */
public class Vehicle {
	private String make;
	private String model;
	private int year;
	private String type;
	private String fuelType;
	private double purchasePrice;
	private String color;
	private double premiumCharge;
	
	public Vehicle(String make, String model, int year, String type, String fuelType, double purchasePrice, String color, double premiumCharge) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.type = type;
		this.fuelType = fuelType;
		this.purchasePrice = purchasePrice;
		this.color = color;
		this.premiumCharge = premiumCharge;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getType() {
		return type;
	}
	
	public String getFuelType() {
		return fuelType;
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getPremiumCharge() {
		return premiumCharge;
	}
}
