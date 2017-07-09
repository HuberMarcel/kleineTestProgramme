package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class GenericsPocketForNumbersDemo {

    public static void main(String[] args) {
        new GenericsPocketForNumbersDemo().go();
    }

    private void go() {
        List<Byte> zuAddierendeZahlen = new ArrayList<>();
        zuAddierendeZahlen.add((Byte) (byte) 1);
        zuAddierendeZahlen.add((Byte) (byte) 3);
        zuAddierendeZahlen.add((Byte) (byte) 5);
        zuAddierendeZahlen.add((Byte) (byte) 7);
        zuAddierendeZahlen.add((Byte) (byte) 9);
        zuAddierendeZahlen.add((Byte) (byte) 11);
        zuAddierendeZahlen.add((Byte) (byte) 13);
        zuAddierendeZahlen.add((Byte) (byte) 15);
        zuAddierendeZahlen.add((Byte) (byte) 17);
        zuAddierendeZahlen.add((Byte) (byte) 19);
        zuAddierendeZahlen.add((Byte) (byte) 21);
        zuAddierendeZahlen.add((Byte) (byte) 23);
        GenericsPocketForNumbers<Byte> testFeldFuerBytes 
                = new GenericsPocketForNumbers<>(zuAddierendeZahlen);
        System.out.println(testFeldFuerBytes.addiereAlleMeineZahlen());
//        System.out.println(testFeldFuerBytes.addiereAlleMeineZahlen().getClass());
    }
}
