package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcel Huber; 18.09.2017
 */
public class CalendarDemo {

    public static void main(String[] args) {
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        System.out.println(c.get(Calendar.HOUR)
                + "h:" + c.get(Calendar.MINUTE)
                + "m:" + c.get(Calendar.SECOND)
                +"s");
        d = new Date();
        c.setTimeInMillis(d.getTime());
        System.out.println(c.get(Calendar.HOUR)
                + "h:" + c.get(Calendar.MINUTE)
                + "m:" + c.get(Calendar.SECOND)
                + "s");
    }
}
