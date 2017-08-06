package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Marker;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber last modified: 06.08.2017
 */
public class DirectoryStreamTest {

    public static void main(String[] args) {
        DirectoryStreamTest dummyObject = new DirectoryStreamTest();
        dummyObject.go01();
    }

    private void go01() {
        Path thisDir = Paths.get("");
        try (
                DirectoryStream<Path> dirStream = Files.newDirectoryStream(thisDir)) {
            for (Path path : dirStream) {
                if (Files.isDirectory(path)) {
                    System.out.println("");
                    Marker.marker('_');
                    System.out.print("Ordner: ");
                    System.out.println(path);
//                    System.out.println(path.getFileName());
                    Marker.marker('_');
                    System.out.println("");
                } else {
                    System.out.print("Datei: ");
                    System.out.println(path.getFileName());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DirectoryStreamTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
