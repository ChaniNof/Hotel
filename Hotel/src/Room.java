import java.util.Objects;

public class Room {
private int numRoom;
private int floor;
private int level;
private boolean isActive;
private static int startPrice;


public Room(int numRoom, int floor, int level, boolean isActive) {
	this.numRoom = numRoom;
	this.floor = floor;
	this.level = level;
	this.isActive = isActive;
}

public Room() {
}

public int getNumRoom() {
	return numRoom;
}

public int getFloor() {
	return floor;
}
public void setFloor(int floor) {
	this.floor = floor;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public static int getStartPrice() {
	return startPrice;
}
public static void setStartPrice(int startPrice) {
	Room.startPrice = startPrice;
}

@Override
public int hashCode() {
	return Objects.hash(numRoom);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Room other = (Room) obj;
	return numRoom == other.numRoom;
}

@Override
public String toString() {
	return "Room [numRoom=" + numRoom + ", floor=" + floor + ", level=" + level + ", isActive=" + isActive + "]";
}

}
