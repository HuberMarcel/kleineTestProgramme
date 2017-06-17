package de.marcelhuber.systemtools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Marcel Huber
 */
public class ReadInput {

    public static boolean readBoolean() {
        try {
            return Boolean.parseBoolean(readString());
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean readBooleanWithExceptionHandling() {
        boolean returnWert = false;
        try {
            returnWert = Boolean.parseBoolean(readString());
            System.out.println("Boolean.parseBoolean(readString()) gibt nur bei "
                    + "String \"true\".toLowerCase()==true auch true zurück: " 
                    + returnWert);
        } catch (Throwable throwObj) {
            System.out.println("Fehleingabe, neuer Versuch; Fehlermeldung: " + throwObj);
            readBooleanWithExceptionHandling();
        }
        return returnWert;
    }

    public static double readDouble() {
        try {
            return Double.parseDouble(readString());
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }

    public static double readDoubleWithExceptionHandling() {
        double returnWert = 0.0;
        try {
            returnWert = Double.parseDouble(readString());
        } catch (Throwable throwObj) {
            System.out.println("Fehleingabe, neuer Versuch; Fehlermeldung: " + throwObj);
            readDoubleWithExceptionHandling();
        }
        return returnWert;
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static int readIntWithExceptionHandling() {
        int returnWert = 0;
        try {
            returnWert = Integer.parseInt(readString());
        } catch (Throwable throwObj) {
            System.out.println("Fehleingabe, neuer Versuch; Fehlermeldung: " + throwObj);
            returnWert = readIntWithExceptionHandling();
        }
        return returnWert;
    }

    public static long readLong() {
        try {
            return Long.parseLong(readString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static long readLongWithExceptionHandling() {
        long returnWert = 0;
        try {
            returnWert = Long.parseLong(readString());
        } catch (Throwable throwObj) {
            System.out.println("Fehleingabe, neuer Versuch; Fehlermeldung: " + throwObj);
            returnWert = readLongWithExceptionHandling();
        }
        return returnWert;
    }

    public static String readString() {
        // Mit Kanonen auf Spatzen schiessen
//        return new Scanner(System.in).nextLine();

        // effizienter:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException ex) {
            return "";
        }
    }
}
