package de.marcelhuber.mathematik.zahlentheorie;

import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class PrimzahlenSaver {

    // momentan werden Primzahlen nach einer vordefinierten 
    // Rechenzeit gespeichert 
    private String filename;
    private File file;
    private long counter;           // wir speichern die bisherige Anzahl der Primzahlen des Files
    private long testzahl;
    private boolean isPrime;
    private long primzahl;
    private long lastPrimeNumber;    // die wievielte Primzahl soll die letzte sein
    private long rechenZeitInMillis;
    private long primeNumbersPerColumn;
    private String whereAmI;
    private Path pathForFile;

    {
        lastPrimeNumber = 30;
        rechenZeitInMillis = 10_000;        // 10 s: solange wollen wir rechnen lassen, wenn sonst nichts gesagt wird
        filename = "Primzahlen.txt";
        file = new File(filename);
        primeNumbersPerColumn = 50;        // 50 Primzahlen pro Zeile
        whereAmI = new File("").getAbsolutePath();
        System.out.println(whereAmI);
        PressEnter.toContinue();
    }

    public static void main(String[] args) {
        PrimzahlenSaver dummy = new PrimzahlenSaver();
        if (dummy.getFile().exists()) {
            System.out.println("Die Datei " + dummy.getFilename()
                    + " enthält momentan die ersten "
                    + dummy.calculateLastPrimeNumber()
                    + " Primzahlen!");
        }
//        System.out.println("Wollen Sie in den nächsten "
//                + dummy.getRechenZeitInMillis() / 1_000.0 + " "
//                + "Sekunden weitere (neue) Primzahlen berechnen lassen?");
//        dummy.goCalculatePrimes();
        System.out.print("Wieviele Sekunden soll ich weiterrechnen? Ihre Eingabe: ");
        long rechenSekunden; // = 20 * 60_000;
        rechenSekunden = ReadInput.readLongWithExceptionHandling();
        rechenSekunden *= 1_000;
        System.out.println("Wollen Sie in den nächsten " + rechenSekunden / 1000.0 + " "
                + "Sekunden weitere (neue) Primzahlen berechnen lassen?\n"
                + "Dann drücken Sie nun Enter!");
        PressEnter.toContinue();
        dummy.goCalculatePrimes(rechenSekunden);
    }

    private long calculateLastPrimeNumber() {
        lastPrimeNumber = 0;
        if (!file.exists()) {
            return 0;
        }
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLong()) {
                ++lastPrimeNumber;
                testzahl = scanner.nextLong();
            }
            scanner.close();
        } catch (IOException ioEx) {
            System.err.println(ioEx);
            ioEx.printStackTrace();
        }
        return lastPrimeNumber;
    }

    private void goCalculatePrimes() {
        goCalculatePrimes(rechenZeitInMillis);
    }

    private void goCalculatePrimes(long rechenZeitInMillis) {
        FileWriter fw;
        boolean fileUpdated = true;
//        while (counter < lastPrimeNumber) {
        long endeRechenzeit = System.currentTimeMillis() + rechenZeitInMillis;
        while (System.currentTimeMillis() < endeRechenzeit) {
            try {
                if (!file.exists()) {
                    fw = new FileWriter(file);
                } else {
                    if (fileUpdated) {
                        calculateLastPrimeNumber();
                    }
                    ++testzahl;
                    isPrime = checkPrime(testzahl);
                    if (isPrime) {
                        ++counter;
                        ++lastPrimeNumber;
                        fw = new FileWriter(file, true);
                        if (lastPrimeNumber % primeNumbersPerColumn == 0) {
                            fw.write(String.format("%1$d%n", testzahl));
                        } else {
                            fw.write(String.format("%1$d ", testzahl));
                        }
                        fw.flush();
                        fw.close();
//                        PressEnter.toContinue();
                    } else {
                        fileUpdated = false;
                    }
                }
            } catch (IOException ioEx) {
                System.err.println(ioEx);
                ioEx.printStackTrace();
            }
        }
        System.out.println("Die Datei " + file + " enthält nun die ersten "
                + lastPrimeNumber + " Primzahlen!");
    }

    private boolean checkPrime(long testzahl) {
        boolean returnBoolean = true;
        if (testzahl < 2) {
            return false;
        }
        if (testzahl == 2) {
            return true;
        }
        // jetzt behandeln wir den Fall testzahl > 2
        try {
//            Marker.marker();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLong()) {
                primzahl = scanner.nextLong();
//                System.out.println("testzahl: " + testzahl + " | primzahl: " + (long) primzahl);
//                PressEnter.toContinue();
                if (testzahl % (long) primzahl == 0) {
                    scanner.close();
                    returnBoolean = false;
                    return returnBoolean;
                }
            }
        } catch (IOException ioEx) {
            System.err.println(ioEx);
            ioEx.printStackTrace();
        }
        return returnBoolean;
    }

    public String getFilename() {
        return filename;
    }

    public long getRechenZeitInMillis() {
        return rechenZeitInMillis;
    }

    public File getFile() {
        return file;
    }
}
