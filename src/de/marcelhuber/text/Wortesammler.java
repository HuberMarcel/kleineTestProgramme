package de.marcelhuber.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.floor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Marcel Huber; Datum: 24.12.2017
 */
public class Wortesammler {

    private BufferedReader br;
    private BufferedWriter bw;
    private FileReader fr;
    private FileWriter fw;
    private Path path;
    private Path pathToWrite;
    private File file;
    private File fileToWrite;
    private String zeile;
    private String[] wortArray;
    private Set<String> woerterBuch;
    private List<String> woerterListe = new ArrayList<>();
    private int[] wortAuswahlZahl = new int[13];
    static private int wdh;
    private boolean helpSout = false; // Schalter für Testausgaben

    public static void main(String[] args) {
        Wortesammler dummyObject = new Wortesammler();
        wdh = 100;
        for (int k = 0; k < wdh; k++) {
            dummyObject.go01();
        }
    }

    private void go01() {
        woerterBuch = new HashSet<>();
        path = Paths.get("H:/MyMonero(Marcel)/test.txt");
        pathToWrite = Paths.get("H:/MyMonero(Marcel)/filledFile.txt");
//        System.out.println(path);
        file = new File(path.toString());
        fileToWrite = new File(pathToWrite.toString());
        try {
            fr = new FileReader(file);
            fw = new FileWriter(fileToWrite, true);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        br = new BufferedReader(fr);
        bw = new BufferedWriter(fw);
        try {
            while ((zeile = br.readLine()) != null) {
                wortArray = zeile.split(" ");
                for (String wort : wortArray) {
                    woerterBuch.add(wort);
                }
            }
            woerterListe.clear();
            for (String wort : woerterBuch) {
                woerterListe.add(wort);
            }
//            System.out.println(woerterListe);
//            System.out.println(woerterListe.size());
            int number = woerterListe.size();
            boolean doppeltZahl = false;
            while (!doppeltZahl) {
                boolean akzeptiert;
                for (int k = 0; k < wortAuswahlZahl.length; k++) {
                    akzeptiert = false;
                    wortAuswahlZahl[k] = (int) floor(Math.random() * number);
                    if (!doppeltZahl) {
                        for (int m = 0; m < k; m++) {
                            if (wortAuswahlZahl[m] == wortAuswahlZahl[k]) {
                                doppeltZahl = true;
                                if (helpSout) {
                                    System.out.println("");
                                    System.out.println("Doppeltes Wort an den Stellen "
                                            + "" + (m + 1) + " und " + (k + 1) + ": "
                                            + woerterListe.get(wortAuswahlZahl[k]));
//                                System.out.println("");
                                }
                            }
                        }
                    } else {
                        while (!akzeptiert) {
                            akzeptiert = true;
                            for (int m = 0; m < k; m++) {
                                if (wortAuswahlZahl[m] == wortAuswahlZahl[k]) {
                                    akzeptiert = false;
                                    wortAuswahlZahl[k] = (int) floor(Math.random() * number);
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(wortAuswahlZahl));
            String s = "";
            for (int k = 0; k < wortAuswahlZahl.length; k++) {
                s += " " + woerterListe.get(wortAuswahlZahl[k]);
                s = s.trim();
            }
            if (helpSout) {
//            System.out.println("");
                System.out.println("Doppeltes Wort vorhanden? " + doppeltZahl);
                System.out.println("");
            }
//            System.out.println(s); // Ausgabe der Wortkette gebildet aus 13 Worten
            bw.write(s + "\n");
            bw.flush();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }
    }
}
