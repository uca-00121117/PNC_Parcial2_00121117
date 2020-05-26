package com.uca.capas.modelo.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		/*
		 (Clase 12)->LocalContainerEntityManagerFactoryBean: Es utilizado para crear un EntityManagerFactory, 
		 esta es creada como un Singleton (una sola instancia compartida para todas las clases), 
		 ya que es un objeto muy pesado en características.
		 */
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		/*
		  (Clase 12)-> DataSource: Contiene la información de conexión a la base de datos 
		 que utilizará el Entity Manager
		 */
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("modelo-persistence");
		em.setPackagesToScan("com.uca.capas.modelo.domain");
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties());
		return em;		
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/parcial2");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
	}
	/*
	 	(Clase 12)->Properties: Son características propias de Hibernate y 
	 		son utilizadas para depurar queries, operaciones sobre la base de datos, etc.
	 */
	Properties hibernateProperties() {
		Properties properties = new Properties();
		/*
		  	(Clase 12)-> Hibernate.show_sql=true: Esta propiedad
			 indica si queremos que las consultas SQL que se 
			 hacen desde nuestro aplicativo a la base de datos se 
			 impriman en la consola con fines de depuración.
		 */
		properties.setProperty("hibernate.show_sql", "true");
		/*
		 	(Clase 12)-> Hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect: 
		 	Hibernate trabaja con el concepto de dialectos, los cuales utiliza para generar 
			el SQL correspondiente a la base de datos que estamos trabajando.
			En nuestro caso le definiremos el de Postgres, sin embargo tiene soporte
			para muchos mas, como Oracle, SQL Server, MySQL, etc.
		 */
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		/*
		    (Clase 12)-> Hibernate.enable_lazy_load_no_trans=true: 
			Esta propiedad sirve para manejar el estado Lazy de las relaciones de las entidades
			(el cual veremos a mayor detalle en las próximas clases)
			C 16
			Esto habilita el uso de la sesión para obtener la colección
			 al momento de llamar al método get correspondiente.
		*/
		properties.setProperty("hibernate.enable_lazy_load_no_trans","true");
		return properties;
	}
}