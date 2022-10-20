package co.edu.poli.wordle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//conexion a base de datos
public class DatabaseConnection {
	
	private static Connection con = null;
	  static
	    {
	        String url = "jdbc:mysql:// localhost:3306/wordle";
	        String user = "root";
	        String pass = "t1l2o3t4r5";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	            System.out.println("Conexión a base de datos exitosa!!");
	        }
	        catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static Connection getConnection()
	    {
	        return con;
	    }

}
