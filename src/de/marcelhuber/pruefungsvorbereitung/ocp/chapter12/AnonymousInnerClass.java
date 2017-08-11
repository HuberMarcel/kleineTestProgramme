// Anonyme Innere Klassen, Buch Seite 693 ff.
//         sie sind immer Kinder der Klassen, auf die sie sich beziehen
//         können aber Methoden überschreiben oder ergänzen
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter12;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; letzte Änderung: 11.08.2017
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {
        AnonymousInnerClass dummyObject = new AnonymousInnerClass();
        dummyObject.go01();
    }

    private void go01() {
        AnonymousInnerClass test = new AnonymousInnerClass() {
            @Override
            public String toString() {
                return "Ich bin ein Objelt einer anonymen Klasse!";
            }
        };
        System.out.println(test);
        System.out.println(test.getClass());
        System.out.println(new AnonymousInnerClass() {
            @Override
            public String toString() {
                return "Ich bin ein Objekt aus einer anderen, anonymen Klassse!";
            }
        });
        System.out.println(new AnonymousInnerClass() {
            @Override
            public String toString() {
                return "Ich bin aus einer weiteren, anderen anonymen Klassse!";
            }
        }.getClass());
        Marker.marker('_');
        Marker.marker('_');
        WeitereKlasse anonymesObjektAusWeitereKlasse
                = new WeitereKlasse() {
            @Override
            public String toString() {
                return super.toString() + ", aber anonym!";
            }
        };
        System.out.println(anonymesObjektAusWeitereKlasse);
        anonymesObjektAusWeitereKlasse.testeEineAusgabe();
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Objekt einer anonymen inneren Klasse mit eigener "
                + "Methode!");
        System.out.println(new WeitereKlasse() {
            public String testAusgabe() {
                return "testAusgabe()-Methode wird aufgerufen";
            }
        }.testAusgabe());
        Object anonymousObject = new Object() {
            public void testAusgabeFuerObject() {
                System.out.println("Ich bin die Methode testAusgabeFuerObject!");
            }
        };
        // keine Zugriffsmöglichkeit!
//        anonymousObject.testAusgabeFuerObject();
        System.out.println(anonymousObject.toString());
    }
}

class WeitereKlasse {

    public void testeEineAusgabe() {
        System.out.println("Teste eine Ausgabe - aus der Klasse: "
                + "WeitereKlasse".toUpperCase());
    }

    @Override
    public String toString() {
        return "Ich komme aus der Klasse: " + "WeitereKlasse".toUpperCase();
    }
}
