package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Category;
import com.niit.models.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	private SessionFactory sessionFactory;
	public Product saveProduct(Product product) {
		//id=0,productname="pen",productdesc="pen",price=100,quantity=100.
				//get session object from SessionFactory.
				
				Session session=sessionFactory.getCurrentSession();//session is a connection.
				System.out.println("Id of the product before persisting " + product.getId());
				
				session.save(product);//generate an insert a query,insert the data into product table.
				System.out.println("Id of the product after persisting" + product.getId());

				return product;//id will have some value.
	}

	public Product getProduct(int id) {
		Session session =sessionFactory.getCurrentSession();
		//Method in API to perform the read operation.
		Product product=(Product)session.get(Product.class,id);  //Product is class name.immediately fetch the data in table.
		return product;
	}

	public void updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);//Method in API to perform the update.
		//return product;
	}

	public void deleteProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class,id);
		if(product!=null)
			//Method in API to perform the delete
		session.delete(product);//delete from product where id=?
	}

	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product");//Product is an entity.HQL query.
		List<Product> products=query.list();
		return products;
	}

	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");//Product(class name) is an entity.HQL query.
		List<Category> categories=query.list();
		return categories;
	}

}
