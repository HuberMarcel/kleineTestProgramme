package de.marcelhuber.pruefungsvorbereitung.oca;

import java.util.*;
//import javax.annotation.*;

/**
 *
 * @author Marcel Huber
 */
public class VokabularEnglischDeutschAnzeigen {

    List<String> fachwoerterBuchEnDe = new ArrayList<>();
    List<String> fachwoerterBuchDeEn = new ArrayList<>();

    public static void main(String[] args) {
        new VokabularEnglischDeutschAnzeigen().go();
    }

    private void go() {
        ResourceBundle bundle = ResourceBundle.getBundle("de.marcelhuber.pruefungsvorbereitung.oca.VokabularEnglischDeutsch");
        VokabularEnglischDeutsch_de woerterBuch = new VokabularEnglischDeutsch_de();
//        System.out.println(woerterBuch.keySet());
        Map<String, String> sortedMap = new TreeMap<>(new VokabularEnglischDeutschComparator());
        for (String wort : woerterBuch.keySet()) {
            fachwoerterBuchEnDe.add(wort);
            fachwoerterBuchDeEn.add(bundle.getString(wort));
        }
        Collections.sort(fachwoerterBuchEnDe, new VokabularEnglischDeutschComparator());
        Collections.sort(fachwoerterBuchDeEn, new VokabularEnglischDeutschComparator());

        // Comparator sortiert NICHT nach Groß- und Kleinschreibung 
        // System.out.println(fachwoerterBuch);
        long maxStringLengthEnDe = 0;
        long maxStringLengthDeEn = 0;
        for (String wort : fachwoerterBuchEnDe) {
            if (wort.length() > maxStringLengthEnDe) {
                maxStringLengthEnDe = wort.length();
            }
            if (bundle.getString(wort).length() > maxStringLengthDeEn) {
                maxStringLengthDeEn = bundle.getString(wort).length();
            }
        }
        maxStringLengthEnDe = maxStringLengthEnDe + 1;
        System.out.println("Ausgabe des Wörterbuchs (EN - DE):".toUpperCase());
        for (String wort : fachwoerterBuchEnDe) {
            System.out.printf("%" + maxStringLengthEnDe + "s - %s%n", wort, bundle.getString(wort));
        }
        System.out.println("");

        /*    Schlechte Implementierung des Wöterbuchs in umgekehrter Reihenfolge
         System.out.println("Ausgabe des Wörterbuchs (DE - EN)".toUpperCase() + " [momentan schlecht "
         + "implementiert]:");
         //        Enumeration<String> keys = bundle.getKeys();
         for (String wort : fachwoerterBuchDeEn) {
         for (String wortEn : fachwoerterBuchEnDe) {
         if (wort.toLowerCase().equals(bundle.getString(wortEn).toLowerCase())) {
         System.out.printf("%" + maxStringLengthDeEn + "s - %s%n", wort, wortEn);
         break;
         }
         }
         }
         */
        // Elegantere Loesung
        // Sortierung nach values
        System.out.println("Ausgabe des Wörterbuchs (DE - EN):".toUpperCase());
        for (String key : bundle.keySet()) {
            sortedMap.put(bundle.getString(key), key);
        }
        for (String value : sortedMap.keySet()) {
            System.out.printf("%" + maxStringLengthDeEn + "s - %s%n", value, sortedMap.get(value));
        }
        //
    }
}
