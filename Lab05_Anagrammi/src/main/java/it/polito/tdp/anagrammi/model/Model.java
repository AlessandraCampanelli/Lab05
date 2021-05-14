package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammiDAO;

public class Model {



	AnagrammiDAO  DAO=new AnagrammiDAO();
	

	
public Set<String>  sottoProblemaAnagrammi(String parola){
	Set<String>anagrammi= new HashSet<String>();
	
 //CONTIENE LE SOLUZIONI 
	 //ESSEENDO UNA PAROLA UNA SOLUZIONE E' FORMATA DA UNA STRINGA
	cerca("",parola,0,anagrammi);
	return anagrammi;
}
private void cerca(String parziale,String lettere,int livello,Set<String>anagrammi) {
	//CASI TERMINALI 
	/*if(livello==lettere.length()) // QUANDO HO FINITE LE LETTERE DI UNA PERMUTAZIONE POSSO AGGIUNGERE LA PAROLA ALL'ELENCO 
		return;*/
	if(lettere.length()==0){ //SE LE PAROLE SONO FINITE 
		anagrammi.add(parziale);
		//return ; SE METTI IL RETUN TI BLOCCA IL PROGRAMMA
		}else {
	//GENEREO IL SOTTO PROBLEMA
	//DEVO AGGIUNGERE UNA LETTERA PER VOLTA
	for(int pos=0;pos<lettere.length();pos++) {
		char letteraEstratta= lettere.charAt(pos);
	String	nuovaparziale=parziale+letteraEstratta; //AGGIUNGO LA LETTERA ALLA SOLUZIONE PARZIALE 
		//FACCIO DI NUOVO LA RICORSIONE 
		//MA DEVO TOGLIERE LA LETTERA UTILIZZATA
		String nuoveLettere= lettere.substring(0, pos)+lettere.substring(pos+1); 
		cerca(nuovaparziale,nuoveLettere,livello+1,anagrammi);
	}
	}
}

public boolean isCorrect(String parola) {
	//DA COLLEGARE AL DATABASE 
	return this.DAO.isCorrect(parola);
}
}
