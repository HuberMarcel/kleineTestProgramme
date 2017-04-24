package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
class Overwriting { // es darf nur eine public-Klasse in einer Datei geben

    static void ichBinEineStatischeMethode() {
        System.out.println("Ich bin eine statische Methode/Elternklasse!");
    }

    static void ichBinStatisch() {
        System.out.println("Ich bin statisch/Elternklasse!");
    }

    int ichBinNichtStatisch() {
        System.out.println("Ich bin nicht statisch/Elternklasse!");
        return 0;
    }

    //Long ichBinNichtStatischLong(){
    Number ichBinNichtStatischLong() {
        System.out.println("Elternklasse!");
        return 10L;
    }
}
