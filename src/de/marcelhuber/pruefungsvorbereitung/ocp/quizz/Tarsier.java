package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class Tarsier {

    static int counter = 0;
    static String s = "-";

    public static void main(String[] args) {
        System.out.println("s zu Beginn der Main-Methode: " + s);
        new Tarsier().go();
        System.out.println("s am Ende der Main-Methode:   " + s);
    }

    private void go() {
        s += "s";
    }

    static {
        new Tarsier().go();
    }

    {
        System.out.println("s vor dem " + ++counter + ". Tarsier-Objekt:  " + s);
        go();
        System.out.println("s nach dem " + counter + ". Tarsier-Objekt: " + s);
    }

//    static void go() {
//        s += "s";
//    }
}
