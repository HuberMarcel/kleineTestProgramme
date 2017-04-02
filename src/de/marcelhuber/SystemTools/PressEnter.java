package de.marcelhuber.SystemTools;

import java.io.*;

/**
 *
 * @author Marcel Huber
 */
public class PressEnter {

//    static public boolean boolFlag;

    static public void ToContinue() {
        System.out.print("Press Enter to continue! ");
        try {
            System.in.read();
//            System.out.print((char) System.in.read());
        } catch (IOException e) {
            System.out.println("Fehlerhafte eingabe!");
            e.printStackTrace();
        }
    }
}
