package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	/**
	 * les blogg fra en fil
	 * @param mappe		mappen filen ligger i
	 * @param filnavn	navnet til filen.
	 * @return	bloggen fra filen.
	 */
	public static Blogg les(String mappe, String filnavn) {
		Blogg blogg = null;
		try {
			Scanner fileReader = new Scanner(new File(mappe + "/" + filnavn));
			blogg = new Blogg(Integer.parseInt(fileReader.nextLine())); //Leser hvor mange innlegg det er fra første linjen, og bruker det for å bestemme lengden på blogg

			for (int i = 0; i < blogg.getSamling().length; i++) {
				String tekstEllerBilde = fileReader.nextLine(); //Leser første linje av innlegget for å finne ut av om det er tekstinnlegg eller bildeinnlegg.
				int id = Integer.parseInt(fileReader.nextLine()); // leser ID
				String brukernavn = fileReader.nextLine(); // leser bruker
				String dato = fileReader.nextLine(); // leser dato
				int likes = Integer.parseInt(fileReader.nextLine()); // leser likes
				String tekst = fileReader.nextLine(); // leser tekst
				if (tekstEllerBilde.equals(TEKST)) {
					blogg.leggTil(new Tekst(id,brukernavn,dato,likes,tekst)); //legger til et tekstinnlegg hvis det er et tekstinnlegg
				} else {
					String url = fileReader.nextLine(); // leser inn URL hvis det er et bildeinnlegg
					blogg.leggTil(new Bilde(id,brukernavn,dato,likes,tekst,url)); // legger til et bildeinnlegg.
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return blogg;

	}
}
