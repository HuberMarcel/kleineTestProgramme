package de.marcelhuber.pruefungsvorbereitung.ocp.innerclasses;

// top-level-klasse

import com.sun.org.apache.xerces.internal.impl.xpath.regex.*;

public class RegulaereInnereKlasse_de {

    /*
     Innere Klassen
    
     ... sind Klassen, die innerhalb einer anderen Klasse definiert sind
     ... gibt es in vier Geschmacksrichtungen
    
     ==> 1. reguläre innere Klassen
     2. statische innere Klassen / static nested classes
     3. Methoden-Lokale innere Klassen
     4. anonyme innere Klasse
     (lambda-expression)
    
     */
    public static void main(String[] args) {
        new RegulaereInnereKlasse_de().go();
    }

    private void go() {

        Outer outer;
        Outer.Inner inner01;
        Outer.Inner inner02;
        Outer.Inner inner03;

        inner01 = new Outer().new Inner();

        outer = new Outer();

        inner01 = outer.new Inner();

        inner02 = outer.new Inner().getInstance("Peter");
        inner03 = inner02;
        inner03.setName("Marcel");         // inner02 und inner 03 heißen jetzt Marcel
        new Outer().new Inner().Inner();   // das ist jetzt fies, wenn man hier auch noch die Methode Inner aufruft
        System.out.println("");
        System.out.println("Name von inner01: " + inner01.getName());
        System.out.println("Name von inner02: " + inner02.getName());
        System.out.println("Name von inner03: " + inner03.getName());
        System.out.println("");

        inner01.setName("Bernhard");
        inner03 = new Outer().new Inner().getInstance("Bauer");
        inner03.setName("Hauer".toUpperCase());
        System.out.println("");

        System.out.println("Name von inner01: " + inner01.getName());
        System.out.println("Name von inner02: " + inner02.getName());
        System.out.println("Name von inner03: " + inner03.getName());
        System.out.println("");
    }
}

enum Days {

    M, TU, WE, TH, FR, SA, SU
}

// 
// Regular inner classes
// 
// ... benötigen ein Objekt der umschliessenden Klasse
// top-level-classes können (default) und public access haben
class Outer {

    {
        System.out.println("(Outer) Ich erzeuge ein Objekt der äußeren Klasse - Init-Block!");
    }

    Inner inner;
    private int x = 11;

    // alle an Klassen verwendbaren non-access modifier (final, abstract, strictfp) sind möglich
    // alle access-levels (private, (default), protected, public) sind möglich
    class Inner {

        private String name;

        public Inner() {
        }

        private Inner(String name) {
            this.name = name;
            System.out.println("(Inner) Ich erzeuge ein leeres Objekt der inneren Klasse - \"String\"-Konstruktor!");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Inner getInstance(String name) {
            return new Inner("name");
        }

        public void Inner() {
            System.out.println("(Inner) Ich bin eine innere Methode, und keine innere Klasse!");
        }

    }

    public void Inner() {
        System.out.println("(Outer) Ich bin eine innere Methode, und keine innere Klasse!");
    }

}
