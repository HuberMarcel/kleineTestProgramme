package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
//
// Über den Konsolenaufruf geht das hier so nicht, da die Klasse, die public
// ist, die einzige ist, die eine Main-Methode haben kann und muss
//Compilieren:
//U:\JAVA_OCPJP\JavaTESTs\kleineTestProgramme\src\de\marcelhuber\pruefungsvorbereitung\oca>javac -d ../../../../../build/classes Konstruktoren.java
//
//Aufrufen:
//U:\JAVA_OCPJP\JavaTESTs\kleineTestProgramme\src\de\marcelhuber\pruefungsvorbereitung\oca>java -cp ../../../../../build/classes de.marcelhuber.pruefungsvorbereitung.oca.Konstruktoren
public class Konstruktoren {

    static String s = "Statischer Konstruktor";
    String o = "Objekt-String";

    // Konstruktoren haben im Gegensatz zu Methoden keinen Rückgabetyp
    // (auch void zählt als Rückgabe-Typ)
    // können aber alle Access-Level durchlaufen
    private Konstruktoren() {
        o = "Ich bin das wirklich: " + o;
    }

    Konstruktoren(String s) {
        this.s = this.s + " " + s;
// Methoden innerhalb eines Konstruktors sind ziemlich sinnlos - was sollten sie
// machen bzw. wie sollte man sie ansprechen?
//    public String Hahahaha() {
//        return "Ist Nur Spaß";
//    }
    }

//    public static void main(String[] args) {
//        System.out.println(new Konstruktoren().o);
//    }
}

class EineWeitereKlasse {

    public static void main(String[] args) {
//        Konstruktoren konstr = new Konstruktoren(); // geht nicht, da 
        // Konstruktor private
        System.out.println(new Konstruktoren("Miau").s);
    }
}
