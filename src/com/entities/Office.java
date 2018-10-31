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
		ConnectionDB connect = new ConnectionDB();
		if(connect.connectionDb()) {
			ResultSet rs = connect.consult("SELECT * FROM alumnos ORDER BY alumnos.id ASC");
			if(connect.closeDb()) {
				/*Office o ;
				o.setCityOffice(cityOffice);
				o.setCityOffice(cityOffice);*/
			}
		};
		
		return null;
	}
}
