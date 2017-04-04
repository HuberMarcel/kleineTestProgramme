package de.marcelhuber.kleinetestprogramme;

/**
 *
 * @author Marcel Huber
 */
public class ReihenfolgeTest01 {

    static private String s = " - ";

    public static void main(String[] args) {
        System.out.println("pre ");
//        s += " pre ";
        System.out.print(s);
        go();
        new ReihenfolgeTest01().go();
        System.out.println(s);
    }

    static {
        s += " s2";
    }

    static void go() {
        s += s;
    }
}

//Reihenfolge:
//Klasse wird geladen 
//--> statische Variable s --> " - "
//--> statischer Init-Block: s --> " -  s2"
//
//--> main Methode: Ausgabe von "pre " (ohne "") auf Konsole mit anschließendem Zeilenumbruch
//--> Ausgabe von " -  s2" (aktueller Inhalt von s) OHNE ZEILENUMBRUCH
//
//--> go()-Methode: s --> " -  s2 -  s2"
//--> new ReihenfolgeTest().go() wird vom Compiler zu ReihenfolgeTest.go()
//    gemacht, da die go()-Methode statisch ist (und es somit keine Instanz-go()
//    -Methode geben darf), also wird wieder die statische go()-Methode aufgerufen:
//    s --> " -  s2 -  s2 -  s2 -  s2"
//
//--> Ausgabe von " -  s2 -  s2 -  s2 -  s2" auf Konsole

/* Fazit: Folgende Konsolenausgabe
 pre
 -  s2 -  s2 -  s2 -  s2 -  s2// mit einem Leerzeichen vor dem ersten -
 */
// Hinweis: Schreibt man in Zeile 14 println anstatt print:
/* Folgende Konsolenausgabe
 pre
 -  s2// mit einem Leerzeichen vor dem -
 -  s2 -  s2 -  s2 -  s2// mit einem Leerzeichen vor dem ersten -
 */
