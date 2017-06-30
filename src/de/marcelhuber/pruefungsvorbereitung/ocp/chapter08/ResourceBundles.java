package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Marcel Huber
 */
public class ResourceBundles {
    public static void main(String[] args) {
        Locale loc = new Locale("lu");
        ResourceBundle rb = ResourceBundle.getBundle("Labels", loc);
        String whereAmI = new File("").getAbsolutePath();
        System.out.println(rb.getString("bitte"));
        System.out.println("bitte");
    }
}
