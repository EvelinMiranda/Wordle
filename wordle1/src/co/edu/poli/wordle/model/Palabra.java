package co.edu.poli.wordle.model;

import javax.swing.JOptionPane;

public class Palabra {
	private String nombre;
	private String letra1;
	private String letra2;
	private String letra3;
	private String letra4;
	private String letra5;
	
	
	public Palabra() {
		
	}


	public Palabra(String nombre, String letra1, String letra2, String letra3, String letra4, String letra5) {
		this.nombre = nombre;
		this.letra1 = letra1;
		this.letra2 = letra2;
		this.letra3 = letra3;
		this.letra4 = letra4;
		this.letra5 = letra5;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLetra1() {
		return letra1;
	}


	public void setLetra1(String letra1) {
		this.letra1 = letra1;
	}


	public String getLetra2() {
		return letra2;
	}


	public void setLetra2(String letra2) {
		this.letra2 = letra2;
	}


	public String getLetra3() {
		return letra3;
	}


	public void setLetra3(String letra3) {
		this.letra3 = letra3;
	}


	public String getLetra4() {
		return letra4;
	}


	public void setLetra4(String letra4) {
		this.letra4 = letra4;
	}


	public String getLetra5() {
		return letra5;
	}


	public void setLetra5(String letra5) {
		this.letra5 = letra5;
	}
	
	
	
	


	

	
	
	

}
