package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Student;

public class InsertStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("autoincrement");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student st1=new Student("shubham",70);
		Student st2=new Student("shubham",70);
		Student st3=new Student("shubham",70);
		
		et.begin();
		em.persist(st1);
		em.persist(st2);
		em.persist(st1);
		et.commit();
	}

}
