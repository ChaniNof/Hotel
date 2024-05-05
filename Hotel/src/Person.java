import java.util.Objects;

public class Person {
private String id;
private String name;
private String lastName;
private String phon;

public Person(String id, String name, String lastName, String phon) {
	this.id = id;
	this.name = name;
	this.lastName = lastName;
	this.phon = phon;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhon() {
	return phon;
}
public void setPhon(String phon) {
	this.phon = phon;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phon=" + phon + "]";
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	return Objects.equals(id, other.id);
}

}
