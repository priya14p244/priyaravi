package com.niit.models;

import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

	@Entity
	public class Product 
	{
		@Id //make this id as primary key by using this annotation. unique and not null
		@GeneratedValue(strategy=GenerationType.AUTO)//auto generate(auto increament) - automatically generate a value.It will be unique always and not null.
		private int id;
		@NotEmpty(message="Productname cannot be empty")
		private String productname;
		@NotEmpty(message="Productname cannot be empty")
		private String productdesc;
		@Min(value=1,message="Minimum value for price is 1")
		private int price;
		@Min(value=0,message="Quantity cannot be less than 0")//user cannot give -ve values for quantity
		private int quantity;
		@ManyToOne
		private Category category;
		@Transient
		private MultipartFile image;
		
		public MultipartFile getImage() {
			return image;
		}
		public void setImage(MultipartFile image) {
			this.image = image;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getProductdesc() {
			return productdesc;
		}
		public void setProductdesc(String productdesc) {
			this.productdesc = productdesc;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}	
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
	}

