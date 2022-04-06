package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO anagrammaDAO = new AnagrammaDAO();

	
	public Set<String> calcolaAnagrammi(String parola){
		
		Set<String> anagrammi = new HashSet<String>();
		
		String parziale ="";
		calcola(parziale, parola, 0, anagrammi);
		return anagrammi;
		
	}


	private void calcola(String parziale, String parola, int livello, Set<String> anagrammi) {

		if (livello == parola.length()) {
			anagrammi.add(parziale);
			return;
		}
		
		
		for (int i=0; i<parola.length(); i++) {
			
			if (charCounter(parziale, parola.charAt(i))<charCounter(parola, parola.charAt(i))) {
				parziale+= parola.charAt(i);
				calcola(parziale, parola, livello+1, anagrammi);
				parziale= parziale.substring(0, parziale.length()-1);
			}
			
		}
		
	}
	
	
	public boolean isCorrect(String anagramma) {
		return anagrammaDAO.isCorrect(anagramma);
	}


private static int charCounter(String string, char c) {
	int count=0;
	
	for (int i=0; i<string.length(); i++) {
		if (string.charAt(i)== c) {
			count ++; 
		}
	}
	return count;
}
}
