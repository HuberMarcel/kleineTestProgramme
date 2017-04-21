package de.marcelhuber.pruefungsvorbereitung.oca;

import de.marcelhuber.systemtools.PressEnter;

/**
 *
 * @author Marcel
 */
public class EnumAmpelTestDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new EnumAmpelTestDemo().go();
    }

    private void go() {
        EnumAmpelTestWithAbstractMethod.GRUEN.showAnzeige();
        EnumAmpelTestWithAbstractMethod.GELB.showAnzeige();
        EnumAmpelTestWithAbstractMethod.ROT.showAnzeige();
        System.out.println("");
        System.out.println("Nun verwenden wir eine andere ENUM!");
        EnumAmpelTest gruen = EnumAmpelTest.GRUEN;
        EnumAmpelTest gelb = EnumAmpelTest.GELB;
        EnumAmpelTest rot = EnumAmpelTest.ROT;
        gruen.showAnzeige();
        gelb.showAnzeige();
        rot.showAnzeige();
        System.out.println("");
        System.out.println("Wir geben mal die Konstanten aus:");
        for (EnumAmpelTest enumAmpel : EnumAmpelTest.values()) {
            System.out.print(enumAmpel + " ");
        }
        System.out.println("\n");
        System.out.println("Nun behandeln wir den Switch-Case");
        for (EnumAmpelTest enumAmpel : EnumAmpelTest.values()) {
            System.out.print(enumAmpel + ": ");
            switch (enumAmpel) {
                case GRUEN: // wichtig: unqualifizierter Name der Konstanten
//                    System.out.print("GRUEN: ");
                    enumAmpel.showAnzeige();
                    break;
                case GELB:
//                    System.out.print("GELB:  ");
                    enumAmpel.showAnzeige();
                    break;
                case ROT:
//                    System.out.print("ROT:   ");
                    enumAmpel.showAnzeige();
                    break;
                default:
                    throw new AssertionError(); // das ist eigentlich unmöglich
            }
            PressEnter.toContinue();
        }
    }
}
