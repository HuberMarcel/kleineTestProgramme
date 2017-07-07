package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Marcel Huber
 */
public class ResolvePaths {

    private Path dir;
    private Path file;

    {
        dir = Paths.get("/home/java/");
//        dir = Paths.get("/home/java");
        file = Paths.get("models/Model.pdf");
    }

    public static void main(String[] args) {
        new ResolvePaths().go();
    }

    private void go() {
        Path result = dir.resolve(file);
        // loese den file-Path in dem Ordner des paths auf
        System.out.println("result: " + result);
        System.out.println(Paths.get(dir.toString()));
        System.out.println(Paths.get("Model.pdf"));
    }
}
