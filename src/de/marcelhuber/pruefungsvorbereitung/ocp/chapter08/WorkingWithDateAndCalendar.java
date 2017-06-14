package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

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
        c = Calendar.getInstance(loc);
        d = c.getTime();
        System.out.println("Zeit: " + d);
        loc = new Locale("de", "DE");
        c = Calendar.getInstance(loc);
        d = c.getTime();
        System.out.println("Zeit: " + d);
    }
}
