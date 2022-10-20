package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection conectar() {
		Connection cn= null;
		
		try {
			cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/wordle ", "root", "t1l2o3t4r5");
			
			if (cn != null) {
				System.out.println("Conexión exitosa");
			}
			else {
				System.out.println("Error en la conexión");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
		
		return cn;
	}

}
