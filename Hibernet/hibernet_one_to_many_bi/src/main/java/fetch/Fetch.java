package fetch;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_bi");
		EntityManager em=emf.createEntityManager();
		
		Author a=em.find(Author.class, 1);
		List<Book> books=a.getBooks();
		
		for(Book b:books)
		{
			System.out.println(b);
		}
		
		Book b1=em.find(Book.class, 103);
		Author a1=b1.getAuthor();
		System.out.println(b1);
		System.out.println(a1);
		
		
	}

}
