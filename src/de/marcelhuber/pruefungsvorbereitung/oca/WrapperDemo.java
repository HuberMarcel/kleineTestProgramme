package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class WrapperDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new WrapperDemo().go();
    }

    private void go() {
        System.out.println("OHNE WRAPPER-POOL");
        Integer[] i = new Integer[3];
        Integer[] j = new Integer[3];

        Integer i0 = new Integer(1);
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(128);

        i[0] = i0;
        i[1] = i1;
        i[2] = i2;

        Integer j0 = new Integer(1);
        Integer j1 = new Integer(127);
        Integer j2 = new Integer(128);

        j[0] = j0;
        j[1] = j1;
        j[2] = j2;

        for (int k = 0; k < i.length; k++) {
            System.out.print(k + ": " + (i[k] == j[k]));
            if (k < i.length - 1) {
                System.out.print("  |  ");
            }
        }

        System.out.println("");

        for (int k = 0; k < i.length; k++) {
            System.out.print(k + ": " + (i[k].equals(j[k])));
            if (k < i.length - 1) {
                System.out.print("  |  ");
            }
        }
        System.out.println("");

        /* Jetzt mit Wrapper-Pool */
        System.out.println("WRAPPER-POOL");
        i0 = 1;
        i1 = 127;
        i2 = 128;

        i[0] = i0;
        i[1] = i1;
        i[2] = i2;

        j0 = 1;
        j1 = 127;
        j2 = 128;

        j[0] = j0;
        j[1] = j1;
        j[2] = j2;

        // true true false
        for (int k = 0; k < i.length; k++) {
            System.out.print(k + ": " + (i[k] == j[k]));
            if (k < i.length - 1) {
                System.out.print("  |  ");
            }
        }

        System.out.println("");

        // true true true
        for (int k = 0; k < i.length; k++) {
            System.out.print(k + ": " + (i[k].equals(j[k])));
            if (k < i.length - 1) {
                System.out.print("  |  ");
            }
        }
        System.out.println("");
    }
}
