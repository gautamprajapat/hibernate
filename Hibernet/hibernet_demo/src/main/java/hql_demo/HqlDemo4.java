package hql_demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernet_demo.Employee;



public class HqlDemo4 {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Query query=em.createQuery("Select e from Employee e where  e.id=?1 or e.id=?2");
		query.setParameter(1, 1);
		query.setParameter(2, 2);
		List<Employee>emps=query.getResultList();
		for(Employee e:emps)
		{
			System.out.println(e);
		}
		
		
		System.out.println("=========================================================");
		
		Query query1=em.createQuery("select e from Employee e where e.id=:id1 or e.id=:id2");
		query1.setParameter("id1", 1);
		query1.setParameter("id2", 2);
		
		List<Employee>emps1=query1.getResultList();
		for(Employee e:emps1)
		{
			System.out.println(e);
		}
		
		
	}
}
