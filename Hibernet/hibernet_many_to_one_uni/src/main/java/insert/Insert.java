package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity_classes.Product;
import Entity_classes.Review;

public class Insert {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_one_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Product p1=new Product(1,"IPhone",80000);
		Review r1=new Review(101,4.5,"good Product",p1);
		Review r2=new Review(102,4.7,"Execelent",p1);
		
		Product p2=new Product(2,"Nokia",90000);
		Review r3=new Review(103,1.7,"poor",p2);
		Review r4=new Review(104,2.0,"Heat Quick",p2);
		
		et.begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
		em.persist(r4);
		
		et.commit();
		
		
		
		
		
		
	}

}
