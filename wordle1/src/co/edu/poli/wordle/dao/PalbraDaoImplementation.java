package co.edu.poli.wordle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import co.edu.poli.wordle.model.Palabra;
import co.edu.poli.wordle.util.DatabaseConnection;

public class PalbraDaoImplementation implements PalabraDao {
	
	static Connection con = DatabaseConnection.getConnection();
	
	
	
	
	
	//seleccionar palabra de la base de datos
	@Override
	public Palabra getPalabra() throws SQLException {
		Palabra p = new Palabra();
		try {
			String query = "select * from palabras order by rand() limit 1";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				String pal = rs.getString(1);
				p.setNombre(pal);
   				 
			}
			else {
				
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de acceso a la Base de Datos.");
		}
		JOptionPane.showMessageDialog(null, "Se inició un nuevo juego!!");
		System.out.println(" nombre de objeo a adivinar: "+p.getNombre());
		return p;
		 
	}
	
	
	
	
	
	//validar si la palabra que ingresó el usuario está en la base de datos
	@Override
	public boolean getPalabra2(String palabra) throws SQLException {
		boolean p = false;
		try {
			String query = "select * from palabras where palabra= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, palabra);
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				//String pal = rs.getString(1);
   				p=true;
			}
			else {
				JOptionPane.showMessageDialog(null, "La palabra no se encuentra en la Base de Datos.");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de acceso a la Base de Datos.");
		}
		System.out.println("la palabra ingresada esta en bd: "+ p);
		return p;
	}

}
