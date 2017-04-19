package de.marcelhuber.lottozahlen.lottoaufrufe;

import de.marcelhuber.lottozahlen.*;

/**
 *
 * @author Marcel Huber
 */
public class Lottoaufruf {

    public static void main(String[] args) {
        Lotto6Aus49 lottoSpiele = new Lotto6Aus49(); // die Initialisierung des Objekts läßt so genau ein Lottospiel zu
        lottoSpiele.starteZiehungen(); // einmal Lotto spielen - Anzeige auf Konsole 
        System.out.println("\n");
        lottoSpiele.starteZiehungen(30); // so kann man jetzt auch 30 Mal Lotto spielen
//        lottoSpiel.setAnzahlSpiele(30);
//        lottoSpiel.starteZiehungen();
        // das wäre die Alternative Möglichkeit
        Lotto6Aus49 lottoSpiele44 = new Lotto6Aus49(44); // so kann man mit der Erstellung eines neuen Lotto-Objekts 44 Mal Lotto spielen
        System.out.println("\n\n");
        System.out.println("\n\nEingestellte Anzahl des ersten Lotto-Objekts:  " + lottoSpiele.getAnzahlSpiele()); // wurde auf 30 geändert
        System.out.println("Eingestellte Anzahl des zweiten Lotto-Objekts: " + lottoSpiele44.getAnzahlSpiele());
    }
}
