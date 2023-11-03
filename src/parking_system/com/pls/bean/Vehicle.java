package parking_system.com.pls.bean;

public class Vehicle {

	private int vehicleId;
	private VehicleType vehicleType;
	private int price;
	
	public Vehicle(int vehicleId, VehicleType vehicleType, int price) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.price = price;
	}



	public Vehicle() {
		
	}



	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public String toString(){
		return vehicleId+" "+vehicleType.toString()+" " +price;
	}
	
}
