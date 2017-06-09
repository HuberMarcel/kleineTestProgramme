package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.io.*;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Marcel Huber
 */
public class ExceptionsDemo01 {

    public static void main(String[] args) {
        new ExceptionsDemo01().go();
    }

    private void go() {
        try {
            rethrow();
        } catch (SQLException ex) {
            Logger.getLogger(ExceptionsDemo01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExceptionsDemo01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    static public void rethrow() throws SQLException, IOException {
    public void rethrow() throws SQLException, IOException {
        try {
            System.out.printf("Hallo!%n");
        } catch (Exception ex) {
            try {
                System.out.println("Exception: " + ex);
                couldThrowAnException();
            } finally {

            }
        }
    }

//    static private void couldThrowAnException() throws IOException, FileNotFoundException {
    private void couldThrowAnException() throws IOException, FileNotFoundException {
        // Hier darf keine checked-Exception "oberhalb" von SQLExc. oder IOExc. stehen
        System.out.println("Hello from couldThrowAnException!");
    }

}
