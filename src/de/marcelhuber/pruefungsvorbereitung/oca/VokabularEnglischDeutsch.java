package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class VokabularEnglischDeutsch {

    public static void main(String[] args) {
        new VokabularEnglischDeutsch().go();
    }

    private void go() {
        uebersetze("unpredictable ", " unvorhersehbar");
        uebersetze("Gadget        ", " Sondervorrichtung");
        uebersetze("crudely       ", " roh");
        uebersetze("up to         ", " bis zu");
        uebersetze("fragments     ", " Bruchstücke");
        uebersetze("to may not    ", " nicht dürfen");
        uebersetze("raptor        ", " Greifvogel");
        uebersetze("hawk          ", " Falke");
        uebersetze("to represent  ", " darstellen");
        uebersetze(null, null);
    }

    private void uebersetze(String englisch, String deutsch) {
        System.out.println(englisch + " - " + deutsch);
    }
}
