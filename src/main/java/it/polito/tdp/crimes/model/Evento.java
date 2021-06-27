package it.polito.tdp.crimes.model;

import java.time.LocalDateTime;

public class Evento implements Comparable<Evento>{

	public enum EventType{
		CRIMINE,
		ARRIVA_AGENTE,
		MAL_GESTITO
	}
	
	private EventType evento;
	private LocalDateTime data;
	private Event crimine;
	
	public Evento(EventType evento, LocalDateTime data, Event crimine) {
		super();
		this.evento = evento;
		this.data = data;
		this.crimine = crimine;
	}

	public EventType getEvento() {
		return evento;
	}

	public void setEvento(EventType evento) {
		this.evento = evento;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Event getCrimine() {
		return crimine;
	}

	public void setCrimine(Event crimine) {
		this.crimine = crimine;
	}

	@Override
	public String toString() {
		return "Evento [evento=" + evento + ", data=" + data + ", crimine=" + crimine + "]";
	}

	@Override
	public int compareTo(Evento o) {
		return this.data.compareTo(o.data);
	}
	
	
	
}
