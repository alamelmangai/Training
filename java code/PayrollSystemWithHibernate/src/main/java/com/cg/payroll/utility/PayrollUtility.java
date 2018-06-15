package com.cg.payroll.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.payroll.exceptions.PayrollServicesDownExceptions;
public class PayrollUtility{
	private static Connection con = null;
	public static Connection getDBConnection() throws PayrollServicesDownExceptions{
		
			try {
				if(con==null){
					/*FileInputStream src = new FileInputStream(new File(".//resource//payroll.properties"));
					Properties properties = new Properties();
					properties.load(src);
					properties.load(new FileInputStream(new File(".//resource//payroll.properties")));
					String driver = properties.getProperty("driver");
					String url = properties.getProperty("url");
					String username = properties.getProperty("username");
					Class.forName(driver);*/
					Properties properties = new Properties();
					properties.load(new FileInputStream(new File(".//resource//payroll.properties")));
					Class.forName(properties.getProperty("driver"));
					con = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"), "");  
				}
			/*} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}*/
			return con;
		} catch  (ClassNotFoundException | IOException | SQLException e){
			e.printStackTrace();
			throw new PayrollServicesDownExceptions("Payroll Services are down plz try later", e);
		}*/
	}
}
