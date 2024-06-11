package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Pancard1;

import entity_classes.Person1;

public class Insert1 {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Person1 p1=new Person1(1,"shubham",1111);
		
		Pancard1 pan1=new Pancard1(101,"Maharashtra","1-05-2000");
		p1.setPancard1(pan1);
		pan1.setPerson1(p1);
		
		Person1 p2=new Person1(2,"Gautam",2222);
		
		Pancard1 pan2=new Pancard1(102,"Delhi","9-05-2010");
		p2.setPancard1(pan2);
		pan2.setPerson1(p2);
		
		et.begin();
		
		em.persist(p1);
		em.persist(p2);
		em.persist(pan1);
		em.persist(pan2);
		et.commit();
		
		
		
		
	}

}
