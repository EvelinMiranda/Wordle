package wordle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

import application.Conexion;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Palabra {
	private String nombre;

	public Palabra() {
		
	}

	public Palabra(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	Connection conexiion = null;
	   
    PreparedStatement preparesStatement = null;
   
    ResultSet resultSet = null;
	
	public boolean validartamano(String cadena) {
		boolean q=true;
		
		if (cadena.length() <= 4 || cadena.length() >= 6 ) {
			JOptionPane.showMessageDialog(null, "La palabra debe tener cinco letras, intente de nuevo.");
		
			q=false;
	       
	        

		}
		System.out.println("requisito tamano: "+ q);
		return q;
		

	}
	

	
	
	public boolean buscarenBd(String palabra) {
		boolean p = false;
		conexiion = Conexion.conectar();
       	try {
       		preparesStatement = conexiion
       				.prepareStatement("select * from palabras where palabra= ?");
       		preparesStatement.setString(1,palabra);
   			resultSet = preparesStatement.executeQuery();
   			
   			if (resultSet.next()) {
   				String pal = resultSet.getString(1);
   				System.out.println("Palabra encontrada: "+pal);
   				p=true;
		
				}else {
					JOptionPane.showMessageDialog(null, "Esta palabra no se encuentra en la base de datos.");
				}
   			
   			conexiion.close();
   			
   			
   		} catch (Exception e) {
   			JOptionPane.showMessageDialog(null, "Error de acceso a la Base de Datos.");
   		}
		
       	System.out.println("requisito base de datos: "+p);
       	return p;
       	
		
	}
	
	public boolean validarMCN(String cadena) {
		
		int valorCod=0;
		int cont=0;
		boolean r=false;
	
		for (int i=0;i<cadena.length();i++){
			char caracter=cadena.charAt(i);
			valorCod= (int) caracter;
			if(valorCod <97 || valorCod>122) {
				cont++;	 
		}
		}
		if(cont==0) {
			 r=true;
			}
		else {
			JOptionPane.showMessageDialog(null, "La palabra no debe contener mayusculas, números ni caracteres epeciales, intentelo de nuevo.");
			
		}
		return r;
	}
	

	
	
	

}
