package de.marcelhuber.pruefungsvorbereitung.oca;

import static de.marcelhuber.mathematischeHilfsprogramme.hilfsmethoden.*;

/**
 *
 * @author Marcel Huber
 */
public class ElementareDatentypen {
//  1 Byte sind 8 Bit

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new ElementareDatentypen().go();
    }

    private void go() {
        wertebereichAnzeige("byte:     ", Byte.MIN_VALUE + "", Byte.MAX_VALUE + "");
        wertebereichAnzeige("byte:     ", "-2^(" + max2erExponent(Byte.MIN_VALUE) + ")",
                "2^(" + max2erExponent(Byte.MAX_VALUE + 1) + ")-1");
        System.out.println("");
        wertebereichAnzeige("short:    ", Short.MIN_VALUE + "", Short.MAX_VALUE + "");
        wertebereichAnzeige("short:    ", "-2^(" + max2erExponent(Short.MIN_VALUE) + ")",
                "2^(" + max2erExponent(Short.MAX_VALUE + 1) + ")-1");
        System.out.println("");
        wertebereichAnzeige("int:      ", Integer.MIN_VALUE + "", Integer.MAX_VALUE + "");
        wertebereichAnzeige("int:      ", "-2^(" + max2erExponent(Integer.MIN_VALUE) + ")",
                "2^(" + max2erExponent(Integer.MAX_VALUE + 1) + ")-1");
        System.out.println("");
        wertebereichAnzeige("long:     ", Long.MIN_VALUE + "", Long.MAX_VALUE + "");
        wertebereichAnzeige("long:     ", "-2^(" + max2erExponent(Long.MIN_VALUE) + ")",
                "2^(" + max2erExponent(Long.MAX_VALUE + 1) + ")-1");
        System.out.println("");
        wertebereichAnzeige("float:    ", Float.MIN_VALUE + "", Float.MAX_VALUE + "");
//        wertebereichAnzeige("float:    ", "-2^(" + exponentOfA2erPotenz(Float.MIN_VALUE) + ")",
//                "2^(" + exponentOfA2erPotenz(Float.MAX_VALUE + 1) + ")-1");
        System.out.println("");
        wertebereichAnzeige("double:   ", Double.MIN_VALUE + "", Double.MAX_VALUE + "");
        wertebereichAnzeige("double:   ", "-2^(" + max2erExponent(Double.MIN_VALUE) + ") (???)",
                "2^(" + max2erExponent(Double.MAX_VALUE + 1) + ")-1");
        System.out.println("");
        wertebereichAnzeige("char:     ", (long) Character.MIN_VALUE + "", (long) Character.MAX_VALUE + "");
        wertebereichAnzeige("char:     ", "-2^(" + max2erExponent((long) Character.MIN_VALUE) + ")",
                "2^(" + max2erExponent((long) Character.MAX_VALUE + 1) + ")-1");
//        wertebereichAnzeige("boolean:  ", Boolean.MIN_VALUE + "", Boolean.MAX_VALUE + "");
        System.out.println("");
        wertebereichAnzeige("boolean:  ", "" + false, "" + true);
    }

    private void wertebereichAnzeige(String typ, String min, String max) {
        System.out.println(typ + "     von " + min + " bis " + max);
    }
}
