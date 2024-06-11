package remove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity_classes.Student;
import entity_classes.Subject;

public class Remove {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		//remove subject with id 102
		Subject sub=em.find(Subject.class, 102);
		Query query=em.createQuery("select s from Student s");
		List<Student>students=query.getResultList();
		
		for(Student s:students)
		{
			Iterator<Subject>itr=s.getSubjects().iterator();
			while(itr.hasNext())
			{
				Subject temp=itr.next();
				if(temp.getId()==102)
				{
					itr.remove();
				}
				
			}
		}//eof for
		et.begin();
		for(Student s:students)
		{
			em.merge(s);
		}
		em.remove(sub);
		et.commit();
		
	}

}
