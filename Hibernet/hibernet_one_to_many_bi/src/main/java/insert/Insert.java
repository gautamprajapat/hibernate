package insert;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Book b1=new Book(101,"book1",1000);
		Book b2=new Book(102,"book2",2000);
		Book b3=new Book(103,"book3",3000);
		Book b4=new Book(104,"book4",4000);
		Book b5=new Book(105,"book5",5000);
		
		List<Book>books1=new ArrayList<Book>();
		books1.add(b1);
		books1.add(b2);
		
		Author a1=new Author(1,"Shubham");
		a1.setBooks(books1);
		b1.setAuthor(a1);
		b2.setAuthor(a1);
		List<Book>books2=new ArrayList<Book>();
		books2.add(b3);
		books2.add(b4);
		
		Author a2=new Author(2,"Prashad");
		
		a2.setBooks(books2);
		b3.setAuthor(a2);
		b4.setAuthor(a2);
		b5.setAuthor(a2);
		
		et.begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		em.persist(b5);
		em.persist(a1);
		em.persist(a2);
		et.commit();
		
		
		
		
		
		
		
	}

}
