package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity_class.Employee;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("attribute");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Employee emp1=new Employee(101,"Shubham",18, "Qspider",9987654543L);
		Employee emp2=new Employee(103,null,18, "Qspider",9987654543L);
		et.begin();
//		em.persist(emp1);
		em.persist(emp2);
		et.commit();
	}

}
