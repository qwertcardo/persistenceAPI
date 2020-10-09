package br.com.qwertcardo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
