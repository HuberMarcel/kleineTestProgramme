package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Marcel Huber; 19.09.2017
 */
public class Reader {

    public void read(Path p, Charset s) {
        BufferedReader r = null;
//        try (BufferedReader r = Files.newBufferedReader(p, s)) {
        try {
            r = Files.newBufferedReader(p, s);
            try {
                r.read();
            } catch (IOException ioEx) {
                r.readLine();
            }

        } catch (IOException ioEx) {
            try {
                if (!(r == null)) {
                    r.close();
                }
            } catch (IOException ex) {
            }
        } finally {
            try {
                if (!(r == null)) {
                    r.close();
                }
            } catch (IOException ex) {
            }
        }
    }
}
