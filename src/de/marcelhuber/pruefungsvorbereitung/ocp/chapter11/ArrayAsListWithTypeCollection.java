package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

import de.marcelhuber.systemtools.Marker;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber; letzte Änderung: 10.8.2017
 */
public class ArrayAsListWithTypeCollection {

    // class Parent ist hier eine innere Klasse
    public class Parent {

        public Parent() {
        }

        public Parent(String familienname, String vorname) {
            this.familienname = familienname;
            this.vorname = vorname;
        }
        private String familienname;
        private String vorname;

        @Override
        public String toString() {
            return "Name: " + familienname + "; Vorname: " + vorname;
        }
    }

    // class Child ist hier eine innere Klasse, die die innere Klasse 
    // Parent erweitert
    public class Child extends Parent {

        private String spitzname;

        public Child() {
        }

        public Child(String familienname, String name, String spitzname) {
            super(familienname, name);
            this.spitzname = spitzname;
        }

        @Override
        public String toString() {
            return super.toString() + "; Spitzname: " + spitzname;
        }
    }

    public static void main(String[] args) {
        ArrayAsListWithTypeCollection dummyObject = new ArrayAsListWithTypeCollection();
        dummyObject.go01();
    }

    private void go01() {
        Child pascal = new Child("Huber", "Pascal", "Pasue");
        Child marcel = new Child("Huber", "Marcel", "Maars");
        Child sascha = new Child("Huber", "Sascha", "Saschsch");
        Parent papa = new Parent("Huber", "Herbert");
        Parent mama = new Parent("Huber", "Gisela");
//        System.out.println(pascal);
//        System.out.println(marcel);
//        System.out.println(sascha);
//        System.out.println(papa);
//        System.out.println(mama);
        Parent[] menschen = new Parent[5];
        menschen[0] = pascal;
        menschen[1] = marcel;
        menschen[2] = sascha;
        menschen[3] = papa;
        menschen[4] = mama;
        for (Parent mensch : menschen) {
//            System.out.println((Parent) mensch);
            System.out.println(mensch);
            // die letzte überschriebene Methode wird ausgeführt
        }
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Jetzt mit einer untypisierten Liste!");
        List menschenListe = Arrays.asList(menschen);
        for (Object object : menschenListe) {
            System.out.println(object);
        }
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Jetzt mit dem Versuch einer typisierten Liste!");
        List<Parent> menschenListeAlsParentTypisiert
                = Arrays.asList(menschen);
        for (Parent mensch : menschenListeAlsParentTypisiert) {
            System.out.println(mensch);
        }
        System.out.println("");
        System.out.println("");
        System.out.println(("Fazit: Bei der backed-Collection kann dann doch "
                + "auch der \"Typ\" der Liste\n"
                + "\"durchbrochen\" werden (Liste erstellt aus Array)!")
                .toUpperCase());
        Marker.marker('-');
        Marker.marker('-');
        System.out.println("Nochmal Spaß mit inneren Klassen - von hier aus "
                + "\nkönnen wir auch auf private Attribute dieser zugreifen!");
        System.out.println("Beispiel anhand des Objekts marcel:");
        System.out.println("((Parent) marcel).familienname: "
                + ((Parent) marcel).familienname);
        System.out.println("((Parent) marcel).vorname:      "
                + ((Parent) marcel).vorname);
        System.out.println("marcel.spitzname:               "
                + marcel.spitzname);
    }
}
