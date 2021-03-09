package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.LinkedList;
import java.util.List;

public class Parole {
		List<String> listaParole;
		
	public Parole() {
		//listaParole = new LinkedList<>();
		listaParole = new ArrayList<>();
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear();
	}
	
	public void cancella(String p) {
		listaParole.remove(p);
	}

}
