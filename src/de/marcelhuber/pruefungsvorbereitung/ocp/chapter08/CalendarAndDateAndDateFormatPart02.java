// im Buch ab Seite 421
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Marker;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Marcel Huber
 */
public class CalendarAndDateAndDateFormatPart02 {

    public static void main(String[] args) {
        CalendarAndDateAndDateFormatPart02 dummyObject
                = new CalendarAndDateAndDateFormatPart02();
        dummyObject.go01();
        dummyObject.go02();
        dummyObject.go03WithLocales();
    }

    private void go01() {
        Date d01 = new Date();
        Date d02 = new Date();
        d02.setTime(d01.getTime());
        // damit sind jetzt d01 und d02 zeitpunktmässig identisch
        System.out.println("Aktuelle Zeit: " + d01);
        d02.setTime(d02.getTime() + 60 * 60 * 1000);
        System.out.println("Eine Stunde später werden wir folgende Zeitausgabe "
                + "sehen: " + d02);
    }

    private void go02() {
        Date d01 = new Date();
        Date d02 = new Date();
        d02.setTime(d01.getTime());
        d02.setTime(d02.getTime() + 60 * 60 * 1000);
        Calendar c01 = Calendar.getInstance();
        Calendar c02 = Calendar.getInstance();
        c01.setTime(d01);
        c02.setTime(d02);
        System.out.println("");
        System.out.println("Calendar c01: " + c01);
        System.out.println("Calendar c02: " + c02);
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        // wir vertauschen jetzt mithilfe der Calendar-Objekte die Rollen von 
        // d01 und d02
        System.out.println("");
        System.out.println("");
        d01 = c02.getTime();
        d02 = c01.getTime();
        System.out.println("Aktuelle Zeit mit d02 bzw. c01: " + d02);
        System.out.println("Eine Stunde später werden wir folgende Zeitausgabe "
                + "sehen (mit c02 bzw. d01): " + d01);
        System.out.println("");
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
        System.out.println("Wie sieht das morgen in einer Woche aus?");
        // erstmal wieder die Zeitpunkte ordentlich sortieren
        d01 = c01.getTime();
        d02 = c02.getTime();
        c01.add(Calendar.DAY_OF_WEEK, 8);
        System.out.println(c01.getTime());
        c02.add(Calendar.DAY_OF_WEEK, 8);
        System.out.println("Und von diesem Zeitpunkt an eine Stunde später?");
        System.out.println(c02.getTime());
    }

    private void go03WithLocales() {
        Marker.marker('_');
        Marker.marker('_');
        Locale loc = new Locale("de", "DE");
        Calendar cal = Calendar.getInstance(loc);
        System.out.println("Das de_DE-Calendar-Objekt");
        System.out.println(cal);
        Date d = cal.getTime();
        System.out.println("\nAls Date-Objekt:");
        System.out.println(d + "\n");
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, loc);
        DateFormat dfAndTime = DateFormat.getDateTimeInstance(DateFormat.SHORT,
                DateFormat.LONG, loc);
        System.out.println("Das letzte Date-Objekt formatiert zu DateInstance "
                + "mit loc:     "
                + df.format(d));
        df = DateFormat.getDateInstance(DateFormat.MEDIUM, loc);
        System.out.println("Das letzte Date-Objekt formatiert zu DateInstance "
                + "mit loc:     "
                + df.format(d));
        df = DateFormat.getDateInstance(DateFormat.LONG, loc);
        System.out.println("Das letzte Date-Objekt formatiert zu DateInstance "
                + "mit loc:     "
                + df.format(d));
        System.out.println("Das letzte Date-Objekt formatiert zu DateTimeInstance "
                + "mit loc: "
                + dfAndTime.format(d));
        dfAndTime = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, loc);
        System.out.println("Das letzte Date-Objekt formatiert zu DateTimeInstance "
                + "mit loc: "
                + dfAndTime.format(d));
    }
}
