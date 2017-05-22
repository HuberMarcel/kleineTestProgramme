package de.marcelhuber.pruefungsvorbereitung.ocp;

import de.marcelhuber.systemtools.*;
import java.io.*;
import java.nio.file.*;

/**
 *
 * @author Marcel Huber
 */
public class ChangeMyFolderName {

    private String laufwerksBuchstabe = "E:";   // bei mir Laufwerksbuchstabe des USB-Sticks
    private String pfad = "\\DAA_JAVA(OCPJP)\\JAVA_OCPJP\\Projekte(Programmierung)\\00__OCP__Ab03042017";  // mein Pfad auf dem USB-Stick
    private Path dir = Paths.get(laufwerksBuchstabe, pfad);
    // Achtung: dir hat kein / am Ende!!
    private String ursprungsOrdnername = "TESTBEISPIEL";  // diesen Ordner mal in dir anlegen 
    private String zielOrdnername = "TesteDasMal";   //
    private Path pathQuelle;
    private Path pathZiel;

    public static void main(String[] args) {
        new ChangeMyFolderName().go();
    }

    private void go() {
        FileSystem fs = FileSystems.getDefault();
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir)) {
            for (Path path : dirStream) {
                ursprungsOrdnername = path.getFileName().toString();
//                System.out.println(path.getFileName());
                if (containsString(ursprungsOrdnername, "OCA")) {
//                    System.out.println("Ursprung: " + ursprungsOrdnername);
                    zielOrdnername = ursprungsOrdnername.substring(0, ursprungsOrdnername.indexOf("OCA"));
                    zielOrdnername += "OCP";
                    zielOrdnername += ursprungsOrdnername.substring(5, ursprungsOrdnername.length());
//                    System.out.println("Ziel:     " + zielOrdnername);
                    pathQuelle = Paths.get(dir + "/" + ursprungsOrdnername);
                    pathZiel = Paths.get(dir + "/" + zielOrdnername);
//                    System.out.println(pathQuelle);
//                    System.out.println(pathZiel);
//                    Marker.marker();
                    changeFolderName(pathQuelle, pathZiel);
                }
            }
        } catch (IOException ex) {
        }
        // zum Testen
//        pathQuelle = fs.getPath(dir + "/" + ursprungsOrdnername);
//        System.out.println(dir);
//        System.out.println(pathQuelle);
//        pathZiel = Paths.get(dir + "/" + zielOrdnername);
//        changeFolderName(pathQuelle, pathZiel);
//        changeFolderName(pathZiel, pathQuelle);
        //
    }

    private boolean containsString(String s, String subString) {
        return s.indexOf(subString) > -1 ? true : false;
    }

    private void changeFolderName(Path pathQuelle, Path pathZiel) {
        System.out.println(Files.exists(pathQuelle));
        if (Files.exists(pathQuelle)) {
            try {
                System.out.println("Wollen Sie die folgende Änderung durchführen? "
                        + "Bestätigung durch Enter!");
                System.out.println("Quelle: " + pathQuelle.toString());
                System.out.println("Ziel:   " + pathZiel.toString());
                PressEnter.toContinue();
                Files.move(pathQuelle, pathZiel, StandardCopyOption.ATOMIC_MOVE);
            } catch (IOException ex) {
                System.out.println("Umbenennen von " + pathQuelle + " fehlgeschlagen!");
            }
        }
    }
}
