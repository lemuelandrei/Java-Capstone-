import java.time.LocalDate;
import java.time.Year;

/**
 * @author LemuelLimuco
 *
 */
public class RatingEngine {
	double premium;
	double vehPurchasePrice;
	double vehPriceFactor;
	int licenseNumOfYears;
	
	public RatingEngine() {
		
	}
	
	public RatingEngine(int year, double vehPurchasePrice, int licenseYearFirstIssued) {
		setVehPriceFactor(year);
		setLicenseNumOfYears(licenseYearFirstIssued);
		setVehPurchasePrice(vehPurchasePrice);
		calculatePremium();
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
	
	public void setLicenseNumOfYears(int licenseYearFirstIssued) {
		LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
		this.licenseNumOfYears = currentYear - licenseYearFirstIssued;
	}
	
	public int getLicenseNumOfYears() {
		return licenseNumOfYears;
	}
	
	public void setVehPurchasePrice(double vehPurchasePrice) {
		this.vehPurchasePrice = vehPurchasePrice;
	}
	
	public void calculatePremium() {
		this.premium = (this.vehPurchasePrice * this.vehPriceFactor) + ((this.vehPurchasePrice / 100) / this.licenseNumOfYears);
	}
	
	public double getCalculatedPremium() {
		return premium;
	}
	
	public double getPolicyPremium() {
		double totalPremium = 0;
		totalPremium += premium;
		return totalPremium;
	}
	
	
}

