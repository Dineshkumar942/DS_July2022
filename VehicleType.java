
public class VehicleType {

	public static void main(String[] args) {
		Vehicle myVehicle=new Vehicle();
		myVehicle.cycle();
		myVehicle.Bike(150);
		System.out.println(myVehicle.Cab(45.0f));
		System.out.println(myVehicle.officeCab());
		
	}

}
class Vehicle{
	void cycle() {
		System.out.println("am cycling...my speed is not sufficent to reach office");
		System.out.println("------------------------");
	}
	void Bike(int speed) {
		System.out.println("Am Bike .....and am riding with a speed of "+speed+" KM/H");
		System.out.println("------------------------");
	}
	double Cab(float distance) {
		System.out.println("Have a ride to "+distance+" and charges have been provided");
		System.out.println("------------------------");
		return distance*6;
	}
	double officeCab() {
		System.out.println("Going to office in cab and bill will be paid by office");
		System.out.println("--------------------------");
		return 300.00;
	}
	
}
