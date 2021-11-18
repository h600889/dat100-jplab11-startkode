package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {

	private final int id;
	private String bruker;
	private String dato;
	private int likes;

	/**
	 * Konstruktør uten likes
	 * @param id		unik ID til innlegget
	 * @param bruker	navnet til brukeren som lagde innlegget
	 * @param dato		datoen innlegget ble lagt ut
	 */
	public Innlegg(int id, String bruker, String dato) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = 0;
	}

	/**
	 * Konstruktør med likes
	 * @param id		unik ID til innlegget
	 * @param bruker	navnet til brukeren som lagde innlegget
	 * @param dato		datoen innlegget ble lagt ut
	 * @param likes		hvor mange likes innlegget har
	 */
	public Innlegg(int id, String bruker, String dato, int likes) {
		this(id,bruker,dato); //bruken den andre konstruktøren som en del av denne konstruktøren
		this.likes = likes;
	}


	//get- og setmetoder
	public String getBruker() { return bruker; }
	public void setBruker(String bruker) { this.bruker = bruker; }
	public String getDato() { return dato; }
	public void setDato(String dato) { this.dato = dato; }
	public int getId() { return id; }
	public int getLikes() { return likes; }

	/**
	 * legger til en like til innlegget.
	 */
	public void doLike () { likes++; }

	/**
	 * sjekker om innlegget er likt et annet innlegg
	 * @param innlegg	innlegget som skal sammenlignes
	 * @return	true hvis innleggene har lik ID, false ellers.
	 */
	public boolean erLik(Innlegg innlegg) {
		if (innlegg == null) return false;
		return (innlegg.getId() == this.id);
	}

	/**
	 * konverterer innlegget til en String
	 * @return	innlegget som en String
	 */
	@Override
	public String toString() {
		return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6

	/**
	 * konverterer innlegget til HTML kode
	 * @return innlegget som HTML kode
	 */
	public String toHTML() {
		return "<h2>" + bruker + "@" + dato + " [" + likes + "]<h2>\n";
	}
}
