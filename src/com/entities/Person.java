package com.entities;
/**
 * @author Daniel Tellez Rodriguez
 *
 */
public class Person{
	
	private String numIdentification;
	private String name;
	private String telephone;
	private String address;
	
	/*
	* Methods get and setters 
	*/
	public String getNumIdentification() {
		return numIdentification;
	}
	public void setNumIdentification(String numIdentification) {
		this.numIdentification = numIdentification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
