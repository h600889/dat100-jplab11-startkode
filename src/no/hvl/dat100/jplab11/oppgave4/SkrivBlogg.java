package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	/**
	 * skriver bloggen til en fil
	 * @param samling	bloggen man ønsker å skrive til en fil
	 * @param mappe		mappen filen ligger i
	 * @param filnavn	navnet på filen
	 * @return true hvis filen ble skrevet, false hvis noe gikk gærent.
	 */
	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
			PrintWriter writeFile = new PrintWriter(new File(mappe + "/" + filnavn));
			writeFile.println(samling.toString()); //bruker toString metoden i Blogg
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
