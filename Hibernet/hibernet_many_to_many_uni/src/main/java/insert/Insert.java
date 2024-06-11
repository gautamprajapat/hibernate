package insert;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Student;
import entity_classes.Subject;

public class Insert {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
//		System.out.println("Connection created");
		Subject sub1=new Subject(101,"Physics");
		Subject sub2=new Subject(102,"Chemeistry");
		Subject sub3=new Subject(103,"Math");
		Subject sub4=new Subject(104,"Bio");
		
		List<Subject>subjects1=new ArrayList<Subject>();
		subjects1.add(sub1);
		subjects1.add(sub2);
		subjects1.add(sub3);
		
		Student stud1=new Student(1,"shubham",18,subjects1);
		List<Subject>subjects2=new ArrayList<Subject>();
		subjects2.add(sub1);
		subjects2.add(sub2);
		subjects2.add(sub4);
		
		Student stud2=new Student(2,"Prasaa",20,subjects2);
		et.begin();
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		em.persist(sub4);
		em.persist(stud1);
		em.persist(stud2);
		et.commit();
		
		
	}

}
