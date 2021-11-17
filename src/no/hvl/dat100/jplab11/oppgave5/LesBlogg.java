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

	public static Blogg les(String mappe, String filnavn) {
		Blogg blogg = null;
		try {
			Scanner fileReader = new Scanner(new File(mappe + "/" + filnavn));
			blogg = new Blogg(Integer.parseInt(fileReader.nextLine()));
			for (int i = 0; i < blogg.getSamling().length; i++) {
				String tekstEllerBilde = fileReader.nextLine();
				int id = Integer.parseInt(fileReader.nextLine());
				String brukernavn = fileReader.nextLine();
				String dato = fileReader.nextLine();
				int likes = Integer.parseInt(fileReader.nextLine());
				String tekst = fileReader.nextLine();
				if (tekstEllerBilde.equals(TEKST)) {
					blogg.leggTil(new Tekst(id,brukernavn,dato,likes,tekst));
				} else {
					String url = fileReader.nextLine();
					blogg.leggTil(new Bilde(id,brukernavn,dato,likes,tekst,url));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return blogg;

	}
}
