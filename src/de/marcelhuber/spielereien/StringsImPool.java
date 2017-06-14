package de.marcelhuber.spielereien;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber
 */
public class StringsImPool {

    public static void main(String[] args) {
        String meinVorname = "Marcel";
        String meinNachname = "Huber";
        System.out.println("\"Marcel\" == meinVorname:           "
                + ("Marcel" == meinVorname));
        System.out.println("\"Marcel\" == meinNachname:          "
                + ("Huber" == meinNachname));
        String nochmalMeinVorname = "Marcel";
        String nochmalMeinNachname = "Huber";
        System.out.println("\"Marcel\" == nochmalMeinVorname:    "
                + ("Marcel" == nochmalMeinVorname));
        System.out.println("meinVorname == nochmalMeinVorname: "
                + (meinVorname == nochmalMeinVorname));
        System.out.println("\"Huber\" == nochmalMeinNachname:    "
                + ("Huber" == nochmalMeinNachname));
        Marker.marker();
        Marker.marker();
        System.out.println("\"Marcel\" == meinVorname:           "
                + ("Marcel" == meinVorname));
        System.out.println("\"Marcel\" == meinNachname:          "
                + ("Huber" == meinNachname));
        nochmalMeinVorname = new String("Marcel");
        nochmalMeinNachname = new String("Huber");
        System.out.println("\"Marcel\" == nochmalMeinVorname:    "
                + ("Marcel" == nochmalMeinVorname));
        System.out.println("meinVorname == nochmalMeinVorname: "
                + (meinVorname == nochmalMeinVorname));
        System.out.println("\"Huber\" == nochmalMeinNachname:    "
                + ("Huber" == nochmalMeinNachname));
        Marker.marker();
        Marker.marker();
        System.out.println("\"Marcel\" == meinVorname:           "
                + ("Marcel" == meinVorname));
        nochmalMeinVorname = new String("Marcel").intern();
        // die folgenden beiden auskommentierten Zeilen führen vor den 3 Markern des 
        // Programmes zu false, wenn man sie einkommentiert
        // anscheinend ist der intern()-Befehl nur während einer Instanziierung
        // sinnvoll
//        nochmalMeinVorname = new String("Marcel");
//        nochmalMeinVorname.intern();
        System.out.println("\"Marcel\" == nochmalMeinVorname:    "
                + ("Marcel" == nochmalMeinVorname));
        Marker.marker();
        System.out.println("");
        Marker.marker();
        // dieses neue String-Objekt Marcel wird nicht in den Pool geschmissen,
        // sondern durch intern() wird nochmalMeinVorname eine Referenz auf "Marcel"
        // Vorsicht: "Marcel" == new String("Marcel")
        // Ein String-Objekt "Marcel" gibt es nun genau einmal im Pool
        System.out.println("Nach nochmalMeinVorname.intern() ==> ");
        System.out.println("\"Marcel\" == nochmalmeinVorname:    "
                + ("Marcel" == nochmalMeinVorname));
        String wiederMarcel = new String("Marcel").intern();
        // wiederMarcel verweist auf das Gleiche Objekt wie nochmalMeinVorname,
        // da es schon ein "StringObjekt "Marcel" im Pool gibt" 
        System.out.println(wiederMarcel == nochmalMeinVorname);
        System.out.println(wiederMarcel);
        Marker.marker();
        Marker.marker();
        Marker.marker();
        String sascha = new String("Sascha").intern();
        String sascha2 = "Sascha";
        System.out.println("sascha == sascha2?: " + (sascha == sascha2));
    }
}
