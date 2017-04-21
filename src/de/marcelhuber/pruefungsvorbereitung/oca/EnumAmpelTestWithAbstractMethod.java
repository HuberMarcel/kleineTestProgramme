package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
enum EnumAmpelTestWithAbstractMethod { // Sichtbarkeit nur im Package
    // Erst die Konstanten, dann die Attribute
    ROT("Bitte anhalten!") {
        @Override
        public void showAnzeige() {
            System.out.println(getAnzeige().toUpperCase());
        }
    },
    GELB("Achtung, Zustandswechsel!") {
        @Override
        public void showAnzeige() {
            System.out.println(getAnzeige());
        }
    },
    GRUEN("Freie Fahrt.") {
        @Override
        public void showAnzeige() {
            System.out.println(getAnzeige());
        }
    };
    String anzeigenText; // Attribut

    private EnumAmpelTestWithAbstractMethod(String text) {
        this.anzeigenText = text;
    }

    public String getAnzeige() {
        return anzeigenText;
    }

    public void setAnzeige(String anzeige) {
        this.anzeigenText = anzeige;
    }

    abstract void showAnzeige();
}
