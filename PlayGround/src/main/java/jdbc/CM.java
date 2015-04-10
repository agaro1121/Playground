package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class CM {

	private Properties properties = new Properties();
	private FileInputStream fileLoader;
	private static Connection connection;
//	private static final CM cm = new CM();
	
	private CM(){
		try {
			fileLoader = new FileInputStream("src/jdbcProperties.xml");
			properties.loadFromXML(fileLoader);
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("urlHome"), 
					properties.getProperty("username"),
					properties.getProperty("password"));
			System.out.println("Connection open");
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		return connection;
	}
	
	private static class CMHolder{
		public static final CM INSTANCE = new CM();
	}
	
	public static CM getInstance(){
//		CM cm = new CM();
		return CMHolder.INSTANCE;
	}

//	private void verifyDriver(){
//		try {
//			Class.forName(properties.getProperty("driver"));
//		} catch (ClassNotFoundException e1) {
//			System.out.println("Where is ur driver?");
//			e1.printStackTrace();
//		} 
//	}

//	public Connection connect(){
//		verifyDriver();
//		try {
//			connection = DriverManager.getConnection(properties.getProperty("urlHome"), 
//					properties.getProperty("username"),
//					properties.getProperty("password"));
//
//		} catch (SQLException e) {
//			System.out.println("Problem Connecting");
//			e.printStackTrace();
//		} 
//		System.out.println("Connected to DataBase!");
//		return connection;
//	}

	public static void disconnect(){
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Problem closing connection");
			e.printStackTrace();
		} 
		System.out.println("Connection now closed");
	}

//	public static void main(String[] args){
//		CM cm = new CM();
//		cm.connect();
//		cm.disconnect();
//	}
}
