package de.marcelhuber.kleinetestprogramme;

/**
 *
 * @author Marcel Huber
 */
public class ReihenfolgeTest02 {

    static private String s = " - ";

    public static void main(String[] args) {
        System.out.println("pre ");
//        s += " pre ";
        System.out.print(s);
        go();
        new ReihenfolgeTest02().go();
        System.out.println(s);
    }

    static {
        s += " s2";
//        System.out.println("Hallo"+s) ;
    }

    static private void go() {
        s += "s";
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
//--> go()-Methode: s --> " -  s2s"
//--> new ReihenfolgeTest().go() wird vom Compiler zu ReihenfolgeTest.go()
//    gemacht, da die go()-Methode statisch ist (und es somit keine Instanz-go()
//    -Methode geben darf), also wird wieder die statische go()-Methode aufgerufen:
//    s --> " -  s2ss"
//
//--> Ausgabe von " -  s2ss" auf Konsole

/* Fazit: Folgende Konsolenausgabe
 pre
 -  s2 -  s2ss// mit einem Leerzeichen vor dem ersten -
 */
// Hinweis: Schreibt man in Zeile 14 println anstatt print:
/* Folgende Konsolenausgabe
 pre
 -  s2// mit einem Leerzeichen vor dem -
 -  s2ss// mit einem Leerzeichen vor dem ersten -
 */
