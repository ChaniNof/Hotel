import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;
public class ListOrder implements Serializable {
	static Set<Order> ArrayOrder;

	public ListOrder() {
		this.ArrayOrder=new HashSet<>();
	}
	public int getLen() {
		return this.ArrayOrder.size();
	}
	public void addOrder(Order o) {
		this.ArrayOrder.add(o);
	}
	public Optional<Order> search(String id) {
		Optional<Order> gfaind=this.ArrayOrder.stream().filter(x-> x!=null && x.getGuest().getPersonD().getId().equals(id)).findFirst();
		return gfaind;
	}
	public Optional<Order> search(int numRoom) {
		Optional<Order> gfaind=this.ArrayOrder.stream().filter(x-> x!=null && x.getRoom().equals(numRoom)).findFirst();
		return gfaind;
	}
	public int removeOrder(String id) {
		//find order by id of guest
		Optional<Order> o=this.search(id);
		this.ArrayOrder.remove(o.get());//remove the order
		if(o.get().getRoom()!=null) {//check if have a Room
		return o.get().getRoom().getNumRoom();//return the numRoom
		}
		else 
			return -1;
	}
	public void reportOrders(int numsDays){
		try {
		List<Order> list=this.ArrayOrder.stream().filter(x->x!=null &&((Integer) x.getNumDay()).equals(numsDays)).collect(Collectors.toList());
		Report.createReport("OrderAcordingDaysReport.txt", list);
		}
		catch (Exception e) {
			System.out.println("problem with creating report:OrderAcordingDaysReport because:"+e.getMessage());
		}	
	}
	public void report(LocalDate d){
		try {
		List<Order> list= this.ArrayOrder.stream().filter(x->x!=null && x.getOrderDate()==d).collect(Collectors.toList());
		Report.createReport("OrderAcordingDateReport.txt", list);
		}
		catch (Exception e) {
			System.out.println("problem with creating report:OrderAcordingDateReport because:"+e.getMessage());

		}
	}
	
	public void Print(String id) {
	this.ArrayOrder.stream().filter(x->x!=null && x.getGuest().getPersonD().getId().equals(id)).forEach(System.out::println);
		
	}
	public void Print(int numRoom) {
		this.ArrayOrder.stream().filter(x->x!=null &&((Integer)x.getRoom().getNumRoom()).equals(numRoom)).forEach(System.out::println);
	}
	public void Print() {
		this.ArrayOrder.forEach(System.out::println);
	}
}
