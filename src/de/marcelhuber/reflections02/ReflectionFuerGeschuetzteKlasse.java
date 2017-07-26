package de.marcelhuber.reflections02;

import de.marcelhuber.reflections01.GeschuetzteKlasse;
import de.marcelhuber.systemtools.Marker;
import java.lang.Class;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class ReflectionFuerGeschuetzteKlasse {

    public static void main(String[] args) {
        new ReflectionFuerGeschuetzteKlasse().go();
    }

    private void go() {
//        Class<GeschuetzteKlasse> infoGeschuetzteKlasse = GeschuetzteKlasse.class;
        GeschuetzteKlasse geschuetzteKlasse = new GeschuetzteKlasse();
        Class<GeschuetzteKlasse> infoGeschuetzteKlasse
                = (Class<GeschuetzteKlasse>) geschuetzteKlasse.getClass();
        System.out.println("Welche Klasse bist Du?");
        try {
            System.out.println("Hier das Klassen-Objekt: " + infoGeschuetzteKlasse
                    .forName("de.marcelhuber.reflections01.GeschuetzteKlasse"));
            System.out.println("Hier der (einfache) Klassenname: ");
            System.out.println(infoGeschuetzteKlasse
                    .getSimpleName());
            System.out.println("Hier der vollqualifizierte Klassenname:");
            System.out.println(infoGeschuetzteKlasse
                    .getName());
            System.out.println("");
            Marker.marker('_');
            System.out.println("Logisches Zusammenspiel:");
            System.out.println("Nochmal das Klassenobjekt:\n"
                    + infoGeschuetzteKlasse.forName(infoGeschuetzteKlasse.getName()));
            Marker.marker('_');
            Marker.marker('_');
            System.out.println("\n\n");
            System.out.println("Welche öffentlichen Felder besitzt Du?");
            System.out.println(Arrays.toString(infoGeschuetzteKlasse.getFields()));
            System.out.println("");
            System.out.println("Welche Felder besitzt Du insgesamt?");
            System.out.println(Arrays.toString(infoGeschuetzteKlasse.getDeclaredFields()));
            System.out.println("Jetzt nochmal sortiert:");
            for (Object obj : infoGeschuetzteKlasse.getDeclaredFields()) {
                System.out.println("Feld: " + obj.toString().split("\\.")[obj.toString().split("\\.").length - 1]);
            }
            Marker.marker('_');
            Marker.marker('_');
            System.out.println("\n\n");
            System.out.println("Welche öffentlichen Methoden hast Du?");
            System.out.println(Arrays.toString(infoGeschuetzteKlasse.getMethods()));
            System.out.println("Nochmal sortiert:");
            for (Object obj : infoGeschuetzteKlasse.getMethods()) {
                System.out.println("Feld: " + obj.toString().split("\\.")[obj.toString().split("\\.").length - 1]);
            }
            System.out.println("");
            System.out.println("Welche Methoden hast Du insgesamt_");
            System.out.println(Arrays.toString(infoGeschuetzteKlasse.getDeclaredMethods()));
            System.out.println("Nochmal sortiert:");
            for (Object obj : infoGeschuetzteKlasse.getDeclaredMethods()) {
                System.out.println("Feld: " + obj.toString().split("\\.")[obj.toString().split("\\.").length - 1]);
            }
            System.out.println("\n\n");
            Marker.marker('_');
            Marker.marker('_');
            System.out.println("Welche Konstruktoren gibt's bei Dir?");
            System.out.println(Arrays.toString(infoGeschuetzteKlasse.getDeclaredConstructors()));
            Marker.marker('_');
            Marker.marker('_');
            System.out.println("Ansicht des Objekts geschuetzteKlasse:\n" + geschuetzteKlasse);
            Field irgendeinZaehler = infoGeschuetzteKlasse.getDeclaredField("irgendeinZaehler");
            irgendeinZaehler.setAccessible(true);
            irgendeinZaehler.set(geschuetzteKlasse, 100);
            Marker.marker('-');
            System.out.println("Nochmal das Objekt aus geschuetzteKlasse:");
            System.out.println(geschuetzteKlasse);
            Marker.marker('_');
            Marker.marker('_');
        } catch (Exception ex) {
            Logger.getLogger(ReflectionFuerGeschuetzteKlasse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
