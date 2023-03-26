package de.marcelhuber.lottozahlen.lottoaufrufe;

import de.marcelhuber.lottozahlen.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author huber
 */
public class LottoAufrufNeu {

  private static final int ANZAHL_LOTTOZIEHUNGEN = 21;
  private static final int BLOCK_GROESSE = 3;
  private static int[][] ziehungen;

  public static void main(String[] args) {
    System.out.print("Wir simulieren " + ANZAHL_LOTTOZIEHUNGEN + " Lottoziehungen. ");
    System.out.println("Das Ergebnis wird in " + BLOCK_GROESSE + "er-Blöcken dargestellt.");
    Lotto6Aus49Neu lotto6Aus49Neu = new Lotto6Aus49Neu();
    lotto6Aus49Neu.starteZiehungen(ANZAHL_LOTTOZIEHUNGEN);
    ziehungen = lotto6Aus49Neu.getZiehungen();
//    System.out.println(Arrays.deepToString(ziehungen));
    showLottoZiehungenAndWriteIntoAFile();
  }

  private static void showLottoZiehungenAndWriteIntoAFile() {
    try {
      String fileSeparator = FileSystems.getDefault().getSeparator();
      String filename = "C:" + fileSeparator + "Users" + fileSeparator + "huber" + fileSeparator;
//      filename += "Desktop" + fileSeparator + "NetBeans IDE" + fileSeparator;
      filename += "Lotto6Aus49" + fileSeparator;
      filename += "lotto6Aus49__";
      filename += new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss").format(new Date());
      filename += ".txt";
      File myFile = new File(filename);
      if (myFile.createNewFile()) {
        System.out.println("File created: " + myFile.getAbsolutePath());
      } else {
        System.out.println("File already exists.");
      }
      FileWriter myFileWriter = new FileWriter(myFile);
      String s = printErgebnisse();
      myFileWriter.write(s);
      myFileWriter.close();
      System.out.print(s);
    } catch (IOException e) {
      System.err.print("An error occurred.");
      e.printStackTrace();
    }
  }

  private static String printErgebnisse() {
    int count = 0;
    String s = "";
    for (int[] ziehung : ziehungen) {
      s += (count % BLOCK_GROESSE == 0 ? "Block Nr.: " + (1 + count / BLOCK_GROESSE) + "\n" : "");
      s += Arrays.toString(ziehung) + "\n";
      s += (++count % BLOCK_GROESSE == 0 ? "\n" : "");
    }
    final Random zahlGenerator = new Random();
    s += "\nVorschlag: Block Nr. " + (1 + zahlGenerator.nextInt(7));
    return s;
  }
}
