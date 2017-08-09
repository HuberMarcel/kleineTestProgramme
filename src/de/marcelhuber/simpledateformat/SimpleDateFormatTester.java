package de.marcelhuber.simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Marcel Huber letzte Änderung: 09.08.2017
 */
public class SimpleDateFormatTester {

    public static void main(String[] args) {
        SimpleDateFormatTester dummyObject = new SimpleDateFormatTester();
        dummyObject.go01();
    }

    private void go01() {
        Date date = new Date();
        // wichtig: die String-Anteile werden in ' ' eingeschlossen
        SimpleDateFormat sdf = new SimpleDateFormat("'Der heutige Tag:\n'"
                + "dd'. 'MMMM'. 'yyyy', und wir haben 'hh' Uhr 'mm', 'ss"
                + "' Sekunden und 'SS' Millisekunden!'"
                , Locale.GERMANY);
        System.out.println(sdf.format(date));
    }
}
