import java.util.Objects;

public class Guest {
private Person personD;
private int numVisit;

public Person getPersonD() {
	return personD;
}
public void setPersonD(Person personD) {
	this.personD = personD;
}
public int getNumVisit() {
	return numVisit;
}
public void setNumVisit(int numVisit) {
	this.numVisit = numVisit;
}
public Guest(Person personD, int numVisit) {
	this.personD = personD;
	this.numVisit = numVisit;
}
public Guest() {	
}

@Override
public int hashCode() {
	return Objects.hash(personD.getId());
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Guest other = (Guest) obj;
	return Objects.equals(personD.getId(), other.personD.getId());
}
@Override
public String toString() {
	return "Guest [personD=" + personD + ", numVisit=" + numVisit + "]";
}

}
