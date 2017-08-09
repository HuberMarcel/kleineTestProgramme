package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

import de.marcelhuber.systemtools.Marker;
import java.util.TreeSet;

/**
 *
 * @author Marcel Huber; letzte Änderung: 09.08.2017
 */
public class MitgliedsVerwalterMitComparator {

    public static void main(String[] args) {
        MitgliedsVerwalterMitComparator dummyObject
                = new MitgliedsVerwalterMitComparator();
        dummyObject.go01();
    }

    private void go01() {
        Mitglied marcel = new Mitglied("Huber", "Marcel", 1990);
        Mitglied sascha = new Mitglied("Huber", "Sascha", 1988);
        Mitglied pascal = new Mitglied("Huber", "Pascal", 1992);
        Mitglied opa = new Mitglied("Huber", "Nikolaus", 1992);
        Mitglied mama = new Mitglied("Huber", "Gisela", 1964);
        Mitglied papa = new Mitglied("Huber", "Herbert", 1972);
        Mitglied opa02 = new Mitglied("Huber", "Nikolaus", 1992);
        Mitglied opa03 = new Mitglied("Huber", "Nikki", 1972);
        Mitglied mamaNeu = new Mitglied("Huber", "Gisela", 1964);
        Mitglied onkelHeinz = new Mitglied("Beck", "Heinz", 1964);
        //
        TreeSet<Mitglied> mitglieder = new TreeSet<>(new MitgliedComparator<Mitglied>());
        //
        System.out.println("Mama:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(mama));
        System.out.println("Pascal:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(pascal));
        System.out.println("Marcel:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(marcel));
        System.out.println("Sascha:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(sascha));
        System.out.println("Papa:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(papa));
        System.out.println("Mama:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(mama));
        System.out.println("Opa:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(opa));
        System.out.println("Opa02:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(opa02));
        System.out.println("Opa03:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(opa03));
        System.out.println("MamaNeu:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(mamaNeu));
        System.out.println("onkelHeinz:");
        System.out.println("Hinzufügen hat funktioniert? " + mitglieder.add(onkelHeinz));
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Sie sehen nun die Ausgabe der Mitglieder in der "
                + "umgekehrten Reihenfolge des Eintritts in den Club:");
        for (Mitglied mitglied : mitglieder) {
            System.out.println(mitglied);
        }
    }
}
