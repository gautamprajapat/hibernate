package fetch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import entity_classes.Pancard;
import entity_classes.Person;

public class Fetch {
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_bi");
		EntityManager em=emf.createEntityManager();
		Person p1=em.find(Person.class, 1);
		Pancard pan1=p1.getPancard();
		System.out.println(p1);
		System.out.println(pan1);
		
		Person p2=em.find(Person.class, 2);
		Pancard pan2=p2.getPancard();
		System.out.println(p2);
		System.out.println(pan2);
	}

}
