package de.marcelhuber.externeprogrammestarten;

import de.marcelhuber.systemtools.Marker;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class ExterneProgrammeStarten {

    public static void main(String[] args) {
        ExterneProgrammeStarten dummyObject = new ExterneProgrammeStarten();
        dummyObject.go01();
    }

    private void go01() {
//        Path root = Paths.get("\\");
//        System.out.println("Die Wurzel ist: " + root);
//        try (
//                DirectoryStream<Path> dirStream = Files.newDirectoryStream(root)) {
//            for (Path path : dirStream) {
//                System.out.println(path.getFileName());
//            }
//        } catch (IOException ex) {
//            System.err.println(ex);
//            ex.printStackTrace();
//        }
        Path rootC = Paths.get("c:\\");
        showFilesInFolder(rootC);
        Marker.marker('_');
        Marker.marker('_');
        Path notepadppPath = Paths.get("c:\\Program Files\\Notepad++");
        showFilesInFolder(notepadppPath);
        Marker.marker('_');
        Marker.marker('_');
        Runtime runtime = Runtime.getRuntime();
//        String cmd = rootC.relativize(notepadppPath).toString()
//                + "\\notepad++.exe";
        String cmd = notepadppPath.toString() + "\\notepad++.exe";
        System.out.println(cmd);
        try {
            File notepadFile = new File(cmd);
            System.out.println("Existiert der File " + notepadFile + "?");
            System.out.println(notepadFile.exists());
            Process process = runtime.exec(cmd);
            process.waitFor();
            // nachdem Notepad++ beendet wurde, wird auch das Java-Programm
            // beendet
            System.out.println(("Ende des Programms, weil Notepad++ beendet "
                    + "wurde!").toUpperCase());
            System.exit(0);
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

    private void showFilesInFolder(Path p) {
        System.out.println("Die Wurzel ist: " + p);
        try (
                DirectoryStream<Path> dirStreamC = Files.newDirectoryStream(p)) {
            for (Path path : dirStreamC) {
                System.out.println(path.getFileName());
            }
        } catch (IOException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

}
