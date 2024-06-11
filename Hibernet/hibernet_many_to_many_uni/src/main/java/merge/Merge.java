package merge;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Student;
import entity_classes.Subject;

public class Merge {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Student stud1=em.find(Student.class, 1);
		Subject sub1=em.find(Subject.class, 104);
		stud1.getSubjects().add(sub1);
		et.begin();
		em.merge(stud1);
		et.commit();
	}

}
