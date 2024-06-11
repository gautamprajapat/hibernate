package hql_demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernet_demo.Employee;


public class HqlDemo {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Query query=em.createQuery("select emp from Employee emp");
		List<Employee> emps=query.getResultList();
		
		for(Employee  e:emps)
		{
			System.out.println(e);
		}
		
		
	}
	

	
}
