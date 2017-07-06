package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Marcel Huber
 */
public class CreateALotOfDirecories {

    private Path path;
    private Path file;
    private boolean deleteAllYouHaveCreatedHere;

    {
        deleteAllYouHaveCreatedHere = true;
    }

    public static void main(String[] args) {
        CreateALotOfDirecories dummy = new CreateALotOfDirecories();
        dummy.go();
    }

    private void go() {
        path = Paths.get("TestOrdner01/TestOrdner02/", "..", "TestOrdner03");
        file = Paths.get(path.toString(), "TestTextFile.txt");
        try {
            Files.createDirectories(path);
            if (!file.toFile().exists()) {
                Files.createFile(file);
            }
            // nur leere Ordner können gelöscht werden, bspw. übernächste Zeile alleine einkommentieren
//            Files.delete(file);
//            Files.delete(path);
//            Files.delete(path.getParent());
        } catch (IOException ioEx) {
            System.err.println(ioEx);
            ioEx.printStackTrace();
        } finally {
            deleteEverythingYouHaveCreatedHere();
        }
    }

    private void deleteEverythingYouHaveCreatedHere() {
        // nur leere Ordner können gelöscht werden, bspw. übernächste Zeile alleine einkommentieren
        if (deleteAllYouHaveCreatedHere) {
            try {
                Files.deleteIfExists(file);
                Files.deleteIfExists(path);
                System.out.println(Paths.get(path.getParent().toString() + "/TestOrdner02"));
                Files.deleteIfExists(Paths.get(path.getParent().toString() + "/TestOrdner02"));
                System.out.println(path.getParent().getParent());
//                PressEnter.toContinue();
                Files.deleteIfExists(path.getParent().getParent().getParent());
            } catch (IOException ioEx) {
                System.err.println(ioEx);
                ioEx.printStackTrace();
            }
        }
    }
}
