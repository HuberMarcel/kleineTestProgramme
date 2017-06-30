package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Pause;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author Marcel Huber
 */
public class ResourceBundles {
    // wichtig: die properties-Files werden quasi wie Java Quellcode gehändelt
    //          sie müssen also kompiliert werden etc., jedenfalls, wenn ich das
    //          richtig verstanden habe. Hier findet man sie nun in dem Package
    //          resourcebundles, und dann im Unterordner resources 
    //          (letzterer wird dann über resourcebundles.resources angesprochen
    
    public static void main(String[] args) {
//        String whereAmI = new File("").getAbsolutePath();
//        System.out.println("In welchem Verzeichnis bin ich? Deine Antwort:");
//        System.out.println(whereAmI);
//        Path whereAmIPath = Paths.get(whereAmI);
//        System.out.println(whereAmIPath);
        Locale loc = new Locale("lu");
        ResourceBundle rb
                = ResourceBundle.getBundle("resourcebundles.resources.Labels", loc);
        try {
            System.out.println("Wir fangen die \"MissingResourceException\" hier"
                    + "ab - allerdings Ausgabe mit System.err!");
            System.out.println("");
            System.out.println("Wie sagt man \"bitte\" in Luxemburg?");
            System.out.println(rb.getString("bitte"));
            System.out.println("");
            System.out.println("Okay, Danke, oder wie man in Luxemburg sagt:");
            System.out.println(rb.getString("danke"));
            System.out.println("Bzw. sagen wir es mal so, wie es in Luxemburg "
                    + "gang und gäbe ist:");
            System.out.println(rb.getString("Auf Wiedersehen und Danke für das "
                    + "dumme Gespräch"));
        } catch (MissingResourceException rbExc) {
            System.err.println(rbExc);
            rbExc.printStackTrace();
        }
        Pause.breakInMillis(500);
        System.out.println("Nochmal, aber nun richtig:");
        System.out.println("Wie sagt man \"bitte\" in Luxemburg?");
        System.out.println(rb.getString("bitte"));
        System.out.println("");
        System.out.println("Okay, Danke, oder wie man in Luxemburg sagt:");
        System.out.println(rb.getString("danke"));
        System.out.println("Bzw. sagen wir es mal so, wie es in Luxemburg "
                + "gang und gäbe ist:");
        System.out.println(rb.getString("Auf Wiedersehen, und Danke für das "
                + "dumme Gespräch!"));
    }
}
