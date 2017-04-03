/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.marcelhuber.assertions;

/**
 *
 * @author viona25
 */
public class AssertionsAbfrageZuBeginnAufrufe {

    public static void main(String[] args) {
        for (int schalter = 1; schalter < 3; schalter++) {
            switch (schalter) {
                case 1:
                    System.out.println("Methode 1: Anzeige bei Assertions On, "
                            + "sonst nichts!");
                    new AssertionsAbfrageZuBeginnMethode01().go();
                    break;
                case 2:
                    System.out.println("\nMethode 2: Anzeige bei Assertions On, "
                            + "und aber auch bei Asertions Off!");
                    new AssertionsAbfrageZuBeginnMethode02().go();
                    break;
                default:
                    System.out.println("Das ");
            }
        }
    }
}
