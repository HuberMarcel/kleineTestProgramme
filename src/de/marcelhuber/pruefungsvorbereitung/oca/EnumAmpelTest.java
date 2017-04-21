package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public enum EnumAmpelTest {
    ROT("Bitte anhalten!") {
        @Override
        public void showAnzeige() {
            System.out.println(getAnzeige().toUpperCase());
        }
    },
    GELB("Achtung, Zustandswechsel!") {
    },
    GRUEN("Freie Fahrt.") {
    };
    String anzeigenText;

    private EnumAmpelTest(String text) {
        this.anzeigenText = text;
    }

    public String getAnzeige() {
        return anzeigenText;
    }

    public void setAnzeige(String anzeige) {
        this.anzeigenText = anzeige;
    }

    void showAnzeige() {
        System.out.println(anzeigenText);
    }
;
}
