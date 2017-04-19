package de.marcelhuber.lottozahlen;

import de.marcelhuber.systemtools.PressEnter;
import java.util.*;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Marcel Huber
 */
public class Lotto6Aus49 {

    private int anzahlSpiele;
    private int[][] lottoZiehungen;

    public Lotto6Aus49() {
        this.anzahlSpiele = 1;
    }

    public Lotto6Aus49(int anzahlSpiele) {
        this.anzahlSpiele = anzahlSpiele;
        starteZiehungen();
    }

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
//        new Lotto6Aus49().starteZiehungen(); // so wird genau ein Lottospiel gestartet, siehe Konstruktor
        Lotto6Aus49 lottoSpiele = new Lotto6Aus49();
//        lottoSpiele.setAnzahlSpiele(30);
//        lottoSpiele.starteZiehungen();
        lottoSpiele.starteZiehungen(30);
// wegen der Überladung liefert das das gleiche wie die zwei Zeilen darüber
    }

    public void starteZiehungen() {
        lottoZiehungen = new int[anzahlSpiele][6];
//        for (int i = 0; i < lottoZiehungen.length; i++) {
        for (int i = 0; i < anzahlSpiele; i++) {
            if (i > 0 && (i + 1) % 10 == 0) {
                System.out.println("");
            }
            lottoZiehungen[i] = eineSortierteZiehung();
            System.out.print("Ziehung " + (i + 1) + ": ");
            displayIntArray(lottoZiehungen[i]);
            displayFehlerhafteZiehung(lottoZiehungen[i]);
            System.out.println("");
        }
    }

    public void starteZiehungen(int anzahlSpiele) {
        this.anzahlSpiele = anzahlSpiele;
        starteZiehungen();
    }

    void displayFehlerhafteZiehung(int[] lottoZiehung) {
        if (!kontrolle(lottoZiehung) || !kontrolleSchnell(lottoZiehung)) {
            System.out.print("   --   alle Zahlen verschieden:"
                    + kontrolle(lottoZiehung));
            System.out.print("   --   alle Zahlen verschieden:"
                    + kontrolleSchnell(lottoZiehung) + " ");
            PressEnter.toContinue();
        }

    }

    int[] eineSortierteZiehung() {
        int potentielleZahl;
        boolean isANewNumber = true;
        int[] lottoZiehung = new int[6];
//        potentielleZahl = 1 + (int) (49 * Math.random());
        Random zahlGenerator = new Random();
        potentielleZahl = 1 + zahlGenerator.nextInt(49);
        lottoZiehung[0] = potentielleZahl;
        for (int j = 1; j < lottoZiehung.length; j++) {
            do {
//                potentielleZahl = 1 + (int) (49 * Math.random());
                potentielleZahl = 1 + zahlGenerator.nextInt(49);
                isANewNumber = true;
                for (int tmp = 0; tmp < j; tmp++) {
                    if (potentielleZahl == lottoZiehung[tmp]) {
                        isANewNumber = false;
                    }
                }
            } while (!isANewNumber);
            lottoZiehung[j] = potentielleZahl;
        }
        // die Ziehung wird sortiert
        Arrays.sort(lottoZiehung);
        return lottoZiehung;
    }

    boolean kontrolleSchnell(int[] intArray) {
        // hier nutzen wir aus, dass das Feld von links nach rechts aufsteigend
        // vorsortiert ist
        boolean alleUngleich = true;
        for (int k = 0; k < intArray.length - 1; k++) {
            if (intArray[k] == intArray[k + 1]) {
                alleUngleich = false;
                break;
            }
        }
        return alleUngleich;
    }

    boolean kontrolle(int[] intArray) {
        int vergleich;
        boolean alleUngleich = true;
        outer:
        for (int k = 0; k < intArray.length; k++) {
            vergleich = intArray[k];
            if (k < intArray.length - 1) {
                for (int m = k + 1; m < intArray.length; m++) {
                    if (vergleich == intArray[m]) {
                        alleUngleich = false;
                        break outer;
                    }
                }
            }
        }
        return alleUngleich;
    }

    void displayIntArray(int[] intArray) {
        String[] strArray = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            strArray[i] = "" + intArray[i];
            if (intArray[i] < 10) {
                strArray[i] = "0" + strArray[i];
            }
        }
        System.out.print(Arrays.toString(strArray));
    }

    public void setAnzahlSpiele(int anzahlSpiele) {
        this.anzahlSpiele = anzahlSpiele;
    }

    public int getAnzahlSpiele() {
        return anzahlSpiele;
    }
    
    public int[][] getLottoZiehungen(){
        return lottoZiehungen;
    }
}
