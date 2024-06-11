package insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Employee;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("autoincrement");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Employee e1=new Employee("Shubham",100000);
		Employee e2=new Employee("Shivam",200000);
		Employee e3=new Employee("sunny",300000);
		
		et.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		et.commit();
		
	}

}
