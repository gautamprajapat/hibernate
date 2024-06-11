package create_demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernet_demo.Employee;

public class CreateDemo {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Employee emp1=new Employee(1,"gautam",40000);
		Employee emp2=new Employee(2,"Akhil",50000);
		Employee emp3=new Employee(3,"Poonam",60000);
		Employee emp4=new Employee(4,"Goal",70000);
		
		et.begin();
		
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		
		et.commit();
		em.persist(emp4);
		System.out.println("Data Inserted");
	}

}
