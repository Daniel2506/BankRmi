package com.connections;

/**
 * @author Daniel Tellez Rodriguez
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionDB {
	private Connection connection;
    /*private ResultSet resultSet;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String message;*/
    private String driver;
    private String url;
    private String user;
    private String pswd;
    
    /*
     * Method constructor class
     */
    public ConnectionDB() {
    	this.connection = null;
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/bank";
        this.user = "root";
        this.pswd = "";
    }
    /*
    * Method for get Connection
    */
    public Connection getConnection() {
		return connection;
	}
    
    /**
     * Method for instance Connection DB
     * @return Boolean
     */
	public Boolean connectionDb(){
        try {
            Class.forName(driver);
            System.out.println("hola");
            connection = (Connection) DriverManager.getConnection(url, user, pswd);
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("HOLA MAL");
            return false;
        }
        return true;
    }
	
    public ResultSet consult(String sql){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
	 /**
     * Method for close instance Connection DB
     * @return Boolean
     */
    public Boolean closeDb() {
    	Boolean success = false;
    	if(connection != null) {
    		try {
				connection.close();
				success =  true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return success;
    }
}
