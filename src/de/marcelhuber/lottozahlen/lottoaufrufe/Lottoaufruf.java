package de.marcelhuber.lottozahlen.lottoaufrufe;

import de.marcelhuber.lottozahlen.*;
import de.marcelhuber.systemtools.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class Lottoaufruf {

    private int[] letzteZiehung = {10, 11, 14, 24, 26, 48}; // Spiel vom 12.04.17
//    private int[] letzteZiehung = {12, 18, 21, 27, 30, 36}; // Spiel vom 15.04.17

    public static void main(String[] args) {
        int[][] ziehungen;
        Lotto6Aus49 lottoSpiele = new Lotto6Aus49(); // die Initialisierung des Objekts läßt so genau ein Lottospiel zu
        new Lottoaufruf().treffeLetzteZiehung(lottoSpiele);
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

    public void treffeLetzteZiehung(Lotto6Aus49 lottoSpiele) {
        boolean letzteZiehungGetroffen = false;
        int counter = 0;
        do {
            lottoSpiele.starteZiehungen(10);
//            letzteZiehung = lottoSpiele.getLottoZiehungen()[7];  // Zeile 1/2 zum Testen, ob der Treffer funktioniert
            for (int i = 0; i < 10; i++) {
                if (compareLottoSpiele(lottoSpiele.getLottoZiehungen()[i], letzteZiehung)) {
                    letzteZiehungGetroffen = true;
//                    System.out.println("i :" + i);  // Zeile 2/2 zum Testen, ob der Treffer funktioniert
                    PressEnter.toContinue();
                };
            }
            counter += 10;
            System.out.println("\n\ncounter: " + counter + "\n\n");
        } while (!letzteZiehungGetroffen);
    }

    private boolean compareLottoSpiele(int[] lottoSpiel1, int[] lottoSpiel2) {
        for (int k = 0; k < lottoSpiel1.length; k++) {
            // beachte, dass die Spiele sortiert sind
            if (lottoSpiel1[k] != lottoSpiel2[k]) {
                return false;
            }
        }
        return true;
    }
}
