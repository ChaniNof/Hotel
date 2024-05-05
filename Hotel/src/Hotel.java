import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
public class Hotel {
private static Hotel ht=null;
private String name;
private String adress;
private String phon;
private ListRoom Rooms;
private ListGuest guests;
private ListOrder orders;

private Hotel() {}

public static Hotel getInstence(String name, String adress, String phon) {
	if(ht==null)
		ht=new Hotel(name,adress,phon);
	return ht;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getPhon() {
	return phon;
}
public void setPhon(String phon) {
	this.phon = phon;
}

private Hotel(String name, String adress, String phon) {
	this.name = name;
	this.adress = adress;
	this.phon = phon;
	this.Rooms=new ListRoom();
	this.orders=new ListOrder();
	this.guests=new ListGuest(orders);
	initRoom();
}
private void initRoom() {
	 Rooms.addRoom(new Room(1,2,2,false));
	 Rooms.addRoom(new Room(2,4,1,false));
	 Rooms.addRoom(new Room(3,2,1,false));
	 Rooms.addRoom(new Room(4,1,3,false));
}

public boolean addOrder(Guest g,int level,int numDays) {
	Scanner in=new Scanner(System.in);
	Optional<Room> r=this.Rooms.searchByLevel(level,false);
	if(!r.isPresent()){
		return false;
	}
	else {
	r.get().setActive(true);
	this.guests.addGuest(g);
	this.orders.addOrder(new Order((this.orders.ArrayOrder.size())+1,g,r.get(),LocalDate.now(),numDays));   
    return true;
	}}
//delete Order
public void remove(String id) {
	//find guest
	Optional<Order> o=this.orders.search(id);
	if(!o.isPresent()) {
		System.out.println("we don't found your order");
	}
	else {
	o.get().getRoom().setActive(true);
	this.orders.removeOrder(id);
	System.out.println("remove Order of: "+o.get().getGuest().getPersonD().getName());
}}


public String toString() {
	return "Hotel [name=" + name + ", adress=" + adress + ", phon=" + phon + "]";
}

 public void Menu() {
	Scanner in=new Scanner(System.in);
	int num=-1;
	while(num!=8) {
	System.out.println("press 1:print Hotel Detels | press 2:add order | press 3:delete order | press 4:print order | press 5:report | press 6: print Guests'detels");
	num=in.nextInt();
	switch (num) {
	case 1:System.out.println(toString());break;
	case 2:System.out.println("add guest detels -: id,name,lastname,phon,numVisit");
	String id=in.next();
	String name=in.next();
	String lastname=in.next();
	String phon=in.next();
    int numVisit=in.nextInt();
	Guest g =new Guest(new Person(id,name,lastname,phon),numVisit);
	System.out.println("insert wonted level");
	int level=in.nextInt();
	System.out.println("insert wonted numDays");
    int numDays=in.nextInt();
    while(this.addOrder(g,level, numDays)!=true) {
    System.out.println("this room is anActive try other room level");
	 level=in.nextInt();
    }
	System.out.println("your order add in secsses");
	this.orders.Print();
	;break;
	case 3:System.out.println("insert id");
	String idR=in.next();
	this.orders.Print();
     this.remove(idR);
     this.orders.Print();;break;
	case 4: System.out.println("print all:1 | Print according guest :2 | Print according Room :3 ");
		int numType=in.nextInt();
		switch (numType) {
		case 1:this.orders.Print(); ;break;
		case 2://System.out.println("add guest detels -: id,name,lastname,phon,numVisit");
//		String idP=in.next();
//		String nameP=in.next();
//		String lastnameP=in.next();
//		String phonP=in.next();
//	    int numVisitP=in.nextInt();
//		Guest gP =new Guest(new Person(idP,nameP,lastnameP,phonP),numVisitP);
		System.out.println("insert id");
		String gP=in.next();
		this.orders.Print(gP);
			;break;
		case 3://System.out.println("add Room Datelse: numRoom,level,Floor");
//		int numRoom=in.nextInt();
//		int levelRoom =in.nextInt();
//		int floor=in.nextInt();
//		Room r=new Room(numRoom,levelRoom,floor,false);
			System.out.println("insert num Room");
			int numRoom=in.nextInt();
		this.orders.Print(numRoom);;break;
		default:
		}
	case 5:this.Rooms.reportActiv();;break;
	case 6 :this.guests.ArrayGuest.forEach(System.out::println);;break;
	default:
		System.out.println("laoud is perss not exsit");
		break;
	}
}
}
}
