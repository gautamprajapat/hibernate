package remove;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Student;
import entity_classes.Subject;

public class RemoveSubjects {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//remove the subject with id 102
		Subject sub=em.find(Subject.class, 102);
		List<Student>students=sub.getStudents();
		for(Student stud:students)
		{
			Iterator<Subject>itr=stud.getSubjects().iterator();
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
		for(Student s:students) {
			em.merge(s);
		}
		em.remove(sub);
		et.commit();
	}

}
