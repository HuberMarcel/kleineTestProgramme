package de.marcelhuber.SystemTools;

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
    
    public static double readDouble() {
        try {
            return Double.parseDouble(readString());
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }
    
    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException ex) {
            return 0;
        }
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
