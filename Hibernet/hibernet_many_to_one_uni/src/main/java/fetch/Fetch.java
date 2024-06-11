package fetch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity_classes.Product;
import Entity_classes.Review;

public class Fetch {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_one_uni");
		EntityManager em=emf.createEntityManager();
		Review r=em.find(Review.class, 101);
		Product p=r.getProduct();
		System.out.println(r);
		System.out.println(p);
	}

}
