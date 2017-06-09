package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.io.*;
import java.sql.*;

/**
 *
 * @author Marcel Huber
 */
public class ExceptionsDemo03 {

    public static void main(String[] args) {
        try {
            new ExceptionsDemo03().go();
        } catch (SQLException | IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }

    private void go() throws SQLException, IOException {
        try {
            couldThrowAnException();
        } catch (Exception e) {
            throw e;
        }
    }

    private void couldThrowAnException() throws IOException, FileNotFoundException, SQLException {
    }
}
