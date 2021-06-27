package it.polito.tdp.crimes.model;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.crimes.db.EventsDao;
import it.polito.tdp.crimes.model.Evento.EventType;

public class Simulatore {
	
	// Input utente
	private int N;
	private Integer giorno; 
	private Integer mese;
	private Integer anno;
	
	// stato del mondo
	private Graph<Integer, DefaultWeightedEdge> grafo;
	private Map<Integer, Integer> agenti; // distretto, numero di agenti
	
	// coda degli eventi
	private PriorityQueue<Evento> queue;
	
	// output
	private int malGestiti;
	
	public void init(int N, Integer giorno, Integer mese, Year anno, Graph<Integer, DefaultWeightedEdge> grafo) {
		this.N = N;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno.getValue();
		this.grafo = grafo;
		
		this.agenti = new HashMap<>();
		for(Integer i: this.grafo.vertexSet()) {
			agenti.put(i, 0);
		}
		
		// devo scegliere dove si trova la centrale e impostare il numero di agenti pari a N in quel distretto
		EventsDao dao = new EventsDao();
		
		// aggiungo tutti gli eventi(crimini)
		for(Event e: dao.getEventiInData(giorno, mese, anno)) {
			queue.add(new Evento(EventType.CRIMINE, e.getReported_date(), e));
		}
		
		
	}
	
	public void run() {
		Evento e;
		while((e = queue.poll())!= null) {
			switch(e.getEvento()) {
			case CRIMINE:
				
				
				
			case ARRIVA_AGENTE:
				
			case MAL_GESTITO:
			
			}
		}
	}
	
}
