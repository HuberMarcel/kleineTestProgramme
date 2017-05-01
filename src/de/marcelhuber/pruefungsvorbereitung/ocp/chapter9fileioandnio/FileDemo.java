package de.marcelhuber.pruefungsvorbereitung.ocp.chapter9fileioandnio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.File;
//import java.io.IOException;

/**
 *
 * @author Marcel Huber
 */
public class FileDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new FileDemo().go();
    }

    private void go() {
        try {                                                  // warning: exceptions possible
            boolean newFileExists = false;
            File file = new File // it's only an object
                    ("neueDatei.txt");
            System.out.println(file.exists());                 // look for a real file
            newFileExists = file.createNewFile();              // maybe create a file!
            System.out.println(newFileExists);                 // already there?
            System.out.println(file.exists());                 // look again
            int sec = 4;
            FileWriter fw = new FileWriter(file);
            fw.write("howdy\nfolks\n");
            fw.close();
            System.out.println(file.getName()+" wird gelöscht in "+sec+" Sekunden:");
            for (int i = 0; i < sec; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FileDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println((i+1) + ". Sekunde");
            }
            file.delete();
        } catch (IOException e) {
        }
    }
}
