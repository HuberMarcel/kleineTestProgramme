package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.io.IOException;

/**
 *
 * @author Marcel Huber; 18.09.2017
 */
public class AnimalsWithException {

    class Lamb implements AutoCloseable {

        public void close() {
            throw new RuntimeException("a");
        }
    }

    public static void main(String[] args) throws IOException {
        new AnimalsWithException().run();
    }

    public void run() throws IOException {
        try (Lamb l = new Lamb();) {
            throw new IOException();
        } catch (Exception e) {
//            throw (Exception) e;
//          e wird in der folgenden Zeile nicht in (Exception) e gewandelt
            throw e;
        }
    }
}
