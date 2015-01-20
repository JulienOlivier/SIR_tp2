package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	private EntityManager manager;
	classMetierHome hp1 = new classMetierHome();
	classMetierHome hp12 = new classMetierHome();
	classMetierHome hp2 = new classMetierHome();
	classMetierPerson p1 = new classMetierPerson();
	classMetierPerson p2 = new classMetierPerson();
	classMetierPerson p3 = new classMetierPerson();

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		test.createDB();

		tx.commit();

		// TODO run request
		test.listHome();

		System.out.println(".. done");
	}

	private void createDB(){
				
				List<classMetierHome> listHome = new ArrayList<classMetierHome>();
				listHome.add(hp1);
				listHome.add(hp12);
				
				p1.setHomes(listHome);
				
				List<classMetierHome> listHome2 = new ArrayList<classMetierHome>();
				listHome2.add(hp2);
				p2.setHomes(listHome2);

				manager.persist(hp1);
				manager.persist(hp12);
				manager.persist(hp2);
				manager.persist(p1);
				manager.persist(p2);
				manager.persist(p3);
	}
	private void listHome(){
		List<classMetierHome> listHome = manager.createQuery("SELECT h FROM Maison h",classMetierHome.class).getResultList();
		System.out.println("nb ligne : "+listHome.size());
		for(classMetierHome next : listHome)
			System.out.println("-> "+next);
	}
}
