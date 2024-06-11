package remove;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class Remove {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_uni");

		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//remove of book->102
		
		Author a=em.find(Author.class, 1);
		Book b=null;
		List<Book>books =a.getBooks();
		Iterator<Book>itr=books.iterator();
		while(itr.hasNext())
		{
			Book temp=itr.next();
			if(temp.getId()==102)
			{
				b=temp;
				itr.remove();//removing the book present in author list with id 102
			}
		}//end of while loop
		
		et.begin();
		em.merge(a);
		em.remove(b);
		et.commit();
		
	}

}
