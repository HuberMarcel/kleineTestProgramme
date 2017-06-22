package de.marcelhuber.zweiInterfacestest;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ichBenutzedieBeidenInterfacesUndBinSingletonDemo {

    public static void main(String[] args) {
        new ichBenutzedieBeidenInterfacesUndBinSingletonDemo().go();
    }

    private void go() {
        System.out.println("Objekt 01:");
        ichBenutzedieBeidenInterfacesUndBinSingleton obj01
                = ichBenutzedieBeidenInterfacesUndBinSingleton.getInstance();
        System.out.println(obj01.getName());

        ichBenutzedieBeidenInterfacesUndBinSingleton obj02
                = ichBenutzedieBeidenInterfacesUndBinSingleton.getInstance();
        System.out.println("Objekt 02 (Versuch!):");
        System.out.println(obj02);
        try {
            System.out.println(obj02.getName());
        } catch (NullPointerException ex) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex1) {
                Logger.getLogger(ichBenutzedieBeidenInterfacesUndBinSingletonDemo.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.err.println("NullPointerException: "
                    + "Es wurde kein Objekt erzeugt!");
        }
        ichBenutzedieBeidenInterfacesUndBinSingleton.setReturnTheSingleObjectIfExistent(true);
        obj02 = ichBenutzedieBeidenInterfacesUndBinSingleton.getInstance();
        System.out.println("Objekt 02:");
        System.out.println(obj02);
        System.out.println(obj02.getName());
        System.out.println("Ändere Namen von Objekt 01:");
        obj01.setName("Leopold");
        System.out.println("Ausgabe von Objekt 02 (extra nicht Onjekt 01):");
        System.out.println(obj02);
        System.out.println("");
        System.out.println("Denn die Referenzen verweisen auf das selbe Objekt - "
                + "Ausgabe von Objekt 01:");
        System.out.println(obj01);
    }
}
