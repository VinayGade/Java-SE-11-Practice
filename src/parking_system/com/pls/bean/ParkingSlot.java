package parking_system.com.pls.bean;

public class ParkingSlot {
	private int slotLaneNo;
	private int price;

	public ParkingSlot(int slotLaneNo, int price) {
		super();
		this.slotLaneNo = slotLaneNo;
		this.price = price;
	}

	public ParkingSlot() {
		// TODO Auto-generated constructor stub
	}

	public int getSlotLaneNo() {
		return slotLaneNo;
	}

	public void setSlotLaneNo(int slotLaneNo) {
		this.slotLaneNo = slotLaneNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString(){
		return slotLaneNo+" "+price;
		
	}

}
