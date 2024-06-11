package student_app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernet_crud_student_app.Student;

public class StudentApp {
	Scanner sc=new Scanner(System.in);
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public static void main(String[] args) {
		
		StudentApp stuApp=new StudentApp();
		
		
		
		
		
		stuApp.startApp();
		
		
		
		
	}
	
	public void addStudent() {
		System.out.println("Enter student details:");
		System.out.println("Enter id:");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name:");
		String name=sc.nextLine();
		System.out.println("Enter age:");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter percentage:");
		double perc=sc.nextDouble();
		sc.nextLine();
		
		Student st=new Student(id,name,age,perc);
		
		et.begin();
		em.persist(st);
		et.commit();
	}

	
	public void removeStudent(int id) {
		Student stu=em.find(Student.class, id);
		et.begin();
		em.remove(stu);
		et.commit();
		
	}
	
	public void findStudent(int id) {
		Student stu=em.find(Student.class, id);
		System.out.println(stu);
		
	}
	
	
	
	public void findAllStudent() {
		
		Query query=em.createQuery("select stu from Student stu");
		List<Student>students=query.getResultList();
		for(Student s:students) {
			System.out.println(s);
		}
		
	}
	public void updateStudent(int id) {
		System.out.println("ENter details to update");
		
		System.out.println("Enter name:");
		String name=sc.nextLine();
		System.out.println("Enter age:");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter percentage:");
		double perc=sc.nextDouble();
		sc.nextLine();
		Student stu=em.find(Student.class, id);
		stu.setName(name);
		stu.setAge(age);
		stu.setPercentage(perc);
		et.begin();
		em.merge(stu);
		
		et.commit();
		
	}
	
	public void fetchStudentAccordingToPercentage(double perc) {
		
//		System.out.println("Enter percentage to find details of student");
		Query query=em.createQuery("select stu from Student stu where stu.percentage=:stu_perc");
		query.setParameter("stu_perc", perc);
		List<Student>students=query.getResultList();
		for(Student s:students) {
			System.out.println(s);
		}
		
	}
	
	public void startApp() {
		System.out.println("Enter choice");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:{
			addStudent();
			break;
		}
		
		case 2:{
			System.out.println("Enter Student id to remove student");
			int id=sc.nextInt();
			sc.nextLine();
			removeStudent(id);
			break;
		}
		case 3:{
			System.out.println("Enter Student id to Find student");
			int id=sc.nextInt();
			sc.nextLine();
			findStudent(id);
			break;
		}
		case 4:{
			findAllStudent();
			break;
		}
		case 5:{
			System.out.println("Enter Student id to Update student");
			int id=sc.nextInt();
			sc.nextLine();
			updateStudent(id);
			break;
			
		}
		case 6:{
			System.out.println("Enter Student percentage to Find details of student");
			double perc=sc.nextInt();
			sc.nextLine();
			fetchStudentAccordingToPercentage(perc);
			break;
		}
		case 7:{
			System.exit(0);
			
		}
		default:{
			System.out.println("Invalid input please try again!!!");
		}
		}
		
	}
}
