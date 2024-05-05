import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListRoom implements Serializable{
	static ArrayList<Room> arrayRoom;

	public ListRoom() {
		this.arrayRoom=new ArrayList<Room>();
	}
	public void addRoom(Room r)
	{
		this.arrayRoom.add(r);
	}
	public void reportActiv()//** report to file ActivRooms
	{try {
		List<Room> rooms=this.arrayRoom.stream().filter(x-> x!=null && x.isActive()==true).collect(Collectors.toList());
		Report.createReport("ActivRoomsReport.txt",rooms);
	}
	catch (Exception e) {
		System.out.println("problem with creating report:ActivRoomsReportReport because:"+e.getMessage());

	}
	}
	public void reportAnActiv()//** report to file anActivRooms
	{try {
		List<Room> rooms=this.arrayRoom.stream().filter(x-> x!=null && x.isActive()==false).collect(Collectors.toList());
		Report.createReport("AnActivRoomsReportReport.txt", rooms);
	}
	catch (Exception e) {
		System.out.println("problem with creating report:AnActivRoomsReportReport because:"+e.getMessage());

	}
	}

	public void printRoomByNum(int numRoom) {
		Optional<Room> r=this.arrayRoom.stream().filter(x-> x!=null && x.getNumRoom()==numRoom).findFirst();
		System.out.println(r.toString());
	}

	public void printRoomByLevel(int level) {
		System.out.println(searchByLevel(level).toString());
	}
	public void printRoomByFloor(int floor) {
		System.out.println(searchByFloor(floor).toString());
	}
	public Optional<Room> searchByLevel(int level) {
		Optional<Room> r=this.arrayRoom.stream().filter(x-> x!=null && x.getLevel()==level).findFirst();
		return r;
	}

	public Optional<Room> searchByLevel(int level,boolean activ) {
		Optional<Room> r=this.arrayRoom.stream().filter(x-> x!=null && x.getLevel()==level && x.isActive()==activ).findFirst();
		return r;
	}
	public void printAllRooms() {//***
		this.arrayRoom.forEach(System.out::println);
	}
	public Optional<Room> searchByFloor(int floor) {
		Optional<Room> r=this.arrayRoom.stream().filter(x-> x!=null && x.getFloor()==floor).findFirst();
		return r;
	}
}
