package remove;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class RemoveBook {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//remove book with id 102
		Book b=em.find(Book.class, 102);
		Author a=b.getAuthor();
		
		List<Book>books=a.getBooks();
		Iterator<Book>itr=books.iterator();
		while(itr.hasNext())
		{
			Book temp=itr.next();
			if(temp.getId()==102) {
				itr.remove();
			}
		}
		
		et.begin();
		em.merge(a);
		em.merge(b);
		et.commit();
		
		
		
	}

}
