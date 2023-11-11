package jpautil;

import javax.persistence.*;


public class JPAUtil {
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager() {

		if(emf == null) {
			
			emf = Persistence.createEntityManagerFactory( "SubmissionPersistence" );

			
		}
		return emf.createEntityManager();
	}
	
	public static void closeEntityManager() {
		emf.close();
	}
}

