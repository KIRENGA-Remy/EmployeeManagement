package mgt.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.JdbcSettings;
import org.hibernate.cfg.SchemaToolingSettings;
import org.hibernate.service.ServiceRegistry;

import mgt.model.Employee;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();

			// Database connection settings
			settings.put(JdbcSettings.DRIVER, "org.postgresql.Driver");
			settings.put(JdbcSettings.URL, "jdbc:postgresql://localhost:5432/student");
			settings.put(JdbcSettings.USER, "postgres");
			settings.put(JdbcSettings.PASS, "remy2020");

			// Hibernate dialect
			settings.put(JdbcSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

			// Enable Hibernate logging
			settings.put(JdbcSettings.SHOW_SQL, true);

			// Schema generation strategy
			settings.put(SchemaToolingSettings.HBM2DDL_AUTO, "create-drop");

			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Employee.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
