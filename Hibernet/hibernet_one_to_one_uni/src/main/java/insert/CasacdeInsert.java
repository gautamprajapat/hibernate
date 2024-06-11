package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Pancard;
import entity_classes.Person;

public class CasacdeInsert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Pancard pan=new Pancard(333,"Mumbai","syz");
		Person  person=new Person(9,"shubham",77777,pan);
		et.begin();
		em.persist(person);
		et.commit();
	}

}
