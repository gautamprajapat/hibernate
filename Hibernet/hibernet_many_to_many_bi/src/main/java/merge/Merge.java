package merge;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Student;
import entity_classes.Subject;

public class Merge {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student stud=em.find(Student.class, 2);
		Subject sub=em.find(Subject.class, 103);
		
		stud.getSubjects().add(sub);
		et.begin();
		em.merge(stud);
		et.commit();
		
	}

}
