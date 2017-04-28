package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Marcel Huber
 */
public class GgTViewConsole implements GgTView {

    private GgTController ggTController;
    private long eingabe;
    private long eingabeA, eingabeB;
    private BufferedReader reader;

    @Override
    public void setController(GgTController ggTController) {
        this.ggTController = ggTController;
    }

    @Override
    public void showView() {
        System.out.println("***************************************************"
                + "*********************************************");
        System.out.println("***************************************************"
                + "*********************************************");
        System.out.println("***  Berechne GGT zweier Zahlen a und b  ***"
                + "(Abbruch mit q/Q, Neustart (Reset) mit w/W/r/R)  ***");
        System.out.println("**************************************************"
                + "**********************************************");
        System.out.println("***************************************************"
                + "*********************************************");

        System.out.println("");
        getEingabenAB();
        System.out.println("");
        System.out.println("****************************************************");
        System.out.println("***  Berechnung fertig... bereit für eine neue?  ***");
        System.out.println("****************************************************");
        System.out.println("\n");
        showView();
    }

    @Override
    public void reset() {
        System.out.println("Reset...");
        eingabeA = 0;
        eingabeB = 0;
        ggTController.newGgTCalculation(eingabeA, eingabeB);
        showView();
    }

    public void getEingabenAB() {
        eingabeA = getEingabeA();
        eingabeB = getEingabeB();
        ggTController.newGgTCalculation(eingabeA, eingabeB);
    }

    @Override
    public long getEingabeA() {
        System.out.print("Ihre Eingabe für a: ");
        return readEingabe();
    }

    @Override
    public long getEingabeB() {
        System.out.print("Ihre Eingabe für b: ");
        return readEingabe();
    }

    private long readEingabe() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            if (s.toUpperCase().equals("Q")) {
                System.out.println("");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("!!!  Programm vom Benutzer beendet  !!!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.exit(0);
            } else if (s.toLowerCase().equals("w") || s.toLowerCase().equals("r")) {
                System.out.println("");
                reset();
            }
            return eingabe = Long.parseLong(s);
        } catch (IOException | NumberFormatException ex) {
            System.out.println("");
            System.out.println("FEHLEINGABE!!");
            System.out.println("Programm beendet...");
            System.exit(0);
        }
        return 0;
    }

    public void showResults() {
//        showResultX(ggTController.getX());
//        showResultY(ggTController.getY());
//        showResultGgT(ggTController.getGgT());
        System.out.println("");
        System.out.println("Es gilt:");
        System.out.print(ggTController.getGgT() + " = " + "ggT(" + eingabeA + "," + eingabeB + ") = ");
        System.out.print(ggTController.getX() + "*" + klammerNegLong(eingabeA));
        System.out.println(" + " + klammerNegLong(ggTController.getY()) + "*"
                + klammerNegLong(eingabeB));
        System.out.println("");
        System.out.print("Kontrollrechnung durch direktes Ausrechnen der "
                + "rechten Seite,\ndiese sollte dem oben linksstehenden ggT entsprechen: ");
        System.out.println(ggTController.getX() * eingabeA
                + ggTController.getY() * eingabeB);
        System.out.println("");
    }

    public String klammerNegLong(long h) {
        // diese Methode liefert einen long
        // als String zurück, wobei negative
        // Werte geklammert werden (nur diese)
        if (h < 0) {
            return "(" + h + ")";
        } else {
            return "" + h;
        }
    }

    public void showResultX(long x) {
        System.out.println("x: " + x);
    }

    public void showResultY(long y) {
        System.out.println("y: " + y);
    }

    public void showResultGgT(long ggT) {
        System.out.println("ggT: " + ggT);
    }

}
