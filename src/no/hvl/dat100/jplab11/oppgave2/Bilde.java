package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	private String url;

	/**
	 * Konstruktør til bilde innlegg
	 * @param id        unik ID til innlegget
	 * @param bruker	navnet til brukeren som lagde innlegget
	 * @param dato		datoen innlegget ble lagt ut
	 * @param tekst		tekstinnholdet til innlegget
	 * @param url		url til bilde
	 */
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	/**
	 * Konstruktør til bilde innlegg
	 * @param id        unik ID til innlegget
	 * @param bruker	navnet til brukeren som lagde innlegget
	 * @param dato		datoen innlegget ble lagt ut
	 * @param likes		hvor mange likes innlegget har
	 * @param tekst		tekstinnholdet til innlegget
	 * @param url		url til bilde
	 */
	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id,bruker,dato,likes,tekst);
		this.url = url;
	}

	//get- og setmetoder
	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }

	/**
	 * konverterer et bilde-innlegg til en streng
	 * @return innlegget som en String
	 */
	@Override
	public String toString() {
		return "BILDE\n" + super.toString().replaceFirst("TEKST\n", "") + url + "\n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6

	/**
	 * konverterer bilde-innlegget til HTML-kode
	 * @return innlegget som HTML-kode
	 */
	public String toHTML() {
		return super.toHTML() + "<iframe src=\"" + url + "\" height=600 width=800></iframe>";
	}
}
