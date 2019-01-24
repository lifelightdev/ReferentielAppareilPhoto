package test;

import org.hibernate.cfg.Configuration;

import life.light.common.persistence.HibernateUtil;

public class ConnectionBaseDeDonnees {

	public static void initBDD() {

		Configuration config = new Configuration().setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
				.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
				.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:appareilphoto")
				.setProperty("hibernate.connection.username", "sa")
				.setProperty("hibernate.connection.password", "")
				.setProperty("hibernate.connection.pool_size", "1")
				.setProperty("hibernate.connection.autocommit", "true")
				.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider")
				.setProperty("hibernate.hbm2ddl.auto", "create-drop")
				.setProperty("hibernate.show_sql", "true")
				.addResource("life/light/common/Marque.hbm.xml")
				.addResource("life/light/common/Modele.hbm.xml")
				.addResource("life/light/common/Type.hbm.xml")
				.addResource("life/light/common/Appareil.hbm.xml");
		HibernateUtil.setSessionFactory(config.buildSessionFactory());
	}

}
