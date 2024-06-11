package entity_classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	private int rollNO;
	private String name;
	private int age;
	
	@ManyToOne
	ClassRoom classRoom;

	public Student() {
		
	}

	public Student(int rollNO, String name, int age, ClassRoom classRoom) {
		
		this.rollNO = rollNO;
		this.name = name;
		this.age = age;
		this.classRoom = classRoom;
	}

	public int getRollNO() {
		return rollNO;
	}

	public void setRollNO(int rollNO) {
		this.rollNO = rollNO;
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

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "Student [rollNO=" + rollNO + ", name=" + name + ", age=" + age + ", classRoom=" + classRoom + "]";
	}
	
	
	
	
	

}
