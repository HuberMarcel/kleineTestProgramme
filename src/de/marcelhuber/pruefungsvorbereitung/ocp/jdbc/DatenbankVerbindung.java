package de.marcelhuber.pruefungsvorbereitung.ocp.jdbc;

//import com.mysql.jdbc.Driver;
import de.marcelhuber.systemtools.PressEnter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class DatenbankVerbindung {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private Connection bekommeVerbindung() {
        String host = "localhost";
        String user = "root";
        String pass = "drow";
        String datenBank = "test";

        String url = "jdbc:mysql://" + host + "/" + datenBank;
        System.out.println("Verbindung:");
        System.out.println(url);

        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println(ex);
            System.exit(0);
        }

        System.out.println(connection);
        return connection;
    }

    private void zeigeVerbindungsElemente() {
        System.out.println(System.getProperties().getProperty("java.class.path"));
        System.out.println("");
        System.out.println("Verfügbare Treiber: ");
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement()
                    .getClass()
                    .getName());
        }
    }

    // diese Methode dient nur zu akademischen Zwecken 
    // --> Praxis ab Java 7: try with resources
    private void schliesseVerbindung() {

        try {
            connection.close();
        } catch (SQLException ex) {
        }

        System.out.println("\nVerbindung beendet!");
    }

    public static void main(String[] args) {
        new DatenbankVerbindung().goDemo();
        new DatenbankVerbindung().go();
    }

    private void goDemo() {
        zeigeVerbindungsElemente();
        bekommeVerbindung();
        schliesseVerbindung();
    }

    private void go() {
        zeigeVerbindungsElemente();
        try (Connection verbindung = bekommeVerbindung()) {
            erstelleStatement();
            select();
            System.out.println(zeilenZaehler() + " Datensätze!");
            // START: Einen neuen Datensatz anlegen/einfügen
//            String einfuegeSQL1 = "INSERT INTO `kontakt` (`anrede`, `vorname`, "
//                    + "`nachname`,`strasse`,`stadt`,`plz`,`telefon`) "
//                    + "VALUES ('Herr','Pascal','Huber','Eur. Str. xyz','TR','54292'"
//                    + ",'0651 - xyzfghrts')";
//            int zaehler = statement.executeUpdate(einfuegeSQL1);
            String einfuegeSQL = "INSERT INTO `kontakt` (`anrede`, `vorname`) "
                    + "VALUES ('Mr.','Universum')";
            int zaehler = statement.executeUpdate(einfuegeSQL);
            System.out.println(zaehler + " Datensätze eingefügt!");
            // END:   Einen neuen Datensatz anlegen/einfügen
            // START: Den letzten Datensatz löschen --- hier extra etwas unnötig kompliziert
            select(); // neues ResultSet
            int letzterDatensatz = zeilenZaehler();
            for (int counter = 0; counter < letzterDatensatz; counter++) {
                resultSet.next();
            }
            System.out.println("ID des letzten Datensatzes: " + resultSet.getString(1));
            int lastID = Integer.valueOf(resultSet.getString(1));
            System.out.println("Löschen? ... Enter für Bestätigung!");
            String deleteSQL = "DELETE FROM `kontakt` WHERE `uid`='" + lastID + "'";
            System.out.println("deleteSQL sieht wie folgt aus:");
            System.out.println(deleteSQL);
            PressEnter.toContinue();
            System.out.println(statement.executeUpdate(deleteSQL) + " Datensatz / Datensätze gelöscht!");
            // END:   Den letzten Datensatz löschen
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    private void erstelleStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.exit(0);
        }
        System.out.println("\nStatement erstellt");
        System.out.println(statement);
    }

    private void select() {
        String sql = "SELECT * FROM `test`.`kontakt`";

        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
            System.exit(0);
        }

        System.out.println("\nStatement.executeQuery mit " + sql + " ausgeführt!");
        System.out.println(resultSet);
    }

    private int zeilenZaehler() {
        int zeilenZahl = 0;
        try {
            resultSet.last();
            zeilenZahl = resultSet.getRow();
            resultSet.beforeFirst();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.exit(0);
        }
        return zeilenZahl;
    }
}
