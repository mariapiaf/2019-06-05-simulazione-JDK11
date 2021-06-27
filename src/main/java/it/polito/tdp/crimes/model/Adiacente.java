package it.polito.tdp.crimes.model;

public class Adiacente implements Comparable<Adiacente>{

	Integer adiacente;
	double distanza;
	
	public Adiacente(Integer adiacente, double distanza) {
		super();
		this.adiacente = adiacente;
		this.distanza = distanza;
	}

	public Integer getAdiacente() {
		return adiacente;
	}

	public void setAdiacente(Integer adiacente) {
		this.adiacente = adiacente;
	}

	public double getDistanza() {
		return distanza;
	}

	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}

	@Override
	public int compareTo(Adiacente o) {
		return (int) (this.distanza-o.distanza);
	}
	
	
	
}
