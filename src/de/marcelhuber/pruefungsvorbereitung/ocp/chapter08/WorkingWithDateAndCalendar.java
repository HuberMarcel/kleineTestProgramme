package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;
// https://coderanch.com/t/581829/java/Calendar-getInstance-locale-working

import java.text.*;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Marcel Huber
 */
public class WorkingWithDateAndCalendar {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new WorkingWithDateAndCalendar().go();
    }

    private void go() {
        DateAndCalendar();
    }

    private void DateAndCalendar() {
        Date d = new Date();
        System.out.println("Date als String:     " + d);
        System.out.println("Date als String:     " + d.toString());
        Calendar c = Calendar.getInstance();
        System.out.println("Calendar als String: " + c);
//        System.out.println("Calendar als String: " + c.toString());
        Locale loc = new Locale("en", "UK");
//        loc = new Locale("de", "DE");
        c = Calendar.getInstance(loc);
        d = c.getTime();
        System.out.println("Zeit: " + d);
        loc = new Locale("de", "DE");
        c = Calendar.getInstance(loc);
        d = c.getTime();
        System.out.println("Zeit: " + d);
        c = Calendar.getInstance(Locale.GERMAN);
        d = c.getTime();
        System.out.println("Zeit: " + d);
        DateFormat df = DateFormat.getDateInstance();
        System.out.println("Datumsausgabe (mit getTime) mit Dateformat: " + df.format(d));
        loc = new Locale("de", "DE");
        loc = new Locale("en", "US");
        Calendar c2 = Calendar.getInstance(loc);
        Date d2 = c2.getTime();
        d2.setTime(d.getTime() + 360);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.MEDIUM, loc);
        System.out.println("Datumsausgabe (mit getTime) mit Dateformat: " + df2.format(d2));
        loc = new Locale("en");
        c2 = Calendar.getInstance(loc);
        System.out.println("Der erste Tag des Monats im englischen Kalender:    "
                + c2.getFirstDayOfWeek());
        System.out.println("getMinimalDaysInFirstWeek() im englischen Kalender: "
                + c2.getMinimalDaysInFirstWeek());
        loc = new Locale("de");
        c2 = Calendar.getInstance(loc);
        System.out.println("Der erste Tag des Monats im deutschen Kalender:     "
                + c2.getFirstDayOfWeek());
        System.out.println("getMinimalDaysInFirstWeek() im deutschen Kalender:  "
                + c2.getMinimalDaysInFirstWeek());
        System.out.println("Calendar.SUNDAY: " + Calendar.SUNDAY);
        System.out.println("c2.SUNDAY: " + c2.getFirstDayOfWeek() + " - Locale: " + loc);
        loc = new Locale("en", "US");
        c2 = Calendar.getInstance(loc);              // das ist notwendig, loc ist also nur ein "Einstellungs-Objekt"
        System.out.println("c2.SUNDAY: " + c2.getFirstDayOfWeek() + " - Locale: " + loc);
    }
}
