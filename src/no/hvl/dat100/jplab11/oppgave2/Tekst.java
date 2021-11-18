package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Tekst extends Innlegg {

	private String tekst;

	/**
	 * Konstruktør til tekst innlegg
	 * @param id        unik ID til innlegget
	 * @param bruker	navnet til brukeren som lagde innlegget
	 * @param dato		datoen innlegget ble lagt ut
	 * @param tekst		tekstinnholdet til innlegget
	 */
	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato);
		this.tekst = tekst;
	}

	/**
	 * Konstruktør til tekst innlegg
	 * @param id        unik ID til innlegget
	 * @param bruker	navnet til brukeren som lagde innlegget
	 * @param dato		datoen innlegget ble lagt ut
	 * @param likes		hvor mange likes innlegget har
	 * @param tekst		tekstinnholdet til innlegget
	 */
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst = tekst;
	}

	//get- og setmetoder
	public String getTekst() { return tekst; }
	public void setTekst(String tekst) { this.tekst = tekst; }

	/**
	 * Konverterer innlegget til en String
	 * @return innlegget som en streng
	 */
	@Override
	public String toString() {
		return "TEKST\n" + super.toString() + tekst + "\n";

	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6

	/**
	 * Konverterer innlegget til HTML-kode
	 * @return innlegget som HTML-kode
	 */
	public String toHTML() {
		return super.toHTML() + "<p>" + tekst + "<p>\n";
	}
}
