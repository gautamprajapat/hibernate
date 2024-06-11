package remove;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Pancard;
import entity_classes.Person;

public class Remove {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//remove pancard with id 102
		
		Pancard pan=em.find(Pancard.class, 102);
		Person p=pan.getPerson();
		p.setPancard(null);
		
		et.begin();
		em.merge(p);
		em.remove(pan);
		et.commit();
		
	}

}
