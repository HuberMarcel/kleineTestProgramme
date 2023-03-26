package de.marcelhuber.lottozahlen;
// -Xms4096M

import java.util.*;

/**
 *
 * @author huber
 */
public class Lotto6Aus49Neu {

  private final Random zahlGenerator;
  private final List<Integer> lottoUrne;

  private final int[] ziehung;
  private int[][] ziehungen;

  public int[][] getZiehungen() {
    return ziehungen;
  }

//  public static void main(String[] args) {
//    new Lotto6Aus49Neu().starteZiehungen(1);
//  }
  public Lotto6Aus49Neu() {
    zahlGenerator = new Random();
    ziehung = new int[6];
    lottoUrne = new ArrayList<>();
  }

  private void initialisiereZiehungen(int anzahlZiehungen) {
    ziehungen = new int[anzahlZiehungen][6];
  }

  public void starteZiehungen(int anzahlZiehungen) {
    initialisiereZiehungen(anzahlZiehungen);
    for (int i = 0; i < anzahlZiehungen; i++) {
      ziehe6Zahlen();
      sortiereDieGezogenenZahlen();
      System.arraycopy(ziehung, 0, ziehungen[i], 0, ziehung.length);
    }
  }

  private void sortiereDieGezogenenZahlen() {
    Arrays.sort(ziehung);
  }

  private void ziehe6Zahlen() {
    initialisiereLottoUrne();
    int gezogenePosition;
    int[] gezogenePositionen = new int[6];
    for (int i = 0; i < 6; i++) {
      gezogenePosition = ziehePositionFuerZahlNr(zahlGenerator, i);
      gezogenePositionen[i] = gezogenePosition;
    }
    for (int i = 0; i < 6; i++) {
//      ziehung[i] = lottoUrne.remove(gezogenePositionen[i]);
      ziehung[i] = removeFrom(lottoUrne, gezogenePositionen[i]);
    }
  }

  static int removeFrom(List<Integer> list, int index) {
    // expected: iterate over all the elements of the list
    if (list.get(index) != null) {
      // actual: remaining elements are shifted, so the one immediately following will be skipped
      return list.remove(index); // Noncompliant
    }
    return -1;

  }

  private void initialisiereLottoUrne() {
    lottoUrne.clear();
    for (int i = 0; i < 49; i++) {
      lottoUrne.add(i + 1);
    }
  }

  private int ziehePositionFuerZahlNr(Random zahlGenerator, int i) {
    int gezogenePosition;
    gezogenePosition = zahlGenerator.nextInt(49 - i);
    return gezogenePosition;
  }

}
