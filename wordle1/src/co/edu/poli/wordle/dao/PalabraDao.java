package co.edu.poli.wordle.dao;

import java.sql.SQLException;


import co.edu.poli.wordle.model.Palabra;

public interface PalabraDao {

	public Palabra getPalabra() 
			throws SQLException;
	
	public boolean getPalabra2(String palabra) 
			throws SQLException;
	
	
}
