package remove;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class RemoveAuthor {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//remove author no.2
		Author a=em.find(Author.class, 2);
		List<Book> books=a.getBooks();
		
		for(Book b: books) {
			b.setAuthor(null);
		}
		
		et.begin();
		for(Book b:books)
		{
			em.merge(b);
		}
		et.commit();
	}

}
