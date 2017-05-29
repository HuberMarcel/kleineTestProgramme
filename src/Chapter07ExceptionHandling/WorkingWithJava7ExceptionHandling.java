package Chapter07ExceptionHandling;

import de.marcelhuber.systemtools.*;
import java.io.*;
import java.nio.file.*;
import java.util.logging.*;
import jdk.jfr.events.*;

/**
 *
 * @author Marcel Huber
 */
public class WorkingWithJava7ExceptionHandling {

    public static void main(String[] args) {
        new WorkingWithJava7ExceptionHandling().go();
    }

    private void go() {
        System.out.println("Multicatch:");
        System.out.println("try {...} catch (SQL Exception) {...} catch {IOException} {...}");
        Path pathFile = Paths.get("myTestFile.txt");
        System.out.println("myTestFile.txt existiert? " + Files.exists(pathFile));
        if (!(Files.exists(pathFile))) {
            try {
                Files.createFile(pathFile);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWithJava7ExceptionHandling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("myTestFile.txt existiert? " + Files.exists(pathFile));
        File file = new File(pathFile.toString());
        // geht so nicht!!
//        FileWriter fw;
//        try {
//            fw = new FileWriter(pathFile.getFileName().toString());
//            fw.write("Hallo");
//        } catch (IOException ex) {
//            System.out.println("Exception:" + ex);
//        } finally {
//            try {
//                fw.close();
//            } catch (IOException ex) {
//                Logger.getLogger(WorkingWithJava7ExceptionHandling.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        FileWriter fw;
        try {
            fw = new FileWriter(pathFile.getFileName().toString());
            fw.write("Hallo Textdatei-Welt!");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Exception:" + ex);
        }
        System.out.print("Datei wieder löschen? (1 für ja!) - Ihre Wahl: ");
        int dateiloeschen = new ReadInput().readInt();
        if (dateiloeschen == 1) {
            try {
                Files.deleteIfExists(pathFile);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWithJava7ExceptionHandling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Files.exists(file.toPath())) {
            try {
                FileReader fr = new FileReader(file);
                char[] charactersOfFile = new char[20]; // einfach mal 2 etc. testen
                fr.read(charactersOfFile);
                for (char charOfFile : charactersOfFile) {
                    System.out.print(charOfFile);
                }
                fr.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WorkingWithJava7ExceptionHandling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("IOException...");
            }
        }
    }
}
