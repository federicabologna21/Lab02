package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {
	
	String parolaAliena;
	LinkedList<String> traduzioni = new LinkedList<>();
	
	public WordEnhanced(String parolaAliena) {
		super();
		this.parolaAliena = parolaAliena;
	}

	@Override
	public String toString() {
		String s= "";
			for (String ss: this.traduzioni) {
				s = s+ss.toString()+"\n";
			}
		return s;
	}

	
}
