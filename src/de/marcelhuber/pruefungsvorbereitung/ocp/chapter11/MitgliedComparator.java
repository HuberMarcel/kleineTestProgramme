package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

import java.util.Comparator;

/**
 *
 * @author Marcel Huber; letzte Änderung: 09.08.2017
 */
public class MitgliedComparator<T extends Mitglied> implements Comparator<T> {

    // einfach mal umgekehrt Sortieren, wie das bei der compareTo der Fall war
    // nur bei gleichem Beitrittsjahr aber wieder alphabetisch 
    @Override
    public int compare(T obj01, T obj02) {
        if (obj01.getBeitrittsJahr() != obj02.getBeitrittsJahr()) {
            return obj02.compareTo(obj01);
        } else {
            if (obj01.getName() == obj02.getName()) {
////                // auskommentiert: umgekehrt alphabetisch ohne Beachtung von 
////                // Groß- und Kleinschreibung
//                return (obj02.getVorname()).compareToIgnoreCase(obj01.getVorname());
                return (obj01.getVorname()).compareToIgnoreCase(obj02.getVorname());
            } else {
//                // auskommentiert: umgekehrt alphabetisch ohne Beachtung von 
//                // Groß- und Kleinschreibung
//                return (obj02.getName()).compareToIgnoreCase(obj01.getName());
                return (obj01.getName()).compareToIgnoreCase(obj02.getName());
            }
        }
    }
}
