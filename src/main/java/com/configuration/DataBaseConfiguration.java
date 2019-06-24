package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@ComponentScan({"com.configuration"})
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class DataBaseConfiguration {
	@Autowired
	private Environment environment;

	/*
	 * The objects that form the backbone of your application and that are
	 * managed by the Spring IoC container are called beans. A bean is an object
	 * that is instantiated, assembled, and otherwise managed by a Spring IoC
	 * container. These beans are created with the configuration metadata that
	 * you supply to the container.
	 */

	/*
	 * The @Bean annotation tells Spring that a method annotated with @Bean will
	 * return an object that should be registered as a bean in the Spring
	 * application context.
	 * 
	 * 
	 * eg:ApplicationContext ctx = new
	 * AnnotationConfigApplicationContext(HelloWorldConfig.class);
	 * 
	 * HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource
				.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource
				.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	private Properties hibernateProperties() {

		/*
		 * Properties is a subclass of Hashtable. It is used to maintain lists
		 * of values in which the key is a String and the value is also a
		 * String.
		 * 
		 * The Properties class is used by many other Java classes. For example,
		 * it is the type of object returned by System.getProperties( ) when
		 * obtaining environmental values.
		 */
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",
				environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto",
				environment.getRequiredProperty("hibernate.createTable"));
		return properties;
	}

	/*
	 * SessionFactory is an interface, which is available in “org.hibernate”
	 * package. Session factory is long live multithreaded object. Usually one
	 * session factory should be created for one database. When you have
	 * multiple databases in your application you should create multiple
	 * SessionFactory object. Assume the scenario that you are using one
	 * database called mysql in your application then following is the way to
	 * create the SessionFactory object.
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.MO" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
	
}
