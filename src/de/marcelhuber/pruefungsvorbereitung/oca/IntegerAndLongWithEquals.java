package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class IntegerAndLongWithEquals {

    public static void main(String[] args) {
        Integer i = 27;
        Long l = 27L;
        if (i.equals(l)) {
            System.out.println("i = " + i + " und l = " + l + " haben "
                    + "denselben Wert und sind gleich!!");
        } else {
            System.out.println("i = " + i + " und l = " + l + " haben "
                    + "denselben Wert, sind aber wegen Typverschiedenheit ungleich!!");
        }
    }
}
