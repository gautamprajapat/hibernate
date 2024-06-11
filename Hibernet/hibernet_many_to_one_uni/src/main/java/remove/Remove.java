package remove;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Entity_classes.Product;
import Entity_classes.Review;

public class Remove {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_one_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		//remove product with id 2
		Product p=em.find(Product.class, 2);
		Query query=em.createQuery("select r from Review r");
		List<Review>reviews=query.getResultList();
		Iterator<Review>itr=reviews.iterator();
		while(itr.hasNext())
		{
			Review temp=itr.next();
			if(temp.getProduct().getId()!=2)
			{
				itr.remove();
			}
			else {
				temp.setProduct(null);
				
			}
		}
		et.begin();
		for(Review r:reviews)
		{
			em.merge(r);
		}
		
		em.remove(p);
		et.commit();
		
	}
	

}
