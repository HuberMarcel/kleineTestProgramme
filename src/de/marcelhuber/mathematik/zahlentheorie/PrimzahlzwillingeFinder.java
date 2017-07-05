package de.marcelhuber.mathematik.zahlentheorie;

import de.marcelhuber.systemtools.PressEnter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class PrimzahlzwillingeFinder {

    private String filename;
    private String filenamePrimzahlzwillinge;
    private File file;
    private File filePrimzahlzwillinge;
    private Scanner scanner;
    private long[] primzahlZwillinge;
    private long prime;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private long lastPrimeNumberInPrimeNumberTwins;

    {
        primzahlZwillinge = new long[2];
        filename = "Primzahlen.txt";
        filenamePrimzahlzwillinge = "Primzahlzwillinge.txt";
        file = new File(filename);
        filePrimzahlzwillinge = new File(filenamePrimzahlzwillinge);
    }

    public static void main(String[] args) {
        PrimzahlzwillingeFinder dummy = new PrimzahlzwillingeFinder();
        dummy.findLastPrimeNumberInPrimeNumberTwins();
        System.out.println("Letzte Primzahl der Primzahlzwllinge: "
                + dummy.getLastPrimeNumberInPrimeNumberTwins());
        PressEnter.toContinue();
        dummy.goFindePrimzahlzwillinge();
    }

    private long findLastPrimeNumberInPrimeNumberTwins() {
        if (!filePrimzahlzwillinge.exists()) {
            return lastPrimeNumberInPrimeNumberTwins = 0;
        }
        try {
            Scanner scannerLocal = new Scanner(filePrimzahlzwillinge);
            scannerLocal.useDelimiter("(\\[|, |\\]\n?)");
            // Delimiter mit regulaerem Ausdruck
            System.out.println(scannerLocal.delimiter());
            while (scannerLocal.hasNext()) {
                if (scannerLocal.hasNextLong()) {
                    lastPrimeNumberInPrimeNumberTwins = scannerLocal.nextLong();
                } else {
//                    System.out.println(scannerLocal.next());
                    scannerLocal.next();
                }
            }
            scannerLocal.close();
        } catch (IOException iOEx) {
            System.err.println(iOEx);
            iOEx.printStackTrace();
        }
        return lastPrimeNumberInPrimeNumberTwins;
    }

    private void goFindePrimzahlzwillinge() {
        if (!file.exists()) {
            // falls die Primzahlendatei nicht gefunden wird / nicht existiert --> Abbruch!
            return;
        }
        try {
            if (!filePrimzahlzwillinge.exists()) {
                filePrimzahlzwillinge.createNewFile();
            }
            // jetzt existiert filePrimzahlzwillinge.txt, ggf. ist diese Datei leer
            lastPrimeNumberInPrimeNumberTwins = findLastPrimeNumberInPrimeNumberTwins();
            scanner = new Scanner(file);
            while (scanner.hasNextLong()) {
//            fileWriter = new FileWriter(filePrimzahlzwillinge);
                fileWriter = new FileWriter(filePrimzahlzwillinge, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                primzahlZwillinge[0] = scanner.nextLong();
                if (scanner.hasNextLong()) {
                    prime = scanner.nextLong();
                    if ((prime > lastPrimeNumberInPrimeNumberTwins) && (prime == primzahlZwillinge[0] + 2)) {
                        primzahlZwillinge[1] = prime;
                        System.out.println(Arrays.toString(primzahlZwillinge));
                        bufferedWriter.write(String.format(Arrays.toString(primzahlZwillinge) + "\n"));
                        bufferedWriter.flush();
//                        PressEnter.toContinue();
                    }
                }
                bufferedWriter.close();
            }
            scanner.close();
        } catch (IOException ioEx) {
            System.err.println(ioEx);
            ioEx.printStackTrace();
        }
    }

    public long getLastPrimeNumberInPrimeNumberTwins() {
        return lastPrimeNumberInPrimeNumberTwins;
    }
}
