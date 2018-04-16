package de.marcelhuber.mathematik.zahlentheorie;

import de.marcelhuber.mathematik.SiebDesEratosthenes;
import de.marcelhuber.systemtools.ReadInput;
import de.marcelhuber.mathematik.PrimzahlTest;
import de.marcelhuber.systemtools.PressEnter;
import java.util.Arrays;

/**
 *
 * @author: Marcel Huber; Datum: 16.04.2018
 */
public class PrimzahlenfinderAbGewisserZahl {

    private long timeSieb;
    private Long[] primzahlenArray;
    private SiebDesEratosthenes siebDesEratosthenesCalculator;

    public static void main(String[] args) {
        PrimzahlenfinderAbGewisserZahl dummyObject = new PrimzahlenfinderAbGewisserZahl();
        dummyObject.go01();
    }

    private void go01() {
        System.out.printf("Geben Sie bitte die Zahl (in sinniger Weise > 1) ein, "
                + "bis zu welcher ".toUpperCase() + "%nSie die Primzahlen [einschließlich] sehen "
                + "möchten (unsinnige Eingaben %nwerden auf 0 gesetzt!): ");
        long readLong = ReadInput.readLong();
        timeSieb = System.currentTimeMillis();
        siebDesEratosthenesCalculator = new SiebDesEratosthenes();
        primzahlenArray
                = siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(readLong);
        timeSieb = System.currentTimeMillis() - timeSieb;
        System.out.println(Arrays.toString(primzahlenArray));
        System.out.println("Wir berechnen nun auf zwei Wegen eine Primzahl, die "
                + "größer ist als " + readLong + "!");
        berechnePrimzahlGroesserAlsGegebeneZahlNachBeweisFuerUnendlichVielePrimzahlen(readLong);
        System.out.println("");
        System.out.println("");
        System.out.println("Eine andere Methode!".toUpperCase());
        berechnePrimzahlGroesserAlsGegebeneZahlMitSiebDesEratosthenes(readLong);
    }

// nach "Algebra: Meyberg/Karpfinger, 2. Auflage, Seite 65, Satz 5.8" (Beweis zur 
// Existenz unendlich vieler Primzahlen) gibt es zu dem Produkt der ersten n direkt 
// aufeinanderfolgenden Primzahlen um 1 erhöht einen Primfaktor, der nicht in diesen
// Primzahlen vorkommt. D.h. sind a_1=2, a_2=3, ... , a_n die ersten n aufeinanderfolgenden
// Primzahlen, so hat die Zahl zahl := a_1 * ... * a_n + 1 einen Teiler > a_n, der
// eine Primzahl ist
    private long berechnePrimzahlGroesserAlsGegebeneZahlNachBeweisFuerUnendlichVielePrimzahlen(long letzteZahl) {
        long returnValue = 0;
        if (siebDesEratosthenesCalculator == null) {
            siebDesEratosthenesCalculator = new SiebDesEratosthenes();
        }
        primzahlenArray
                = siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(letzteZahl);
        System.out.println("Wir multiplizieren die folgenden Primzahlen und addieren 1:");
        System.out.println(Arrays.toString(primzahlenArray));
        System.out.println("Das ergibt: ");
        long zahl = 1;
        for (Long longValue : primzahlenArray) {
            if (longValue > 43) {
                System.out.println("Vorsicht:".toUpperCase());
                System.out.println("Das Verfahren ist aufgrund des Zahlenbereichs "
                        + "für Long-Werte nur sinnvoll bei Produktbildung bis zur "
                        + "15. Primzahl mit dem Wert 47!");
                PressEnter.toContinue();
                System.out.println("");
                if (longValue > 47) {
                    System.out.println("Aktueller Primzahlwert in der Produktbildung "
                            + "ist aber: " + longValue);
                    System.out.println("Deswegen hier: " + "Abbruch!".toUpperCase());
                    PressEnter.toContinue();
                    System.out.println("");
                    return returnValue = -1;
                }
            }
            zahl *= longValue;
            // Testausgabe, ob 
            System.out.println("Aktueller Wert der Zahl: " + zahl);
            System.out.println("Grenze:                  " + Long.MAX_VALUE);
            System.out.println("Prozentualer Antiel an der oberen Grenze: "
                    + Math.round(10000.0 * zahl / Long.MAX_VALUE) / 100 + "%");
            System.out.println("");
        }
        zahl += 1;
        System.out.print("Keine der obigen Primzahlen kann ein Teiler der so "
                + "berechneten Zahl " + zahl + " sein. ");
        if (primzahlenArray.length > 0) {
            System.out.println("Ab " + primzahlenArray[primzahlenArray.length - 1]
                    + " prüfen wir alle ungeraden Zahlen bis zur Wurzel der  "
                    + zahl + ", ob sie " + zahl + " teilen!");
            System.out.println("Hinweis: Wurzel(" + zahl + ") = " + Math.sqrt(zahl));
            System.out.println("");
            System.out.println("");
            long teilerTestZahl = primzahlenArray[primzahlenArray.length - 1] + 2;
            PrimzahlTest pzTest;
            boolean teilerTestZahlIsPrim = false;
            while (teilerTestZahl <= Math.floor(Math.sqrt(zahl))) {
                if (zahl % teilerTestZahl == 0) {
                    teilerTestZahlIsPrim = true;
                    break;
                } else {
                    teilerTestZahl += 2;
                }
            }
            if (!teilerTestZahlIsPrim) {
                teilerTestZahl = zahl;
            }
            System.out.println(teilerTestZahl + " ist eine Primzahl, die größer "
                    + "als " + letzteZahl + " ist!");
            System.out.println("Test: Ist " + teilerTestZahl + " wirklich prim? ");
            pzTest = new PrimzahlTest();
            boolean isPrim
                    = pzTest.primzahlTestMitSiebErastothenes(teilerTestZahl);
            System.out.println("Ein Prüfverfahren sagt: " + isPrim);
            returnValue = teilerTestZahl;
        } else {
            returnValue = -2;
        }
        return returnValue;
    }

// wenn man eine Zahl z hat, und alle Primzahlen bis zu dieser Zahl kennt, dann
// berechne man einfach alle Primzahlen bis zu der um 1 erhöhte Quadratzahl der
// gegebenen Zahl (also bis zu z²+1) nach dem Sieb des Eratosthenes. Entweder sieht
// man dann direkt eine hinzugefügte größere Primzahl, oder die Zahl z²+1 ist selber
// die einzige größere Primzahl
    private long berechnePrimzahlGroesserAlsGegebeneZahlMitSiebDesEratosthenes(long letzteZahl) {
        long returnValue = 0;
        if (siebDesEratosthenesCalculator == null) {
            siebDesEratosthenesCalculator = new SiebDesEratosthenes();
        }
        /*
        // gibt es einen Wert, so dass zur Primzahl z die Zahl z²+1 die nächste Primzahl ist?
        // falls ja, würde der folgende Algorithmus bei der kleinsten solchen Zahl abbrechen!
        // vermutlich gibt es sowas aber nicht, deswegen auskommentiert
        long testWert = 2;
        while (siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(testWert * testWert + 1).length
                > siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(testWert).length + 1) {
            System.out.print("testWert: " + testWert);
            System.out.println(" -- "
                    + siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(testWert).length
                    + " - " + siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(testWert * testWert + 1).length);
            ++testWert;
        }
        */
        primzahlenArray
                = siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(letzteZahl * letzteZahl + 1);
        if (primzahlenArray.length > siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(letzteZahl).length) {
            System.out.println("Die erste größere Primzahl ist: "
                    + primzahlenArray[siebDesEratosthenesCalculator.calculateSiebDesEratosthenes(letzteZahl).length]);
        }
        System.out.println("Alle Primzahlen bis zu " + letzteZahl + " * " + letzteZahl + " + 1"
                + " = " + (letzteZahl * letzteZahl + 1) + ":");
        System.out.println(Arrays.toString(primzahlenArray));
        System.out.println("");
        return returnValue;
    }

}
