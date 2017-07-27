package de.marcelhuber.pruefungsvorbereitung.ocp.chapter10;

/**
 *
 * @author Marcel Huber
 */
public class Singleton02Demo {

    public static void main(String[] args) {
        new Singleton02Demo().go();
    }

    private void go() {
        Singleton02 singleton02Objekt01 = Singleton02.getInstance();
        Singleton02 singleton02Objekt02 = Singleton02.getInstance();
        System.out.print("Vergleich von singleton02Objekt01 und "
                + "singleton02Objekt02 liefert: ");
        System.out.println(singleton02Objekt01 == singleton02Objekt02);
    }
}
