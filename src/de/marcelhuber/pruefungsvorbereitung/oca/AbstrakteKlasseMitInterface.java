package de.marcelhuber.pruefungsvorbereitung.oca;
// bei abstrakten Klassen müssen die Interface-Methoden nicht überschrieben werden

import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public abstract class AbstrakteKlasseMitInterface implements IBeispielInterfaceDefault {

    private void go() {
        ichBinAutomatischEineAbstrakteMethode();
    }

//    abstract public void main(String[] args);   // sehr ungünstig, da damit die public static void main(String[] args) {} verhindert wird
}

// hier müssen die abstrakten Methoden des Interfaces definiert werden
class KindVonAbstrakteKlasseMitInterface extends AbstrakteKlasseMitInterface {

    @Override
    public void ichBinAutomatischEineAbstrakteMethode() {
        System.out.println("ichBinAutomatischEineAbstrakteMethode() muss überschrieben werden!");
    }

    public static void main(String[] args) {
        new KindVonAbstrakteKlasseMitInterface().go();
        // Spaß mit einer anonymen inneren Klasse
        new KindVonAbstrakteKlasseMitInterface() {
            public void lachen() {
                System.out.println("Hahaha");
            }
        }.lachen();
        String[] stringArray = {"Bb", "D", "CcCCc", "A",};
        Arrays.sort(stringArray, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
//        };);   // falsche Syntax
        });
        System.out.println(Arrays.toString(stringArray));
    }

    void go() {
        ichBinAutomatischEineAbstrakteMethode();
    }
}
