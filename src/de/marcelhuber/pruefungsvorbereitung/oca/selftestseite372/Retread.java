package de.marcelhuber.pruefungsvorbereitung.oca.selftestseite372;

/**
 *
 * @author Marcel Huber
 */
class MyException extends Exception {
}

class Tire {

    void doStuff() {
    }
}

public class Retread extends Tire {

    public static void main(String[] args) {
        new Retread().doStuff();
    }

    // insert code here
    void doStuff() {                                           // geht 
        System.out.println(7 / 0);
//        assert (false);
    }

}

//void doStuff() {                                           // geht 
//void doStuff() throws MyException {                        // geht nicht
//void doStuff() throws RuntimeException {                   // geht, da unchecked
//void doStuff() throws ArithmeticException {                // geht, da unchecked  
//And given the following four code fragments:
//I. void doStuff() {                                        // geht
//II. void doStuff() throws MyException {                    // geht nicht
//III. void doStuff() throws RuntimeException {              // geht, da unchecked
//IV. void doStuff() throws ArithmeticException {            // geht, da unchecked
