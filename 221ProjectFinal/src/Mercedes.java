import java.util.Scanner;
public class Mercedes extends Cars{
	
	public Mercedes(String model, String licensePlate, int year, String driverInfo, double enginePower) {
		
		super(licensePlate, year, driverInfo, model, enginePower);
	}

	public void getInput() {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter the car's engine power: ");
		this.enginePower = scn.nextDouble();
	}

	@Override
	public String toString() {
		return super.toString()
				+ "\nEngine Power= " + enginePower + "\n\n";
	}
}
