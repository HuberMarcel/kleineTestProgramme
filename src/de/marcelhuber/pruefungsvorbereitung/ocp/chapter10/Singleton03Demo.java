package de.marcelhuber.pruefungsvorbereitung.ocp.chapter10;

/**
 *
 * @author Marcel Huber
 */
public class Singleton03Demo {

    public static void main(String[] args) {
        new Singleton03Demo().go();
    }

    private void go() {
        Singleton03 singleton03Objekt01 = Singleton03.getInstance();
        Singleton03 singleton03Objekt02 = Singleton03.getInstance();
        System.out.print("singleton03Objekt01 == null?                ");
        System.out.println(singleton03Objekt01 == null);
        System.out.print("singleton03Objekt02 == null?                ");
        System.out.println(singleton03Objekt02 == null);
        System.out.print("singleton03Objekt01 == singleton03Objekt02? ");
        System.out.println(singleton03Objekt01 == singleton03Objekt02);

    }
}
