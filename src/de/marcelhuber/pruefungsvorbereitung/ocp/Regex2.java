// OCP: Seite 466
package de.marcelhuber.pruefungsvorbereitung.ocp;

import de.marcelhuber.systemtools.Marker;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marcel Huber; 06.09.2017
 */
public class Regex2 {

    public static void main(String[] args) {
        String str01 = "\\d*";
//        String str02 = "ab34ef";
        String str02 = "ab34ef234ff";
        Pattern p = Pattern.compile(str01);
        Matcher m = p.matcher(str02);
        // m.find() prüft im str02 immer, ob das Regex aus str01 vorkommt
        // solange str02 noch nicht abgearbeitet ist, und im obigen Falle
        // die nächste Stelle keine Ziffer ist, geht man mit find() eine
        // Stelle weiter - wird ein Digit-/eine Ziffernfolge getroffen, so 
        // werden für die nächste Position alle Stellen der Zahl (eine Zahl
        // ist ja auch nur eine endliche Ziffernfolge) "übersprungen"
        // Hinweis: Um dies einzusehen, einfach im Folgenden alle Zeilen bis
        //          auf die mit m.start() auskommentieren
        while (m.find()) {
            if (!m.group().isEmpty()) {
                System.out.println("Treffer: group " + m.group());
            } else {
                System.out.println("Kein Treffer!".toUpperCase());
            }
            System.out.print("Positionen: [");
            System.out.print("start " + m.start() + ", ");
            System.out.println("end " + m.end() + "]");
        }
        Marker.marker('_');
        // Aufgabe 3, Seite 69
        str01 = "\\B";
        str02 = "^23 $*76 bc";
        p = Pattern.compile(str01);
//        m.reset();
        m = p.matcher(str02);
        while (m.find()) {
            System.out.print(m.start() + " ");
        }
        System.out.println("".toUpperCase());
        int counter = 0;
        m.reset();
        Marker.marker();
        System.out.println("Test der find()-Methode!".toUpperCase());
        while (m.find()) {
            System.out.println("Anzahl Treffer: " + ++counter);
        }
    }
}
