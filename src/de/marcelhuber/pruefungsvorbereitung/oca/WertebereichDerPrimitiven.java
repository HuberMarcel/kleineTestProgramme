package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class WertebereichDerPrimitiven {

    public static void main(String[] args) {
        new WertebereichDerPrimitiven().go();
    }

    void go() {
        Byte by = 0;
        Short sh = 0;
        Integer in = 0;
        Long lo = 0L;
        allValues(by);
        allValues(sh);
        allValues(in);
        allValues(lo);
    }

    private void allValues(Object ob) {
        String typ;
        long minValue;
        long maxValue;
        long werteBereichsGroesse;
        long size;
        if (ob instanceof Byte
                || ob instanceof Short
                || ob instanceof Long
                || ob instanceof Integer) {
            if (ob instanceof Byte) {
                typ = "Byte";
                minValue = ((Byte) ob).MIN_VALUE;
                maxValue = ((Byte) ob).MAX_VALUE;
                size = ((Byte) ob).SIZE;
            } else if (ob instanceof Short) {
                typ = "Short";
                minValue = ((Short) ob).MIN_VALUE;
                maxValue = ((Short) ob).MAX_VALUE;
                size = ((Short) ob).SIZE;
            } else if (ob instanceof Integer) {
                typ = "Integer";
                minValue = ((Integer) ob).MIN_VALUE;
                maxValue = ((Integer) ob).MAX_VALUE;
                size = ((Integer) ob).SIZE;
            } else if (ob instanceof Long) {
                minValue = ((Long) ob).MIN_VALUE;
                maxValue = ((Long) ob).MAX_VALUE;
                size = ((Long) ob).SIZE;
                typ = "Long";
            } else {
                typ = "";
                minValue = 0;
                maxValue = 0;
                size = 0;
            }
            werteBereichsGroesse = maxValue - minValue + 1;    // die 0 muss mitgezählt werden
            System.out.println("Typ:                " + typ);
            System.out.println("min:                " + minValue);
            System.out.println("max:                " + maxValue);
            System.out.println("size:               " + size);
            if (!typ.toLowerCase().equals("long")) {
                // die Berechnung der Wertebereichsgöße ergibt im Falle Long 
                // keinen Sinn, da wir dann über Long.MAX_VALUE hinausgehen würden, was
                // wir nicht können
                System.out.println("Wertebereichsgröße: "
                        + werteBereichsGroesse + " = 2^{"
                        // + (Long) (Math.log(werteBereichsGroesse) / Math.log(2))); // double muss erst in long
                        // gecastet werden, um es dann
                        // in Long boxen zu können
                        + (Long) (long) (Math.log(werteBereichsGroesse) / Math.log(2)) + "}");
            } else {
                System.out.println("Wertebereichsgröße: 2^{" + size + "}");
            }
//            System.out.println("Wertebereichsgröße: "
//                    + werteBereichsGroesse + " = 2^"
//                    + (Number) (Math.log(werteBereichsGroesse) / Math.log(2)));
            System.out.println("");
        }
    }
}
