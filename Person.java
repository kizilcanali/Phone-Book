

public class Person {
private	String name;
private	String surname;
private String address;

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public	String phone[];

	public Person(String name, String surname, String address) {
		super();
		this.address=address;
		this.name = name;
		this.surname = surname;
		this.phone = new String[3];
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public boolean equals(Person p) {
		// TODO Auto-generated method stub
		if(this.name.equals(p.getName())&& this.surname.equals(p.getSurname())) {
			return true;
		}
		return false;	
		}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+" "+this.surname;
		
	}
	

}
