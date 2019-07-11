package com.javasampleapproach.jpamysqlangular4.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L; 
	@Id // https://docs.oracle.com/javaee/6/api/javax/persistence/Id.html
	@GeneratedValue(strategy = GenerationType.AUTO) //id-autoincremental like in SQL
	private long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "account_type")
	private String account_type;
	
	@Column(name = "telephone_no")
	private String telephone_no;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;

	@Column(name= "state")
	private String state;
	
	@Column(name = "zip")
	private String zip;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getTelephone_no() {
		return telephone_no;
	}

	public void setTelephone_no(String telephone_no) {
		this.telephone_no = telephone_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	protected Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Customer(String firstName, String lastName, String email,
			String username, String password , String account_type,
            String telephone_no , String address, String city,
            String state , String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email= email;
		this.username= username;
		this.password= password;
		this.account_type= account_type;
		this.telephone_no= telephone_no;
		this.address= address;
		this.city= city;
		this.state= state;
		this.zip= zip;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s',email='%s',username='%s',password='%s',account_type='%s',telephone_no='%s',address='%s',city='%s',state='%s', zip='%s']", id, firstName, lastName, email , username, password, account_type, telephone_no, address, city, state , zip);
	}
}