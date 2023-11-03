package parking_system.com.pls.util;

import parking_system.com.pls.bean.ParkingSlot;
import parking_system.com.pls.bean.Vehicle;
import parking_system.com.pls.exception.ParkingFullException;
import parking_system.com.pls.exception.VehicleNotFoundException;
import parking_system.com.pls.impl.ParkingSystemImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class Client {

	public static void main(String[] args) {
		int laneNo;
		ParkingSystemImpl impl=new ParkingSystemImpl();
		Map<ParkingSlot, List<Vehicle>> map;
		List<Vehicle> vehiclesInLane;
		Vehicle vehicle;
		try {
			try {
				map=impl.parkVehicle("Vehicle.txt", "ParkingSlot.txt");
			
			Set<Entry<ParkingSlot,List<Vehicle>>> set=map.entrySet();
			for(Entry<ParkingSlot, List<Vehicle>> entry : set){
				System.out.println(entry.getKey().toString());
				System.out.print("\t"+entry.getValue());
			}
			vehiclesInLane=impl.getVehicleInLane(map, 204);
			for(Vehicle v:vehiclesInLane){
				System.out.println(v.toString());
			}
			
			
			laneNo=impl.locateVehicle(map, 1010);
			System.out.println(laneNo);
			
			vehicle=impl.removeVehicle(map, 1026);
			System.out.println("Removed vehicle : "+vehicle.getVehicleId()+" "+vehicle.getPrice());
			
			} catch (ParkingFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}catch (VehicleNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}

}