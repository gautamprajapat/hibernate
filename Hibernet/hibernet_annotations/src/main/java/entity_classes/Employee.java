package entity_classes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "new_employee")
public class Employee {
	@Id
	@Column(name="e_id")
	private int id;
	
	@Column(name="e_name")
	private String name;
	
	@Column(name="e_salary")
	private double salary;
	
	@CreationTimestamp
	private LocalDateTime create_time;
	
	@UpdateTimestamp
	private LocalDateTime  update_time;

	public Employee() {
		
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDateTime getCreate_time() {
		return create_time;
	}

	

	public LocalDateTime getUpdate_time() {
		return update_time;
	}

	
	
	
	
	
	

}
