package fetch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Fetch {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Author a= em.find(Author.class, 1);
		System.out.println(a);
		
		List<Book>books=a.getBooks();
		
		for(Book b:books)
		{
			System.out.println(b);
		}
		
	}

}
