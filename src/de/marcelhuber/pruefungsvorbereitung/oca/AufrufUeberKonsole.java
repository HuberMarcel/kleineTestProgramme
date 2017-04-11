package de.marcelhuber.pruefungsvorbereitung.oca;
// Compilieren:
// in U:\JAVA_OCPJP\JavaTESTs\kleineTestProgramme\src\de
// marcelhuber\pruefungsvorbereitung\oca\ wechseln, dann mit
// javac -d bis in den classes ordner (bspw. build/classes) gehen
//
// javac -d ../../../../../build/classes AufrufUeberKonsole.java

// Ausführen:
// --> in entsprechenden Klassenordner wechseln (Hinweis: package-Struktur
// wird ab dort wieder generiert)
// U:\JAVA_OCPJP\JavaTESTs\kleineTestProgramme\build\classes\
// wenn dann in U:\JAVA_OCPJP\JavaTESTs\kleineTestProgramme\build\classes\
// de\marcelhuber\kleinetestprogramme die entsprechend erzeugte Java-Datei
// mit der Endung .class liegt (hier AufrufUeberKonsole.class)
// 
// java de.marcelhuber.pruefungsvorbereitung.oca.AufrufUeberKonsole 
//
// ausführen oder, analog mit -cp (classpath) in den entsprechenden Klassenordner
// gehen und von dort aus den (vollqualifizierten) Klassenname beim Aufruf 
// erwähnen, unabhängig davon, wo man sich gerade befindet. Oben bspw.:
// Nehmen wir an, wir sind in dem Ordner marcelhuber, dann:
//
// java -classpath ../../../build/classes/ de.marcelhuber.pruefungsvorbereitung.oca.AufrufUeberKonsole
//
//
// Hinweis: Ordner-Struktur für Quellcode
// kleineTestProgramme/src/de/marcelhuber/pruefungsvorbereitung/oca/ ... .java-Dateien
//
// Hinweis: Ordner-Struktur für Klasse
// kleineTestProgramme/build/classes/de/marcelhuber/pruefungsvorbereitung/oca/ ... .class-Dateien
/**
 *
 * @author Marcel Huber
 */
public class AufrufUeberKonsole {

    public static void main(String[] args) {
        System.out.println("In den Kommentaren steht, wie der Aufruf "
                + "über die Konsole vonstatten geht!");
    }
}
