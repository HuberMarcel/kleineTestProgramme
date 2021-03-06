package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

import de.marcelhuber.systemtools.Marker;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Marcel Huber; letzte Änderung: 09.08.2017
 */
public class PriorityQueueTester {

    private String[] namen = {"Beck", "Müller", "Riedl", "Willeitner", "Bauer",
        "Mertes", "Beckenbauer", "Schmidt", "Huber"};

    class PriorityQueueComparator implements Comparator<String> {

        @Override
        public int compare(String str01, String str02) {
            return str02.compareToIgnoreCase(str01);
        }
    }

    public static void main(String[] args) {
        PriorityQueueTester dummyObject = new PriorityQueueTester();
        dummyObject.go01();
        dummyObject.go02();
    }

    private void go01() {
        PriorityQueue<String> namensListeNachPriorität;
        namensListeNachPriorität = new PriorityQueue<>();
        for (String name : namen) {
            namensListeNachPriorität.offer(name);
        }
        System.out.println("Ausgabe der Liste:");
        System.out.println(namensListeNachPriorität);
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Fazit: Die Elemente der Priority-Queue werden "
                + " nicht  ".toUpperCase() + "schon während der Anwendung "
                + "der\noffer()-Methode nach der entsprechenden Priorität "
                + "angeordnet!");
        System.out.println("");
        System.out.println("");
        System.out.println("Jetzt Ausgabe entsprechend der Priorität, also "
                + "hier in natürlicher Anordnung (ohne Beachtung\nder Groß- "
                + "bzw. Kleinschreibung):");
//        namensListeNachPriorität.clear();
        for (String name;
                !namensListeNachPriorität.isEmpty();) {
            name = namensListeNachPriorität.poll();
            System.out.println(name);
        }
        Marker.marker('-');
        Marker.marker('-');
    }

    private void go02() {
        System.out.println("");
        System.out.println("Methode go02() startet:".toUpperCase());
        Marker.marker('_');
        Marker.marker('_');
        PriorityQueue<String> namensListeNachPriorität;
        namensListeNachPriorität = new PriorityQueue<>(new PriorityQueueComparator());
        for (String name : namen) {
            namensListeNachPriorität.offer(name);
        }
        System.out.println("Ausgabe der Liste:");
        System.out.println(namensListeNachPriorität);
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Fazit: Die Elemente der Priority-Queue werden "
                + " nicht  ".toUpperCase() + "schon während der Anwendung "
                + "der\noffer()-Methode nach der entsprechenden Priorität "
                + "angeordnet!");
        System.out.println("");
        System.out.println("");
        System.out.println("Jetzt Ausgabe entsprechend der Priorität, also "
                + "hier in umgekehrter natürlicher Anordnung (ohne Beachtung\n"
                + "der Groß- bzw. Kleinschreibung):");
        for (String name = namensListeNachPriorität.peek(); !namensListeNachPriorität.isEmpty();) {
            name = namensListeNachPriorität.poll();
            System.out.println(name);
        }
        Marker.marker('-');
        Marker.marker('-');
    }
}
