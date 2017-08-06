// Buch Seite 505ff
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Marcel Huber
 */
public class PathAndPaths {

    public static void main(String[] args) {
        PathAndPaths dummyObject = new PathAndPaths();
        dummyObject.go01();
    }

    private void go01() {
        Path pathLong = Paths.get("Home/Dir/Music/BedOfRoses.mp3");
        Path pathShort = Paths.get("Home/Dir/");
        System.out.println("Wie findet man " + pathLong + " ausgehend von "
                + pathShort + "?");
        System.out.println("So (pathShort.relativize(pathLong)):");
        System.out.println(pathShort.relativize(pathLong));
        System.out.println("Wie findet man " + pathShort + " ausgehend von "
                + pathLong + "?");
        System.out.println("So (pathLong.relativize(pathShort)):");
        System.out.println(pathLong.relativize(pathShort));
    }
}
