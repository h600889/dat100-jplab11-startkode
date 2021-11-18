package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}

	private static String HTMLPREFIX =
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";

	private static String HTMLPOSTFIX =
			"\t</body>\n</html>";

	/**
	 * konverter blogg til HTML-kode
	 * @return Blogg som HTML-kode
	 */
	@Override
	public String toString() {
		String contentsStr = "";
		for (Innlegg i : super.getSamling()) {
			if (i != null) {
				contentsStr += i.toHTML() + "<hr>";
			}
		}
		return HTMLPREFIX + contentsStr + HTMLPOSTFIX;

	}
}
