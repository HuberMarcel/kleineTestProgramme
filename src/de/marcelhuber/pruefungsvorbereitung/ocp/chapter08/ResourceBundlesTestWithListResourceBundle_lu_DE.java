package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Pause;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author Marcel Huber
 */
public class ResourceBundlesTestWithListResourceBundle_lu_DE extends ListResourceBundle {

    Object[][] objectAs2DArray;

    @Override
    protected Object[][] getContents() {
        objectAs2DArray = new Object[][]{
            {"bitte", "wann ech glift"},
            {"danke", "merci"},
            {"Auf Wiedersehen, und Danke für das dumme Gespräch!",
                "Äddi a merci fir d'domm Gespréich!"},};
        return objectAs2DArray;
    }

    public static void main(String[] args) {
        new ResourceBundlesTestWithListResourceBundle_lu_DE().goTestThisResourceBundle();
    }

    private void goTestThisResourceBundle() {
        //        String whereAmI = new File("").getAbsolutePath();
//        System.out.println("In welchem Verzeichnis bin ich? Deine Antwort:");
//        System.out.println(whereAmI);
//        Path whereAmIPath = Paths.get(whereAmI);
//        System.out.println(whereAmIPath);
        Locale loc = new Locale("lu", "DE");
        loc = new Locale("lu");
//        ResourceBundle rb
//                = ResourceBundle.getBundle("resourcebundles.resources.Labels", loc);
        ResourceBundle rb
                = ResourceBundle.getBundle(
                        "de.marcelhuber.pruefungsvorbereitung.ocp.chapter08.ResourceBundlesTestWithListResourceBundle_lu_DE", loc); // 
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
