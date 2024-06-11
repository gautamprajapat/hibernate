package merge;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Pancard;
import entity_classes.Person;

public class Merge {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Person p=em.find(Person.class, 3);
		Pancard pan=em.find(Pancard.class, 103);
		p.setPancard(pan);
		pan.setPerson(p);
		et.begin();
		em.merge(p);
		em.merge(pan);
		
		et.commit();
	}

}
