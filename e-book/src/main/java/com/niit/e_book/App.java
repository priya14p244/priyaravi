package com.niit.e_book;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.dbconfiguration.DbConfig;

public class App {
	 public static void main( String[] args )
	    {
	        System.out.println( "Hello World!" );
	        ApplicationContext context=new AnnotationConfigApplicationContext(DbConfig.class,ProductDaoImpl.class);
	        ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
	        
	        //THis object will get Stored in Heap memory only because it is not annotated anything.
			/*Product product=new Product();  //new product.This mapped with the table
			product.setProductname("car");
			product.setProductdesc("Description about car");
			product.setPrice(200000);
			product.setQuantity(10000);
			productDao.saveProduct(product);
			
			/*Product product=productDao.getProduct(2);
			product.setPrice(20000);
			product.setQuantity(200);
			productDao.updateProduct(product);
			System.out.println(product.getPrice());
			System.out.println(product.getQuantity());
			System.out.println(product.getProductname());*/
			
			//productDao.deleteProduct(74);
			
			/*List<Product> products=productDao.getAllProducts();
			for(Product p : products)//for each loop or enhanced loop
			{
				System.out.println(p.getId() + " " + p.getProductname() + " " + p.getProductdesc() + " " + p.getPrice() + " " + p.getQuantity());
			}
*/
	    }
}
