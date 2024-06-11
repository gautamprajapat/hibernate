package remove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Author;
import entity_classes.Book;

public class RemoveMultiple {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_many_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//remove 102 and 104 records
		
		Author a=em.find(Author.class,1);
		List<Book>b=new ArrayList<>();
		
		List<Book>books=a.getBooks();
		Iterator<Book> itr=books.iterator();
		
		while(itr.hasNext())
		{
			Book temp=itr.next();
			if(temp.getId()==102 || temp.getId()==104)
			{
				b.add(temp);
				itr.remove();//
			}
		}//EOF while
		
		et.begin();
		
		em.merge(a);
		for(Book bks: b)
		{
			em.remove(bks);
			
		}
		et.commit();
		
	}

}
