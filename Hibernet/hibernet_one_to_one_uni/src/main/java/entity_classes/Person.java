package entity_classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private long phone;
	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Pancard pancard;
	public Person() {
		
	}
	public Person(int id, String name, long phone, Pancard pancard) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.pancard = pancard;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Pancard getPancard() {
		return pancard;
	}
	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", pancard=" + pancard + "]";
	}
	
	

}
