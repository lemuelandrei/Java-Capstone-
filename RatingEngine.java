import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

/**
 * @author LemuelLimuco
 *
 */
public class RatingEngine {
	private double premium;
	private static double totalPremium;
	private double vehPurchasePrice;
	private double vehPriceFactor;
	private int licenseNumOfYears;
	
	public RatingEngine(int year, double vehPurchasePrice, LocalDate licenseDateIssued) {
		setVehPriceFactor(year);
		setLicenseNumOfYears(licenseDateIssued);
		setVehPurchasePrice(vehPurchasePrice);
		setPremium();
	}
	
	public void setVehPriceFactor(int year) {
		int currentYear = Year.now().getValue();
		int vehicleAge = currentYear - year;
		if(vehicleAge <= 1) {
			this.vehPriceFactor = 0.01;
		} else if(vehicleAge <= 3 && vehicleAge > 1) {
			this.vehPriceFactor = 0.008;
		} else if(vehicleAge <= 5 && vehicleAge > 3) {
			this.vehPriceFactor = 0.007;
		} else if(vehicleAge <= 10 && vehicleAge > 5) {
			this.vehPriceFactor = 0.006;
		} else if(vehicleAge <= 15 && vehicleAge > 10) {
			this.vehPriceFactor = 0.004;
		} else if(vehicleAge <= 20 && vehicleAge > 15) {
			this.vehPriceFactor = 0.002;
		} else if(vehicleAge <= 40 && vehicleAge > 20) {
			this.vehPriceFactor = 0.001;
		}
	}
	
	public double getVehPriceFactor() {
		return vehPriceFactor;
	}
	
	public void setLicenseNumOfYears(LocalDate licenseDateIssued) {
		LocalDate currentDate = LocalDate.now();
		Period period = licenseDateIssued.until(currentDate);
		int yearsBetween = period.getYears();
		this.licenseNumOfYears = yearsBetween;
		if(licenseNumOfYears < 1) {
			this.licenseNumOfYears = 1;
		}
	}
	
	public int getLicenseNumOfYears() {
		return licenseNumOfYears;
	}
	
	public void setVehPurchasePrice(double vehPurchasePrice) {
		this.vehPurchasePrice = vehPurchasePrice;
	}
	
	public void setPremium() {
		this.premium = (this.vehPurchasePrice * this.vehPriceFactor) + ((this.vehPurchasePrice / 100) / this.licenseNumOfYears);
		setPremiumTotal(this.premium);
	}
	
	public double getPremiumTotal() {
		return totalPremium;
	}
	
	public void setPremiumTotal(double premium) {
		totalPremium += premium;
	}
	
	public void resetPremiumTotal() {
		totalPremium = 0;
	}
	
	public double getCalculatedPremium() {
		return premium;
	}
}

