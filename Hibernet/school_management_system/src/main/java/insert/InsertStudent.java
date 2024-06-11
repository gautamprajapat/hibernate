package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.ClassRoom;
import entity_classes.Student;

public class InsertStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("school_management_system_demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Student stud1=new Student(101,"gautam",22,null);
		Student stud2=new Student(102,"kiran",19,null);
		Student stud3=new Student(103,"Virat",20,null);
		Student stud4=new Student(104,"Shubham",22,null);
		Student stud5=new Student(105,"Shivam",22,null);
		
		ClassRoom classroom1=new ClassRoom(201,"1st");
		ClassRoom classroom2=new ClassRoom(202,"2nd");
		ClassRoom classroom3=new ClassRoom(203,"third");
		ClassRoom classroom4=new ClassRoom(204,"fourth");
		ClassRoom classroom5=new ClassRoom(205,"fifth");
		stud1.setClassRoom(classroom1);
		stud2.setClassRoom(classroom2);
		stud3.setClassRoom(classroom3);
		stud3.setClassRoom(classroom4);
		stud1.setClassRoom(classroom5);
		et.begin();
		em.persist(classroom1);
		em.persist(classroom2);
		em.persist(classroom3);
		em.persist(classroom4);
		em.persist(classroom5);
		
		em.persist(stud1);
		em.persist(stud2);
		em.persist(stud3);
		em.persist(stud4);
		em.persist(stud5);
		et.commit();
		
		
	}

}
