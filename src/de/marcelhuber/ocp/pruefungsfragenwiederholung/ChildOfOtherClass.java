package de.marcelhuber.ocp.pruefungsfragenwiederholung;

import de.marcelhuber.ocp.pruefungsfragenwiederholung.package01.*;

/**
 *
 * @author Marcel Huber; 20.09.2017
 */
public class ChildOfOtherClass extends OtherClass {

    static int x = 2;
    int y = 3;

    public static void main(String[] args) {
        ChildOfOtherClass hereIAm = new ChildOfOtherClass();
        System.out.println(x);           // Ausgabe 2
        System.out.println(hereIAm.x);   // Ausgabe 2
//        // statischer Kontext kann nicht auf Instanzvariablen zugreifen
//        System.out.println(y);
        System.out.println(hereIAm.y);   // Ausgabe 3
    }
}
