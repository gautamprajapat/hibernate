package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_stud")
	@SequenceGenerator(name="seq_stud",initialValue=100,allocationSize=10,sequenceName="student_auto")
	int id;
	String name;
	double percentage;
	public Student() {
		
	}
	public Student(String name, double percentage) {
		
		this.name = name;
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", percentage=" + percentage + "]";
	}
	
	
	

}
