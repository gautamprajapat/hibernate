package fetch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity_classes.Student;
import entity_classes.Subject;

public class Fetch {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_uni");
		EntityManager em=emf.createEntityManager();
		Student stud1=em.find(Student.class, 1);
		System.out.println(stud1);
		List<Subject>subjects=stud1.getSubjects();
		System.out.println();
		for(Subject s:subjects)
		{
			System.out.println(s);
		}
	}

}
