package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	/**
	 * Konstruktør til blogg, en objektsamling av Innlegg
	 * Uten argument er lengden satt til 20.
	 */
	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	/**
	 * Konstruktør til blogg, en objektsamling av Innlegg
	 * @param lengde	lengde på samlingen
	 */
	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	//get- og setmetoder
	public int getAntall() { return nesteledig; }
	public Innlegg[] getSamling() { return innleggtabell; }

	/**
	 * leter etter et innlegg, og returnerer indeksen til innlegget
	 * @param innlegg	innlegget man ønsker å finne
	 * @return	indeksen av innlegge hvis det finnes, -1 ellers.
	 */
	public int finnInnlegg(Innlegg innlegg) {
		if (innlegg == null) return -1;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) return i;
		}
		return -1;
	}

	/**
	 * finner ut av om innlegget finnes eller ikke
	 * @param innlegg	Innlegg man vil finne ut om finnes eller ikke
	 * @return	false hvis innlegget ikke finnes, true hvis det finnes.
	 */
	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) > -1); // finnInnlegg returnerer bare -1 hvis innlegget ikke finnes,
											// så hvis resultatet her er høyere enn -1, så finnes innlegget.
	}

	/**
	 * finner ut av om det finnes mer plass i samlingen.
	 * @return false hvis det ikke er mer plass, true ellers.
	 */
	public boolean ledigPlass() {
		return (nesteledig < innleggtabell.length);
	}

	/**
	 * legger et innlegg til bloggen. Innlegget blir ikke lagt til hvis et innlegg med lik ID allerede finnes.
	 * @param innlegg 	innlegget man ønsker å legge til
	 * @return	true hvis innlegget ble lagt til, false ellers.
	 */
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg)) return false;
		innleggtabell[nesteledig++] = innlegg;
		return true;
	}

	/**
	 * Konverterer bloggen til en streng
	 * @return bloggen som en String
	 */
	public String toString() {
		String str = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			str += innleggtabell[i].toString();
		}
		return str;
	}

	// valgfrie oppgaver nedenfor

	/**
	 * Dobler antallet innlegg som bloggen kan ha.
	 */
	public void utvid() {
		Innlegg[] innleggtabellNy = new Innlegg[innleggtabell.length * 2]; // lager ny tabell med forrige tabells lengde * 2
		System.arraycopy(innleggtabell,0,innleggtabellNy,0,innleggtabell.length); // kopierer gammel tabell over til ny tabell med System.arraycopy
		innleggtabell = innleggtabellNy; // setter innleggtabell til å være den nye tabellen.
	}

	/**
	 * Legger til et nytt innlegg, og utvider hvis det trengs.
	 * @param innlegg	Innlegget man ønsker å legge til
	 * @return	false hvis innlegget ikke ble lagt til, true ellers.
	 */
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) return false;
		if (!ledigPlass()) utvid();
		return leggTil(innlegg);
		
	}

	/**
	 * slett et innlegg
	 * @param innlegg	innlegget man ønsker å slette
	 * @return	true hvis innlegget ble slettet, false ellers.
	 */
	public boolean slett(Innlegg innlegg) {
		if (!finnes(innlegg)) return false;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				innleggtabell[i] = innleggtabell[nesteledig-1]; // bytter ut innlegget som skal slettes med det siste innlegget i tabellen
				innleggtabell[nesteledig-1]=null; // setter siste innlegget i tabellen til null, slik at man ikke har det samme innlegget to ganger.
				nesteledig--; //dekrementerer nesteledig
				return true;
			}
		}
		return false; // returnerer false hvis ingenting har skjedd.
	}

	/**
	 * returnerer en liste over IDene til innlegg som matcher et søkeord.
	 * @param keyword	ordet man søker etter
	 * @return	en liste over IDer.
	 */
	public int[] search(String keyword) {
		int[] searchResults = new int[nesteledig];
		int nesteledigInt = 0;
		for (Innlegg i : innleggtabell) {
			if (i.toString().contains(keyword)) {
				searchResults[nesteledigInt++] = i.getId(); //legger IDen til tabellen for hvert innlegg som inneholder søkeordet.
			}
		}
		int[] realSearchResults = new int[nesteledigInt]; //lager en ny int[] som er riktig lengde
		System.arraycopy(searchResults,0,realSearchResults,0,nesteledigInt-1); //kopierer over
		return realSearchResults; //returnerer søkeresultatene

	}
}