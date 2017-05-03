package de.marcelhuber.pruefungsvorbereitung.oca.selftestseite075;
// Hinweis: wenn Zeile A auskommentiert wird, wird sowieso die 
// Methode blastOff aus der Shuttle-Klasse verwendet:
// output: sh-bang

// wenn man A einkommentiert: blastOff aus class Rocket kann wegen
// Access-Level private schonmal nicht überschrieben werden, aber 
// auch der Aufruf aus Zeile A würde bedingen, dass diese Methode 
// eine statische ist

/**
 *
 * @author Marcel Huber
 */
class Rocket {

    private void blastOff() {
        System.out.print("bang ");
    }
}

public class Shuttle extends Rocket {

    public static void main(String[] args) {
        new Shuttle().go();
    }

    void go() {
        blastOff();
//        Rocket.blastOff(); // line A
    }

    private void blastOff() {
        System.out.print("sh-bang ");
    }
}
