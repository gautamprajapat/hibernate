package entity_classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassRoom {

	@Id
	private int roomNo;
	private String className;
	
	public ClassRoom() {
		
	}
	public ClassRoom(int roomNo, String className) {
		
		this.roomNo = roomNo;
		this.className = className;
		
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		return "ClassRoom [roomNo=" + roomNo + ", className=" + className 
				+ "]";
	}
	
	
	
	
	
	
	
}
