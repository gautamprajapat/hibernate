package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Pancard;
import entity_classes.Person;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		 Person p1=new Person(1,"Shubham",1111);
		 Pancard pan1=new Pancard(101,"Maharastra","1-01-1995");
		 p1.setPancard(pan1);
		 pan1.setPerson(p1);
		 
		 
		 Person p2=new Person(2,"Prasaad",2222);
		 Pancard pan2=new Pancard(102,"Delhi","10-05-2001");
		 p2.setPancard(pan2);
		 pan2.setPerson(p2);
		 
		 Person p3=new Person(3,"Ganesh",3333);
		 Pancard pan3=new Pancard(103,"Bihar","19-02-2000");
		 
		 et.begin();
		 em.persist(p1);
		 em.persist(p2);
		 em.persist(p3);
		 em.persist(pan1);
		 em.persist(pan2);
		 em.persist(pan3);
		 et.commit();
		 
		 
		 
	}

}
