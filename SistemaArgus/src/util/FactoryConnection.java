package util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryConnection {

	private static Map<String, String> propriedades = new HashMap<>();

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BANCO", propriedades);
		return factory.createEntityManager();
	}

	public static void alterarPropriedades(boolean init) {
		if (init) {
			propriedades.put("hibernate.hbm2ddl.import_files", "/META-INF/sql/init.sql");
			propriedades.put("hibernate.hbm2ddl.auto", "create");
			System.out.println(propriedades);
		} else {
			propriedades.remove("hibernate.hbm2ddl.import_files");
			propriedades.put("hibernate.hbm2ddl.auto", "update");
			System.out.println(propriedades);
		}
	}

}
