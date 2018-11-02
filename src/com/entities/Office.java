package com.entities;

import java.sql.ResultSet;

import com.connections.ConnectionDB;

/**
 * @author Daniel Tellez Rodriguez
 *
 */
public class Office {

	private String name;
	private City   cityOffice;
	
	public Office() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCityOffice() {
		return cityOffice;
	}

	public void setCityOffice(City cityOffice) {
		this.cityOffice = cityOffice;
	}

	public static Office getOffice(String name) {
		Office office = new Office();
		ConnectionDB connect = new ConnectionDB();
		if(connect.connectionDb()) {
			String querySelect = "SELECT * FROM uniminuto_sucursal us WHERE us.sucursal_nombre = " + name;
			ResultSet rs = connect.consult(querySelect);
			if(connect.closeDb()) {
				// while (rs){}
				office.setName("1");
				office.setCityOffice(null);
			}
		};
		
		return office;
	}
}
