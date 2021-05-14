package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AnagrammiDAO {
	
	public boolean isCorrect(String parola) {

		final String sql = "SELECT nome FROM parola WHERE nome=?";

		List<String> parole = new ArrayList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, parola);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				conn.close();
				st.close();
				return true;
			}
			
			else 
			{ conn.close();
			st.close();
			return false;
				
			}
		

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}
	}
	
	//METODO TROPPO COMPLESSO,IL PROGRAMMA SI BLOCCHEREBBE
	//VERIFICA SE LA PAROLA E' PRESENTE NEL DIZIONARIO 
	/*public  boolean isCorrect(String parola) {
		for(String e :getDizionario())
			if(parola.compareTo(e.substring(0, parola.length()+1))==0)
			return true;
		return false;
	}*/
}
