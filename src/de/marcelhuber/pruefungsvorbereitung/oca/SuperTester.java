package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
class Super {

    static void ichBinHAHAHA() {
        System.out.println("HAHAHA, Super");
    }

    void ichBinEineCooleMethode() {
        System.out.println("Cool from Super!");
    }
}

public class SuperTester extends Super {

    public static void main(String[] args) {
        new SuperTester().go();
    }

    private void go() {
//        SuperTester.super.ichBinEineCooleMethode();     // Z1 anscheinend macht die folgende Zeile das Gleiche
//        super.ichBinEineCooleMethode();                 // Z2 macht das Gleiche wie Z1
        SuperTester.ichBinHAHAHA();
        SuperTester.ichBinHAHAHA();
        SuperTester.super.ichBinHAHAHA();
        super.ichBinHAHAHA();
        ichBinHAHAHA();
        this.ichBinHAHAHA();
        Super.ichBinHAHAHA();
        SuperTester.ichBinHAHAHA();
    }

    @Override
    void ichBinEineCooleMethode() {
        System.out.println("Cool from SuperTester!");
    }

    static void ichBinHAHAHA() {
        System.out.println("HAHAHA, SuperTester");
    }
}
