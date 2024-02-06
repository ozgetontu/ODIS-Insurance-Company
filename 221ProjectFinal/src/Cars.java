import java.util.*;
public abstract class Cars  {

	protected String licensePlate;
	protected int year;
	protected String driverInfo;
	protected double insurancePrice;
	protected String model;
	protected double enginePower;
	
	public Cars(String licensePlate, int year, String driverInfo, String model, double enginePower) {
		this.licensePlate = licensePlate;
		this.year = year;
		this.driverInfo = driverInfo;
		this.model = model;
		this.enginePower = enginePower;
		
	}

	public double getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(double enginePower) {
		this.enginePower = enginePower;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDriverInfo() {
		return driverInfo;
	}

	public void setDriverInfo(String driverInfo) {
		this.driverInfo = driverInfo;
	}

	public double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public String getModel() {
		return model;
	}
	
	public void setModel() {
		this.model = model;
	}
	
	public void getInput() {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter the car's model: ");
		this.model = scn.next();
		
		System.out.print("Enter the car's license plate: ");
		this.licensePlate = scn.next();
		
		System.out.print("Enter the car's manufacture year: ");
		this.year = scn.nextInt();
		
		System.out.print("Enter the driver info about crash:(None/Low/Medium/High)");
		this.driverInfo = scn.next();
	}
	
	public boolean findLicensePlate(String plate) {
		if(licensePlate.equalsIgnoreCase(plate))
			return true;
		
		return false;
	}
	@Override
	public String toString() {
		return "\nCars"
				+ "\nModel= " + model
				+ "\nLicense Plate= " + licensePlate
				+ "\nYear= " + year 
				+ "\nDriver Info= " + driverInfo
				+ "\nInsurance Price= " + insurancePrice;
				
	}
	
}
