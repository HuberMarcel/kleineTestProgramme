package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber; 18.09.2017
 */
public class BasicFileAttributesDemo {

    public static void main(String[] args) {
        Path path = Paths.get("src", "de", "marcelhuber", "pruefungsvorbereitung",
                "ocp", "quizz", "Babble.java");
        System.out.println(Files.exists(path));
        try {
            BasicFileAttributes basic
                    = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("create:         " + basic.creationTime());
            System.out.println("access:         " + basic.lastAccessTime());
            System.out.println("modified:       " + basic.lastModifiedTime());
            System.out.println("isDirectory?:   " + basic.isDirectory());
            System.out.println("isRegularFile?: " + basic.isRegularFile());
        } catch (IOException ex) {
        }
    }
}
