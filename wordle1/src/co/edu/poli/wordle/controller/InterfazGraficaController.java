package co.edu.poli.wordle.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import co.edu.poli.wordle.dao.PalabraDao;
import co.edu.poli.wordle.dao.PalbraDaoImplementation;
import co.edu.poli.wordle.model.Palabra;
import co.edu.poli.wordle.model.PalabraUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class InterfazGraficaController implements Initializable {
	@FXML
	private Label lb1;
	@FXML
	private Button btn3;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private TextField txt;
	@FXML
	private TableView<PalabraUsuario> tb;
	@FXML
	private TableColumn <PalabraUsuario,String> c1;
	@FXML
	private TableColumn <PalabraUsuario,String> c2;
	@FXML
	private TableColumn <PalabraUsuario,String> c3;
	@FXML
	private TableColumn <PalabraUsuario,String> c4;
	@FXML
	private TableColumn <PalabraUsuario,String> c5;
	
	
	ObservableList<PalabraUsuario> list= FXCollections.observableArrayList();
	
	
	
	

	// Event Listener on Button[#btn3].onAction
	Palabra pbd = new Palabra();
	PalabraUsuario pu = new PalabraUsuario();
	PalbraDaoImplementation palDao = new PalbraDaoImplementation();
	
	
	@FXML
	public void enviar(ActionEvent event) throws SQLException {
		
		boolean as = false;
		
		
		pu.setNombre(txt.getText());
		as= palDao.getPalabra2(txt.getText());
		
		
		//Implementacion de validaciones
		if (pu.validartamano()) {
			if (pu.validarMCN()) {
				if (as) {
					
					pu.setLetra1(pu.getNombre().substring(0, 1));
					pu.setLetra2(pu.getNombre().substring(1, 2));
					pu.setLetra3(pu.getNombre().substring(2, 3));
					pu.setLetra4(pu.getNombre().substring(3, 4));
					pu.setLetra5(pu.getNombre().substring(4, 5));
					System.out.println("Nombre palabra a adivinar a adivinar: "+pbd.getNombre());
					 System.out.println("Nombre palabra ingresada por el usuario: "+pu.getNombre());
					 System.out.println("*****************************************************");
					 String aux=	pu.getLetra1();
					// System.out.println("pu: "+ pu.getLetra1());
						//System.out.println("pbd: "+ pbd.getLetra1());
			;	 
						
					 

					
					 list.add(new PalabraUsuario(pu.getNombre(),pu.getLetra1(),  pu.getLetra2(), pu.getLetra3(), pu.getLetra4(), pu.getLetra5() ));
					 
					 
					 
					 	c1.setCellValueFactory(new PropertyValueFactory<PalabraUsuario,String>("Letra1"));
						c2.setCellValueFactory(new PropertyValueFactory<PalabraUsuario,String>("Letra2"));
						c3.setCellValueFactory(new PropertyValueFactory<PalabraUsuario,String>("Letra3"));
						c4.setCellValueFactory(new PropertyValueFactory<PalabraUsuario,String>("Letra4"));
						c5.setCellValueFactory(new PropertyValueFactory<PalabraUsuario,String>("Letra5"));
						tb.setItems(list);
						
						
					if(list.size()>=5) {
						txt.setVisible(false);
					}
					if (pbd.getLetra1().equals(pu.getLetra1())  ) {
						

					}
					if (pbd.getLetra2().equals(pu.getLetra2())  ) {
						

					}
					if (pbd.getLetra3().equals(pu.getLetra3())  ) {
					

					}
					if (pbd.getLetra4().equals(pu.getLetra4())  ) {
						

					}
					if (pbd.getLetra5().equals(pu.getLetra5())  ) {
					

					}
				
					 
					 
					 txt.setText("");
					
					
					 
				}
				else {
					txt.setText("");
					pu.setNombre("");
				}
				
			}
			else {
				txt.setText("");
				pu.setNombre("");
				
			}
			
			
			}
		else {
			txt.setText("");
			pu.setNombre("");
		}
		
		
	}
	// Event Listener on Button[#btn1].onAction
	
	 

	@FXML
	public void jugar(ActionEvent event) throws SQLException {

		String palabraBd =palDao.getPalabra().getNombre();
		pbd.setNombre(palabraBd);
		pbd.setLetra1(palabraBd.substring(0, 1));
		pbd.setLetra2(palabraBd.substring(1, 2));
		pbd.setLetra3(palabraBd.substring(2, 3));
		pbd.setLetra4(palabraBd.substring(3, 4));
		pbd.setLetra5(palabraBd.substring(4, 5));
		
		
		/*System.out.println("1: "+ pbd.getLetra1());
		System.out.println("2: "+ pbd.getLetra2());
		System.out.println("3: "+ pbd.getLetra3());
		System.out.println("4: "+ pbd.getLetra4());
		System.out.println("5: "+ pbd.getLetra5());
		//pbd.setLetra1("");*/
	
		txt.setVisible(true);
		list.clear();
	
	}
	
	
	
	
	
	
	// Event Listener on Button[#btn2].onAction
	@FXML
	public void ayudar(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "REGLAS DE JUEGO!!"+"\n "+
				"  - Adivine la palabra oculta en un máximo de cinco intentos."+"\n "+
						"  - Cada intento debe ser una palabra de 5 letras."+"\n "+
				"  - Las palabras ingresadas no deben tener caracteres especiales."+"\n "+
						"  - Si la letra aparece en verde, es porque ha acertado y está en la palabra, y también está en la casilla correcta de la palabra."
				+"\n "+"  - Si la letra aparece en amarillo, es porque está en la palabra, pero no está en la casilla correcta."+"\n "
						+"  - Si la letra aparece sin resaltar es porque no ha acertado, y no está en la palabra que tienes que adivinar.");
	}






	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
	}
	
}
