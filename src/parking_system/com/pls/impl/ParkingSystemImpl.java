package parking_system.com.pls.impl;

import parking_system.com.pls.bean.ParkingSlot;
import parking_system.com.pls.bean.Vehicle;
import parking_system.com.pls.bean.VehicleType;
import parking_system.com.pls.exception.ParkingFullException;
import parking_system.com.pls.exception.VehicleNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class ParkingSystemImpl implements ParkingSystem {

	private Scanner scanParkingSlot;
	private Scanner scanVehicle;
	private Vehicle vehicle;
	private ParkingSlot parkingSlot;
	private String line;
	private List<Vehicle> vehicleList;
	private Map<ParkingSlot, List<Vehicle>> parkingMap;
	 
	private Set<Entry<ParkingSlot, List<Vehicle>>> set;
	/**
	 * public static interface Map.Entry<K,V>
		-A map entry (Key-Value pair). 
		-The Map.entrySet method returns a collection-view of the map, whose elements are of this class. 
		-The only way to obtain a reference to a map entry is from the iterator of this collection-view.
		-These Map.Entry objects are valid only for the duration of the iteration; more formally, 
			the behavior of a map entry is undefined if the backing map has been modified after 
		    the entry was returned by the iterator, except through the setValue operation on the map entry.
	 * */
	
	
	@Override
	public Map<ParkingSlot, List<Vehicle>> parkVehicle(String fileVehicle,
			String fileParkingSlot) throws ParkingFullException {
		
		vehicleList=new ArrayList<Vehicle>();
		parkingMap=new HashMap<ParkingSlot, List<Vehicle>>();
		set=parkingMap.entrySet();
		try {
			
			/*Bike=20,Car=40,Truck=50,Bus=60.Maximum size of lane is 4 vehicle.If there is no place to place the vehicles than throw ParkingFullException */
			
			scanParkingSlot=new Scanner(new File(fileParkingSlot));
			scanVehicle=new Scanner(new File(fileVehicle));
			
			while(scanVehicle.hasNext()){
				vehicle=new Vehicle();
				
				line=scanVehicle.nextLine();
				String tokens[]=line.split("-");
				vehicle.setVehicleId(Integer.parseInt(tokens[0]));
				vehicle.setVehicleType(VehicleType.valueOf(tokens[1]));
				
				 if(vehicle.getVehicleType().name().equalsIgnoreCase("Bike")){
					vehicle.setPrice(20);
				} else if(vehicle.getVehicleType().toString().equalsIgnoreCase("Car")){
					vehicle.setPrice(40);
				} else if(vehicle.getVehicleType().toString().equalsIgnoreCase("Truck")){
					vehicle.setPrice(50);
				} else if(vehicle.getVehicleType().toString().equalsIgnoreCase("Bus")){
					vehicle.setPrice(60);
				}
				
				
				vehicleList.add(vehicle);
			}
			
			while(scanParkingSlot.hasNext()){
				parkingSlot=new ParkingSlot();
	
				line=scanParkingSlot.nextLine();
				String tokens[]=line.split(":");
				parkingSlot.setSlotLaneNo(Integer.parseInt (tokens[0].trim()));
				parkingSlot.setPrice(Integer.parseInt (tokens[1].trim()));
				
				parkingMap.put(parkingSlot, vehicleList);
			}
			
			//Maximum size of lane is 4 vehicle.If there is no place to place the vehicles than throw ParkingFullException 
			int count=0;
			for(Vehicle v:vehicleList){
				for(Entry<ParkingSlot, List<Vehicle>> entry:set){
					
					//since  ParkingSlot and Vehicle have 1 common data member : price
					//hence we can compare as per : price
					
					if(v.getPrice()==entry.getKey().getPrice()){
						
						//entry.getValue() : gives value of <key ,Value> set's object.  here value is List<Vehicle>
						if(entry.getValue().size()<4){
							entry.getValue().add(vehicle);
							count++;
						}
					}
				}
			}
			if(!(count==vehicleList.size())){
				try{
				throw new ParkingFullException();
				}
				catch (Exception e) {
					System.out.println(e);
				}
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return parkingMap;
	}

	@Override
	public List<Vehicle> getVehicleInLane(Map<ParkingSlot, List<Vehicle>> map,
			int slotLaneNo) {
		List<Vehicle> vehiclesInLane=null;
		for(Entry<ParkingSlot, List<Vehicle>> entry:set){
			if(entry.getKey().getSlotLaneNo()==slotLaneNo){
				vehiclesInLane=entry.getValue();
			}
		}
		return vehiclesInLane;
	}

	@Override
	public int locateVehicle(Map<ParkingSlot, List<Vehicle>> map, int vehicleId)
			throws VehicleNotFoundException {
		int laneNo=0;
		for(Entry<ParkingSlot, List<Vehicle>> entry:set){
			for(Vehicle v:vehicleList){
				if(v.getVehicleId()== vehicleId){
					laneNo=entry.getKey().getSlotLaneNo();
					return laneNo;
				}
				
			}
		}
		throw new  VehicleNotFoundException();
		
	}

	@Override
	public Vehicle removeVehicle(Map<ParkingSlot, List<Vehicle>> map,
			int vehicleId) throws VehicleNotFoundException {
		for(Entry<ParkingSlot, List<Vehicle>> entry:set){
			for(Vehicle v:vehicleList){
				if(v.getVehicleId()==vehicleId){
					entry.getValue().remove(v);
					return v;
				}
			}
		}
		throw new VehicleNotFoundException();
	}

	
}
