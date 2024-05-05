import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListGuest implements Serializable {
	static List<Guest> ArrayGuest;
	static ListOrder ListOrders;

	public ListGuest(ListOrder listOrder) {
		this.ArrayGuest=new ArrayList<>();
		this.ListOrders=listOrder;
	}

	public void addGuest(Guest g) {
		this.ArrayGuest.add(g);
	}
	public Optional<Guest> searchById(String id) {
		Optional<Guest> guest=this.ArrayGuest.stream().filter(x-> x!=null && x.getPersonD().getId()==id).findFirst();
		return guest;

	}
	public Optional<Guest> searchByName(String name) {
		Optional<Guest> guest=this.ArrayGuest.stream().filter(x-> x!=null && x.getPersonD().getName()==name).findFirst();
		return guest;

	}
	public Optional<Guest> searchByPhon(String phon) {
		Optional<Guest> guest=this.ArrayGuest.stream().filter(x-> x!=null && x.getPersonD().getPhon()==phon).findFirst();
		return guest;

	}
	public void printGuestById(String id) {
		searchById(id).toString();
	}
	public void printGuestByName(String name) {
		searchByName(name).toString();
	}
	public boolean remove(String id)
	{
		Optional<Order> guestOrder=this.ListOrders.search(id);
		if(!guestOrder.isPresent()) {
			return this.ArrayGuest.remove(searchById(id));
		}
		return false;
	}
	
	public void reportActivGuest(){
		try {
			List<Guest> list= this.ArrayGuest.stream().filter(x->x.equals(this.ListOrders.search(x.getPersonD().getId()).isPresent())).collect(Collectors.toList());
			Report.createReport("activGuestReport.txt",list);
	       
		} catch (Exception e) {
			System.out.println("problem with creating report:activGuestReport because:"+e.getMessage());
		}
		
	}
}


