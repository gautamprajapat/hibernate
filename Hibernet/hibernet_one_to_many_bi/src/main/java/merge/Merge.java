package merge;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Merge {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Author a=em.find(Author.class, 1);
//		Book b=em.find(Book.class, 105);
//		
//		a.getBooks().add(b);//adding book obj in list
//		b.setAuthor(a);
		Book b1=em.find(Book.class, 102);
		a.getBooks().add(b1);
		b1.setAuthor(a);
		
		et.begin();
		em.merge(a);
//		em.merge(b);
		em.merge(b1);
		et.commit();
	}

}
