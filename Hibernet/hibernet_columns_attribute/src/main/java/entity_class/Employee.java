package entity_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	int id;
	@Column(nullable=false)
	String name;
	@Column(updatable = false)
	int  age;
	@Column(insertable = false)
	String comapany_name;
	@Column(unique=true)
	long phone;
	public Employee() {
		
	}
	
	

	public Employee(int id, String name, int age, String comapany_name, long phone) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.comapany_name = comapany_name;
		this.phone = phone;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getComapany_name() {
		return comapany_name;
	}
	public void setComapany_name(String comapany_name) {
		this.comapany_name = comapany_name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", comapany_name=" + comapany_name
				+ ", phone=" + phone + "]";
	}
	
	
	
	
	

}
