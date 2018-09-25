package com.niit.dbconfiguration;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.models.Authorities;
import com.niit.models.BillingAddress;
import com.niit.models.CartItem;
import com.niit.models.Category;
import com.niit.models.Customer;
import com.niit.models.CustomerOrder;
import com.niit.models.Product;
import com.niit.models.ShippingAddress;
import com.niit.models.User;


	@Configuration // Tells the container that the class has some bean configuration.
	//the class can be used by the  spring IoC(Inversion of control) conainer as a source of bean definitions.
	@EnableTransactionManagement //commit or rollback
	public class DbConfig  
	{	//to create bean.
		public DbConfig ()
		{
			System.out.println("DBConfig bean is created");
		}
		@Bean(name="datasource")
		public  DataSource getDataSource(){
			System.out.println("Entering DataSourceBean Creation");
			BasicDataSource datasource = new BasicDataSource();//all the information about
					datasource.setDriverClassName("org.h2.Driver");
			        datasource.setUrl("jdbc:h2:tcp://localhost/~/final");
			        datasource.setUsername("final");
			        datasource.setPassword("final");
					return datasource;
					
		}
		/*
		 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
		 * <prperty name="datasource" ref="datasource">
		 * 	 */
		@Bean
		public SessionFactory sessionFactory()
		{
			LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getDataSource());
			Properties hibernateProperties=new Properties();
			//hbm2ddl=>hibernate mapping -> create alter drop.
			hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");//ddl=> data definition language. Create , Alter , Drop
			hibernateProperties.setProperty("hibernate.show_sql","true");

			factory.addProperties(hibernateProperties); 
		
			//class object of an Entity product
			//Map all the entities to relational table.
			//An array of class objects of all the entities
			Class classes[]=new Class[]{Product.class,Category.class,User.class,Customer.class,Authorities.class,BillingAddress.class,ShippingAddress.class,CartItem.class,CustomerOrder.class};
			System.out.println("SessionFactory bean" + factory) ;
			return factory.addAnnotatedClasses(classes).buildSessionFactory();//using this it will create a sessionFactory;
		}
		@Bean
		public HibernateTransactionManager hibTransManagement()
		{
			return new HibernateTransactionManager(sessionFactory());
		}
		
	}
