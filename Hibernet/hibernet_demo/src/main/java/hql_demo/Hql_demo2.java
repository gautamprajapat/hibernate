package hql_demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernet_demo.Employee;

public class Hql_demo2 {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Query query=em.createQuery("select emp.name,emp.salary from Employee emp");
		List<Object[]>data=query.getResultList();
		
		for(Object[] obj:data)
		{
			String name=(String)obj[0];
			double salary=(Double)obj[1];
			System.out.println(name+"  "+salary);
		}
		
		
	}

}
