package de.marcelhuber.pruefungsvorbereitung.oca;

import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class VokabularEnglischDeutsch extends ListResourceBundle {

//    public static void main(String[] args) {
//        new VokabularEnglischDeutsch().go();
//    }
    private void go() {
//        uebersetze("unpredictable   ", " unvorhersehbar");
//        uebersetze("Gadget          ", " Sondervorrichtung");
//        uebersetze("crudely         ", " roh");
//        uebersetze("up to           ", " bis zu");
//        uebersetze("fragments       ", " Bruchstücke");
//        uebersetze("to may not      ", " nicht dürfen");
//        uebersetze("raptor          ", " Greifvogel");
//        uebersetze("hawk            ", " Falke");
//        uebersetze("to represent    ", " darstellen");
//        uebersetze("dozen           ", " Dutzend");
//        uebersetze("flexibility     ", " Flexibilität");
//        uebersetze("maintainability ", " Wartbarkeit");
//        uebersetze("benefits        ", " Vorteile");
//        uebersetze("to insulate     ", " isolieren");
//        uebersetze("extensibility   ", " Erweiterbarkeit");
//        uebersetze("ahead           ", " voraus");
//        uebersetze("to promote      ", " fordern");
//        uebersetze("to derive       ", " ableiten");
//        uebersetze("further         ", " des Weiteren");
//        uebersetze("appropriate     ", " angemessen");
//        uebersetze("to consider     ", " prüfen");
        System.out.println("unpre");
    }

    private void uebersetze(String englisch, String deutsch) {
        System.out.println(englisch + " - " + deutsch);
    }

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"Germany", "Deutschland"},
            {"unpredictable", "unvorhersehbar"},
            {"gadget", "Sondervorrichtung"},
            {"crudely", "roh"},
            {"up to", "bis zu"},
            {"fragments", "Bruchstücke"},
            {"may not", "nicht können"},
            {"raptor", "Greifvogel"},
            {"hawk", "Falke"},
            {"to represent", "darstellen"},
            {"dozen", "Dutzend"},
            {"flexibility", "Flexibilität"},
            {"maintainability", "Wartbarkeit"},
            {"benefits", "Vorteile"},
            {"to insulate", "isolieren"},
            {"extensibility", "Erweiterbarkeit"},
            {"ahead", "voraus"},
            {"to promote", "fordern"},
            {"to derive", "ableiten"},
            {"further", "des Weiteren"},
            {"appropriate", "angemessen"},
            {"to consider", "prüfen"},
            {"must not", "darf nicht"}};
    }
}
