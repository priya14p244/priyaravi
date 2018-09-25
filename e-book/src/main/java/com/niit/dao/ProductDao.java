package com.niit.dao;

import java.util.List;

import com.niit.models.Category;
import com.niit.models.Product;


public interface ProductDao 
{
	Product saveProduct(Product product); // product.id=0. treated as a new object
	  //insert operation in Hibernate.
Product getProduct(int id);

void updateProduct(Product product);//product.id= , already existing obj , update.

void deleteProduct(int id);

//to fetch all the record in the product table.
//E=>refers to what type of object we are going to get form the list of product object.
List<Product> getAllProducts(); 
List<Category> getAllCategories();
}
