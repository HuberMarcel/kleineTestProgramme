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
        uebersetze("unpredictable   ", " unvorhersehbar");
        uebersetze("Gadget          ", " Sondervorrichtung");
        uebersetze("crudely         ", " roh");
        uebersetze("up to           ", " bis zu");
        uebersetze("fragments       ", " Bruchstücke");
        uebersetze("to may not      ", " nicht dürfen");
        uebersetze("raptor          ", " Greifvogel");
        uebersetze("hawk            ", " Falke");
        uebersetze("to represent    ", " darstellen");
        uebersetze("dozen           ", " Dutzend" );
        uebersetze("flexibility     ", " Flexibilität");
        uebersetze("maintainability ", " Wartbarkeit");
        uebersetze("benefits        ", " Vorteile");
        uebersetze("to insulate     ", " isolieren");
        uebersetze("extensibility   ", " Erweiterbarkeit");
        uebersetze("ahead           ", " voraus");
        uebersetze("to promote      ", " fordern");
        uebersetze("to derive       ", " ableiten");
        uebersetze("further         ", " des Weiteren");
        uebersetze("appropriate     ", " angemessen");
    }

    private void uebersetze(String englisch, String deutsch) {
        System.out.println(englisch + " - " + deutsch);
    }
}
