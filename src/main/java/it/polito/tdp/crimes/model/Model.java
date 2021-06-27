package it.polito.tdp.crimes.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.*;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	private EventsDao dao;
	private Graph<Integer, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new EventsDao();
		
	}
	
	public void creaGrafo(Year anno) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		// aggiungo vertici
		Graphs.addAllVertices(this.grafo, this.dao.getVertici());
		
		// aggiungo archi
		for(Integer i1: this.grafo.vertexSet()) {
			for(Integer i2: this.grafo.vertexSet()) {
				
				if(!i1.equals(i2)) {
					if(this.grafo.getEdge(i1, i2) == null) {
						Double latMediaV1 = dao.getMediaLat(anno, i1);
						Double latMediaV2 = dao.getMediaLat(anno, i2);
						
						Double longMediaV1 = dao.getMediaLong(anno, i1);
						Double longMediaV2 = dao.getMediaLong(anno, i2);
						
						Double distanzaMedia = LatLngTool.distance(new LatLng(latMediaV1,longMediaV1), new LatLng(latMediaV2, longMediaV2), LengthUnit.KILOMETER);
						Graphs.addEdge(this.grafo, i1, i2, distanzaMedia);
					}
				}
			}
		}
	}
	
	public List<Adiacente> getAdiacentiA(Integer distretto) {
		List<Adiacente> result = new ArrayList<>();
		for(DefaultWeightedEdge edge: this.grafo.edgesOf(distretto)) {
			result.add(new Adiacente(Graphs.getOppositeVertex(this.grafo, edge, distretto), this.grafo.getEdgeWeight(edge)));
		}
		return result;
	}
	
	public List<Year> getAnni(){
		return this.dao.getAnni();
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Integer> getMesi(){
		return dao.getMesi();
	}
	
	public List<Integer> getGiorni(){
		return dao.getGiorni();
	}
}
