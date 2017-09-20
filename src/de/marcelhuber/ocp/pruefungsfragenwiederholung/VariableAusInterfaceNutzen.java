package de.marcelhuber.ocp.pruefungsfragenwiederholung;

/**
 *
 * @author Marcel Huber; 20.09.2017
 */
public class VariableAusInterfaceNutzen extends AbstrakteKlasse implements TestInterface{
    public static void main(String[] args) {
//        System.out.println(new VariableAusInterfaceNutzen().x);
    }
}

abstract class AbstrakteKlasse {

//    private
    int x = 10;
}

interface TestInterface {

    int x = 20;
}
