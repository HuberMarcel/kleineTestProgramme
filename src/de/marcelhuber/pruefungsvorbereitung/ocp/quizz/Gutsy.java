package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class Gutsy {

    public static void main(String[] args) {
        Gutsy dummyObject = new Gutsy();
        try {
            dummyObject.go01();
        } catch (IOException ex) {
            Logger.getLogger(Gutsy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void go01() throws IOException {
        String row;
        try {
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((row = br.readLine()) != null) {
                System.out.println(row);
            }
        } catch (IOException ioEx) {
            System.out.println("got io error");
        } finally {
            System.out.println("done ");
        }
    }
}
