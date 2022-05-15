package fr.formation.filmotheque.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	
	static {
		emf = Persistence.createEntityManagerFactory("monpu");
		em = emf.createEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		return em;
	}
	
	public static void close() {
		em.close();
		emf.close();
	}
	public static void open(){
		emf = Persistence.createEntityManagerFactory("monpu");
		em = emf.createEntityManager();
	}
	
}
