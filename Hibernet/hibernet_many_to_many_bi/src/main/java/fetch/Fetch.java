package fetch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_classes.Student;
import entity_classes.Subject;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("many_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student stud=em.find(Student.class, 1);
		List<Subject>subjects=stud.getSubjects();
		for(Subject s:subjects)
		{
			System.out.println(s);
		}
		
		Subject sub=em.find(Subject.class, 102);
		List<Student>students=sub.getStudents();
		for(Student stu:students)
		{
			System.out.println(stu);
		}
		
	}

}
