package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class AccessModifier {
//das Folgende gilt für statische und Objekt- Variablen (Instanz-Variablen)
//bzw. auch für statische bzw. Objekt- Methoden (Instanz-Methoden)
    // private:     nur die Klasse hier hat Zugriff
    // default:     alle Klassen innerhalb dieses Packages haben Zugriff
    // protected:   alle Kinder der Klasse hier können drauf zugreifen
    // public:      ich stehe der ganzen Java-Welt zur Verfügung

    private byte privateZahl = 0;
    short defaultZahl = 1;
    protected int protectedZahl = 2;
    public long publicZahl = 3;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new AccessModifier().go();
    }

    private void go() {
        System.out.println("private:     "
                + "nur die Klasse hier hat Zugriff auf mich!");
        System.out.println("default:     "
                + "alle Klassen innerhalb dieses Packages haben Zugriff"
                + "auf mich!");
        System.out.println("protected:   "
                + "alle Kinder der Klasse hier können auf mich zugreifen!");
        System.out.println("public:      "
                + "alle Klassen der ganzen Java-Welt können auf mich"
                + "zugreifen!");
    }

}
