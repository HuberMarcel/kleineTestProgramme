package de.marcelhuber.mathematik.zahlentheorie;

import java.util.*;

/**
 *
 * @author Marcel Huber
 * @date 20.08.2019
 */
public class KettenbruchBerechnungAusEndlicherFolge {

    private ArrayList<Long> zahlenfolge;
    private double wert;

    public static void main(String args[]) {
        ArrayList<Long> zahlenfolge = new ArrayList<>(Arrays.asList(2L, 1L, 2L));
        long geradeZahlAlsGrenze = 32;
        long letzter2erWert = zahlenfolge.get(zahlenfolge.size() - 1);
        for (long counter = letzter2erWert + 2; counter <= geradeZahlAlsGrenze; counter += 2) {
            zahlenfolge.add(1L);
            zahlenfolge.add(1L);
            zahlenfolge.add(counter);
        }
        System.out.println("Eulersche Kettenbruchfolge für e: " + zahlenfolge);
        new KettenbruchBerechnungAusEndlicherFolge().
                berechneWertAusEndlicherFolge(zahlenfolge);
    }

    public void berechneWertAusEndlicherFolge(ArrayList<Long> zahlenfolge) {
        this.zahlenfolge = new ArrayList(zahlenfolge);
        System.out.println("Ihre Zahlenfolge: " + zahlenfolge);
        if (zahlenfolge.size() == 0) {
            System.out.println("Leere Folge?!");
            return;
        }
        wert = zahlenfolge.remove(zahlenfolge.size() - 1);
        long letzterFolgenwert;
        while (zahlenfolge.size() > 0) {
            letzterFolgenwert = zahlenfolge.remove(zahlenfolge.size() - 1);
            if (wert * letzterFolgenwert == 0) {
                System.out.println("Eingabefehler bei der Folge - dort kann keine Null vorkommen");
                break;
            } else {
                wert = letzterFolgenwert + 1 / wert;
            }
        }
        System.out.println("\nDer Wert der Folge: " + wert);
    }

    public ArrayList<Long> getZahlenfolge() {
        return zahlenfolge;
    }

    public double getWert() {
        return wert;
    }
}
