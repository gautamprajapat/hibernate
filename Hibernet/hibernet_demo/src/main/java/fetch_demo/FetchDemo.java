package fetch_demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernet_demo.Employee;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("demo");
		EntityManager em=emf.createEntityManager();
		
		Employee emp=em.find(Employee.class, 1);
		Employee emp1=em.find(Employee.class, 2);
		Employee emp2=em.find(Employee.class, 3);
		Employee emp3=em.find(Employee.class, 4);
		
		System.out.println(emp);
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		
	}
	
	
	

}
