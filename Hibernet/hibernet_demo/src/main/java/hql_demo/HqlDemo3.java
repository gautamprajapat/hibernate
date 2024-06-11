package hql_demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernet_demo.Employee;





public class HqlDemo3 {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Query query=em.createQuery("select emp from Employee emp where emp.id =2");
		List<Employee>emp=query.getResultList();
		
		for(Employee e:emp)
		{
			System.out.println(e);
		}
		
		System.out.println("=========================================================");
		
		Query query2=em.createQuery("Select emp from Employee emp where emp.id in(1,2)");
		List<Employee> emps1=query2.getResultList();
		for(Employee e:emps1)
		{
			System.out.println(e);
		}
		
	}
		
}


	

