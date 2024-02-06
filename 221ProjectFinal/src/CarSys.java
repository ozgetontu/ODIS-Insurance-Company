import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarSys {

	private static ArrayList<Cars> CarInfo = new ArrayList<>();
	private final static double leastPrice = 5000;

	public static boolean checkLicensePlate(String plate) {

		for (int i = 0; i < CarInfo.size(); i++) {
			if (CarInfo.get(i).findLicensePlate(plate))
				return true;
		}
		return false;
	}

	public static void readfromFile() {
		Scanner scn = null;
		int year;
		double enginePower;
		String licensePlate, driverInfo, model;
		Cars c = null;
		
		try {
			File file = new File("Car.txt");
			
			scn = new Scanner(file);
			
			while(scn.hasNext()) {
				
                model = scn.next();
                licensePlate = scn.next();
                year = scn.nextInt();
                driverInfo = scn.next();
                enginePower = scn.nextDouble();
                
                if (model.equalsIgnoreCase("AUDI"))
    				c = new AUDI(model, licensePlate, year, driverInfo, enginePower);
    			else if (model.equalsIgnoreCase("BMW"))
    				c = new BMW(model, licensePlate, year, driverInfo, enginePower);
    			else if (model.equalsIgnoreCase("Mercedes"))
    				c = new Mercedes(model, licensePlate, year, driverInfo, enginePower);
				
                CarInfo.add(c);
			}
		}catch (FileNotFoundException ex) {
            Logger.getLogger(CarSys.class.getName()).log(Level.SEVERE, null, ex);
        }
		scn.close();
	}
	public static boolean addCar(String model, String licensePlate, int year, String driverInfo, double enginePower) {
		for(Cars c : CarInfo)
			if(c.getLicensePlate().equalsIgnoreCase(licensePlate))
				return false;
		
		Cars car = null;
		
		if (model.equalsIgnoreCase("AUDI"))
			car = new AUDI(model, licensePlate, year, driverInfo, enginePower);
		else if (model.equalsIgnoreCase("BMW"))
			car = new BMW(model, licensePlate, year, driverInfo, enginePower);
		else if (model.equalsIgnoreCase("Mercedes"))
			car = new Mercedes(model, licensePlate, year, driverInfo, enginePower);
		
		CarInfo.add(car);
		return true;
		
	}

	public static void deleteCar(String plate) {
		int i = 0;

		if (checkLicensePlate(plate) == true) {
			while (plate.equalsIgnoreCase(CarInfo.get(i).licensePlate) && i < CarInfo.size()) {
				i++;
			}
			CarInfo.remove(i);
		}
	}

	public static Cars searchCar(String plate) {
		Cars car = null;
		int i = 0;

		if (checkLicensePlate(plate) == true) {
			while (!plate.equalsIgnoreCase(CarInfo.get(i).licensePlate) && i < CarInfo.size()) {
				i++;
			}

			car = CarInfo.get(i);
		}
		return car;
	}

	public static void calcInsurance() {

		for(int i=0; i<CarInfo.size(); i++) {
			double price = leastPrice;
			//CarInfo.get(i).insurancePrice = leastPrice;
			
			if(CarInfo.get(i).model.equalsIgnoreCase("Mercedes")) {
				if(CarInfo.get(i).year > 1 && CarInfo.get(i).year < 10)
					price += 300;
				else if(CarInfo.get(i).year >= 10 && CarInfo.get(i).year < 20)
					price += 500;
				else if(CarInfo.get(i).year >= 20 && CarInfo.get(i).year < 50)
					price += 1000;
				
				if(CarInfo.get(i).driverInfo.equalsIgnoreCase("none"))
					price += 0;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("low"))
					price += 2000;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("medium"))
					price += 4000;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("high"))
					price += 7000;
				
				if(CarInfo.get(i).enginePower >= 100 && CarInfo.get(i).enginePower < 250)
					price += 300;
				else if(CarInfo.get(i).enginePower >= 250 && CarInfo.get(i).enginePower < 400)
					price += 400;
				else if(CarInfo.get(i).enginePower >= 400 && CarInfo.get(i).enginePower < 500)
					price += 600;
			}else if(CarInfo.get(i).model.equalsIgnoreCase("BMW")) {
				if(CarInfo.get(i).year > 1 && CarInfo.get(i).year < 10)
					price += 200;
				else if(CarInfo.get(i).year >= 10 && CarInfo.get(i).year < 20)
					price += 350;
				else if(CarInfo.get(i).year >= 20 && CarInfo.get(i).year < 50)
					price += 700;
				
				if(CarInfo.get(i).driverInfo.equalsIgnoreCase("none"))
					price += 0;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("low"))
					price += 1000;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("medium"))
					price += 2000;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("high"))
					price += 5000;
				
				if(CarInfo.get(i).enginePower >= 100 && CarInfo.get(i).enginePower < 250)
					price += 150;
				else if(CarInfo.get(i).enginePower >= 250 && CarInfo.get(i).enginePower < 400)
					price += 300;
				else if(CarInfo.get(i).enginePower >= 400 && CarInfo.get(i).enginePower < 500)
					price += 500;
						
			}else if(CarInfo.get(i).model.equalsIgnoreCase("AUDI")) {
				if(CarInfo.get(i).year > 1 && CarInfo.get(i).year < 10)
					price += 100;
				else if(CarInfo.get(i).year >= 10 && CarInfo.get(i).year < 20)
					price += 200;
				else if(CarInfo.get(i).year >= 20 && CarInfo.get(i).year < 50)
					price += 500;
				
				if(CarInfo.get(i).driverInfo.equalsIgnoreCase("none"))
					price += 0;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("low"))
					price += 500;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("medium"))
					price += 1000;
				else if(CarInfo.get(i).driverInfo.equalsIgnoreCase("high"))
					price += 3000;
				
				if(CarInfo.get(i).enginePower >= 100 && CarInfo.get(i).enginePower < 250)
					price += 100;
				else if(CarInfo.get(i).enginePower >= 250 && CarInfo.get(i).enginePower < 400)
					price += 200;
				else if(CarInfo.get(i).enginePower >= 400 && CarInfo.get(i).enginePower < 500)
					price += 400;
			
			}
			CarInfo.get(i).setInsurancePrice(price);
		}
	}
	
	public static String display() {
		String out = " ";
		
		for(int i=0; i<CarInfo.size(); i++) {
			if(CarInfo.get(i).model.equalsIgnoreCase("Mercedes")) {
				out += "Mercedes" + CarInfo.get(i).toString();
			}else if(CarInfo.get(i).model.equalsIgnoreCase("AUDI")) {
				out += "AUDI" + CarInfo.get(i).toString();
			}else if(CarInfo.get(i).model.equalsIgnoreCase("BMW")) {
				out += "BMW" + CarInfo.get(i).toString();
			}
		}
		
		return out;
	}

}
