package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;


import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wordle.model.Palabra;
import javafx.scene.Scene;

public class InterfazController {
	@FXML
	private Button btn3;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Label lb1;
	@FXML
	private TextField txt;
	@FXML
	private TableView tb;
	@FXML
	private TableColumn c1;
	@FXML
	private TableColumn c2;
	@FXML
	private TableColumn c3;
	@FXML
	private TableColumn c4;
	@FXML
	private TableColumn c5;

	Connection conexiion = null;
	   
    PreparedStatement preparesStatement = null;
   
    ResultSet resultSet = null;
    
    
    
    
    
    
	// Enviar la palabra
	@FXML
	public void enviar(ActionEvent event) {
		
		Palabra p= new Palabra();
		p.setNombre(txt.getText());
		
		if (p.validartamano(p.getNombre())) {
			if (p.validarMCN(p.getNombre())) {
				if (p.buscarenBd(p.getNombre())) {
					
				}
				else {
					txt.setText("");
					p.setNombre("");
				}
				
			}
			else {
				txt.setText("");
				p.setNombre("");
				
			}
			
			
			}
		else {
			txt.setText("");
			p.setNombre("");
		}
		
		
		
		
		
		
		System.out.println("palabra: "+p.getNombre());
		
	
	
		
	}
	
	
	
	
	
	
	
	// Iniciar juego
	@FXML
	public void jugar(ActionEvent event) {
		conexiion = Conexion.conectar();
       	try {
       		preparesStatement = conexiion
       				.prepareStatement("select * from palabras order by rand() limit 1");
   			
   			resultSet = preparesStatement.executeQuery();
   			
   			if (resultSet.next()) {
   				String pal = resultSet.getString(1);
   				System.out.println("Palabra a adivinar: "+pal);
		
				}else {
					
				}
   			
   			conexiion.close();
   			
   			
   		} catch (Exception e) {
   			JOptionPane.showMessageDialog(null, "Error de acceso a la Base de Datos.");
   		}
       	JOptionPane.showMessageDialog(null, "Se inició un nuevo juego!!");
	}
	
	
	
	
	
	
	
	
	// Desplegar reglas de juego
	@FXML
	public void ayudar(ActionEvent event) {
		
		JOptionPane.showMessageDialog(null, "REGLAS DE JUEGO!!"+"\n "+
		"  - Adivine la palabra oculta en un máximo de cinco intentos."+"\n "+
				"  - Cada intento debe ser una palabra de 5 letras."+"\n "+
		"  - Las palabras ingresadas no deben tener caracteres especiales."+"\n "+
				"  - Si la letra aparece en verde, es porque ha acertado y está en la palabra, y también está en la casilla correcta de la palabra."
		+"\n "+"  - Si la letra aparece en amarillo, es porque está en la palabra, pero no está en la casilla correcta."+"\n "
				+"  - Si la letra aparece sin resaltar es porque no ha acertado, y no está en la palabra que tienes que adivinar.");
		
		/*
		final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Reglas Wordle");
        
        VBox dialogVbox = new VBox(20);
       
        dialogVbox.getChildren().add(new Text(" "));
        dialogVbox.getChildren().add(new Text("                  									  REGLAS DE JUEGO "));
        dialogVbox.getChildren().add(new Text(" "));
        dialogVbox.getChildren().add(new Text("         - Adivine la palabra oculta en un máximo de cinco intentos."));
        dialogVbox.getChildren().add(new Text("         - Cada intento debe ser una palabra de 5 letras."));
        dialogVbox.getChildren().add(new Text("         - Las palabras ingresadas no deben tener caracteres especiales."));
        dialogVbox.getChildren().add(new Text("         - Si la letra aparece en verde, es porque ha acertado y está en la palabra, y también está en la casilla correcta de la palabra."));
        dialogVbox.getChildren().add(new Text("         - Si la letra aparece en amarillo, es porque está en la palabra, pero no está en la casilla correcta."));
        dialogVbox.getChildren().add(new Text("         - Si la letra aparece sin resaltar es porque no ha acertado, y no está en la palabra que tienes que adivinar."));

        Scene dialogScene = new Scene(dialogVbox, 900, 500);
        dialog.setScene(dialogScene);
        dialog.show();*/
	}
}
