package entity_classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pancard {
	@Id
	private int id;
	private String address;
	private String dob;
	
	@OneToOne
	private Person person;

	public Pancard() {
		
	}

	public Pancard(int id, String address, String dob) {
		
		this.id = id;
		this.address = address;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Pancard [id=" + id + ", address=" + address + ", dob=" + dob + "]";
	}
	
	
	

}
