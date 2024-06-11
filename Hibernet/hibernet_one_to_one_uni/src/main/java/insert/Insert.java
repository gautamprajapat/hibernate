package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Pancard;
import entity_classes.Person;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Pancard pan1=new Pancard(101,"Delhi","1-jan-2000");
		Person p1=new Person(1,"shubham",1111,pan1);
		
		Pancard pan2=new Pancard(102,"Mumbai","10-jan-2002");
		Person p2=new Person(2,"Shivam",2222,pan2);
		
		Pancard pan3=new Pancard(103,"Pune","10-Dec-2005");
		Person p3=new Person(3,"Gautam",2222,null);
		
		et.begin();
		em.persist(pan1);
		em.persist(pan2);
		em.persist(pan3);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		et.commit();
		
		
		
		
		
	}

}
