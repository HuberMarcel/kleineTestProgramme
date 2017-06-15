package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Marcel Huber
 */
public class CalendarAndDateAndDateFormatAbSeite420BisSeite426 {

    Calendar calendarDeDE;
    Calendar calendarEnUS;
    Calendar calendarEnGB;
    Date d;
    DateFormat dfDeDELONGLONGWithTime;
    DateFormat dfDeDELONGMEDIUMWithTime;
    DateFormat dfDeDELONGSHORTWithTime;
    DateFormat dfDeDELONG;
    DateFormat dfEnUSLONG;
    DateFormat dfEnGBLONG;
    DateFormat dfDeDEMEDIUM;
    DateFormat dfEnUSMEDIUM;
    DateFormat dfEnGBMEDIUM;
    DateFormat dfDeDESHORT;
    DateFormat dfEnUSSHORT;
    DateFormat dfEnGBSHORT;
    Locale locDeDE;
    Locale locEnUS;
    Locale locEnGB;

    public static void main(String[] args) {
        new CalendarAndDateAndDateFormatAbSeite420BisSeite426().go();
    }

    private void go() {
        locDeDE = new Locale("de", "DE");
        locEnUS = new Locale("en", "US");
        locEnGB = new Locale("en", "GB");
        d = new Date();        // aktuelle Zeit in Millisekunden seit 1.1.1970
        calendarDeDE = Calendar.getInstance(locDeDE);
        calendarEnUS = Calendar.getInstance(locEnUS);
        calendarEnGB = Calendar.getInstance(locEnGB);
        byte firstDayOfWeekDeDE = (byte) calendarDeDE.getFirstDayOfWeek();
        byte firstDayOfWeekEnUS = (byte) calendarEnUS.getFirstDayOfWeek();
        byte firstDayOfWeekEnGB = (byte) calendarEnGB.getFirstDayOfWeek();
        System.out.print("deDE - FirstDayOfWeek: " + firstDayOfWeekDeDE);
        System.out.println(" - das ist ein "
                + findOutTheDayName(firstDayOfWeekDeDE).toUpperCase());
        System.out.print("enUS - FirstDayOfWeek: " + firstDayOfWeekEnUS);
        System.out.println(" - das ist ein "
                + findOutTheDayName(firstDayOfWeekEnUS).toUpperCase());
        System.out.print("enGB - FirstDayOfWeek: " + firstDayOfWeekEnGB);
        System.out.println(" - das ist ein "
                + findOutTheDayName(firstDayOfWeekEnGB).toUpperCase());
        System.out.println("Hinweis: Lokale Systemkonfiguration: "
                + Locale.getDefault());
        System.out.println("\n\n");
        System.out.println("Die folgende Schleife listet die Wochentage mit der "
                + "zugehörigen Nummer aus - ungültige Nummern\nliefern einen leeren "
                + "String!");
        for (byte k = 0; k < 9; k++) {
            System.out.println("k = " + k + " : " + findOutTheDayName(k).toUpperCase());
        }
        System.out.println("\n\n");
        dfDeDELONG = DateFormat.getDateInstance(DateFormat.LONG, locDeDE);
        dfDeDEMEDIUM = DateFormat.getDateInstance(DateFormat.MEDIUM, locDeDE);
        dfDeDESHORT = DateFormat.getDateInstance(DateFormat.SHORT, locDeDE);
        dfEnUSLONG = DateFormat.getDateInstance(DateFormat.LONG, locEnUS);
        dfEnUSMEDIUM = DateFormat.getDateInstance(DateFormat.MEDIUM, locEnUS);
        dfEnUSSHORT = DateFormat.getDateInstance(DateFormat.SHORT, locEnUS);
        dfEnGBLONG = DateFormat.getDateInstance(DateFormat.LONG, locEnGB);
        dfEnGBMEDIUM = DateFormat.getDateInstance(DateFormat.MEDIUM, locEnGB);
        dfEnGBSHORT = DateFormat.getDateInstance(DateFormat.SHORT, locEnGB);
        System.out.println("Ausgabe des Date-Objektes in mehreren Versionen:");
        System.out.println("deDE, LONG:                  " + dfDeDELONG.format(d));
        System.out.println("deDE, MEDIUM:                " + dfDeDEMEDIUM.format(d));
        System.out.println("deDE, SHORT:                 " + dfDeDESHORT.format(d));
        System.out.println("enUS, LONG:                  " + dfEnUSLONG.format(d));
        System.out.println("enUS, MEDIUM:                " + dfEnUSMEDIUM.format(d));
        System.out.println("enUS, SHORT:                 " + dfEnUSSHORT.format(d));
        System.out.println("enGB, LONG:                  " + dfEnGBLONG.format(d));
        System.out.println("enGB, MEDIUm:                " + dfEnGBMEDIUM.format(d));
        System.out.println("enGB, SHORT:                 " + dfEnGBSHORT.format(d));
        System.out.println("\n\n");
        //// ZUSATZ, für Prüfung IRRELEVANT
        System.out.println("Zusatz:".toUpperCase());
        dfDeDELONGLONGWithTime
                = DateFormat.getDateTimeInstance(
                        DateFormat.LONG, DateFormat.LONG, locDeDE);
        System.out.println("deDE, LONG-LONG with Time:   "
                + dfDeDELONGLONGWithTime.format(d));
        //
        dfDeDELONGMEDIUMWithTime
                = DateFormat.getDateTimeInstance(
                        DateFormat.LONG, DateFormat.MEDIUM, locDeDE);
        System.out.println("deDE, LONG-MEDIUM with Time: "
                + dfDeDELONGMEDIUMWithTime.format(d));
        //
        dfDeDELONGSHORTWithTime
                = DateFormat.getDateTimeInstance(
                        DateFormat.LONG, DateFormat.SHORT, locDeDE);
        System.out.println("deDE, LONG-SHORT with Time:  "
                + dfDeDELONGSHORTWithTime.format(d));
    }

    private String findOutTheDayName(byte dayNameAsByte) {
        String dayName;
        switch (dayNameAsByte) {
            case Calendar.MONDAY:
                dayName = "Montag";
                break;
            case Calendar.TUESDAY:
                dayName = "Dienstag";
                break;
            case Calendar.WEDNESDAY:
                dayName = "Mittwoch";
                break;
            case Calendar.THURSDAY:
                dayName = "Donnerstag";
                break;
            case Calendar.FRIDAY:
                dayName = "Freitag";
                break;
            case Calendar.SATURDAY:
                dayName = "Samstag";
                break;
            case Calendar.SUNDAY:
                dayName = "Sonntag";
                break;
            default:
                dayName = "";
                break;
        }
        return dayName;
    }
}
