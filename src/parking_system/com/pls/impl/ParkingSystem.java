package parking_system.com.pls.impl;

import parking_system.com.pls.bean.ParkingSlot;
import parking_system.com.pls.bean.Vehicle;
import parking_system.com.pls.exception.ParkingFullException;
import parking_system.com.pls.exception.VehicleNotFoundException;

import java.util.List;
import java.util.Map;


public interface ParkingSystem {
	Map<ParkingSlot,List<Vehicle>> parkVehicle(String fileVehicle, String fileParkingSlot) throws ParkingFullException;
	List<Vehicle> getVehicleInLane(Map<ParkingSlot,List<Vehicle>> map,int slotLaneNo);
	int locateVehicle(Map<ParkingSlot,List<Vehicle>> map,int vehicleId)throws VehicleNotFoundException;
	Vehicle removeVehicle(Map<ParkingSlot,List<Vehicle>> map,int vehicleId) throws VehicleNotFoundException;
		
}
