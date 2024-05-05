import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.time.LocalDate;

public class Order implements Serializable {
private int numOrder;
private Guest guest;
private Room room;
private LocalDate orderDate;
private int numDay;

public Order(int numOrder, Guest guest, Room room, LocalDate orderDate, int numDay) {
	this.numOrder = numOrder;
	this.guest = guest;
	this.room = room;
	this.orderDate = orderDate;
	this.numDay = numDay;
}
public int getNumOrder() {
	return numOrder;
}
public Guest getGuest() {
	return guest;
}
public void setGuest(Guest guest) {
	this.guest = guest;
}
public Room getRoom() {
	return room;
}
public void setRoom(Room room) {
	this.room = room;
}
public LocalDate getOrderDate() {
	return orderDate;
}
public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}
public int getNumDay() {
	return numDay;
}
public void setNumDay(int numDay) {
	this.numDay = numDay;
}
public Order(int numOrder) {
	this.numOrder = numOrder;
}

public int calcPrice()
{
	if(this.guest instanceof BussinesGuest) {
		return numDay*this.getRoom().getStartPrice()*(100-((BussinesGuest)this.guest).getDiscountPercent()/100);
	}
	else
	return this.numDay*this.getRoom().getStartPrice();
}
@Override
public int hashCode() {
	return Objects.hash(guest.getPersonD().getId());
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Order other = (Order) obj;
	return Objects.equals(guest.getPersonD().getId(), other.guest.getPersonD().getId());
}
@Override
public String toString() {
	return "Order [numOrder=" + numOrder + ", guest=" + guest + ", room=" + room + ", orderDate=" + orderDate
			+ ", numDay=" + numDay + "]";
}


}
 