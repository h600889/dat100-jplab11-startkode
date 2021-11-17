package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() { return nesteledig; }
	
	public Innlegg[] getSamling() { return innleggtabell; }
	
	public int finnInnlegg(Innlegg innlegg) {
		if (innlegg == null) { return -1; }
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i] != null) {
				if (innleggtabell[i].erLik(innlegg)) {
					return i;
				}
			}

		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) > -1);
	}

	public boolean ledigPlass() {
		return (!(nesteledig >= innleggtabell.length));
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg)) { return false; }
		innleggtabell[nesteledig++] = innlegg;
		return true;
	}
	
	public String toString() {
		String str = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			str += innleggtabell[i].toString();
		}
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] innleggtabellNy = new Innlegg[innleggtabell.length * 2];
		System.arraycopy(innleggtabell,0,innleggtabellNy,0,innleggtabell.length);
		innleggtabell = innleggtabellNy;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) { return false; }
		if (!ledigPlass()) {
			utvid();
		}
		return leggTil(innlegg);
		
	}
	
	public boolean slett(Innlegg innlegg) {
		if (!finnes(innlegg)) { return false; }
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				innleggtabell[i] = innleggtabell[nesteledig-1];
				nesteledig--;
				return true;
			}
		}
		return false;
	}
	
	public int[] search(String keyword) {
		int[] searchResults = new int[nesteledig];
		int nesteledigInt = 0;
		for (Innlegg i : innleggtabell) {
			if (i.toString().contains(keyword)) {
				searchResults[nesteledigInt++] = i.getId();
			}
		}
		int[] realSearchResults = new int[nesteledigInt];
		System.arraycopy(searchResults,0,realSearchResults,0,nesteledigInt-1);
		return realSearchResults;

	}
}