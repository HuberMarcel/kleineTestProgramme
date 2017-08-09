package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

import de.marcelhuber.systemtools.Marker;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Marcel Huber; letzte Änderung: 09.08.2017
 */
public class ArrayAsListTester {

    public static void main(String[] args) {
        ArrayAsListTester dummyObject = new ArrayAsListTester();
        dummyObject.go01();
        dummyObject.go02();
        dummyObject.go03();
    }

    private void go01() {
        // Vorsicht: Bei int[] zahlenArray = new int[8]
        //           kommt bei Arrays.asList eine Liste raus,
        //           deren erstes Element auf das int[]-Objekt / Feld verweist
        Integer[] zahlenArray = new Integer[8];
        zahlenArray[0] = 1;
        zahlenArray[1] = 1;
        for (int k = 2; k < zahlenArray.length; k++) {
            zahlenArray[k] = zahlenArray[k - 1] + zahlenArray[k - 2];
        }
        List zahlenArrayAsList = Arrays.asList(zahlenArray);
        System.out.println(Arrays.toString(zahlenArray));
        System.out.println(zahlenArrayAsList);
        // add ist bei der Liste nicht erlaubt
        // remove dann ebenso wenig
//        zahlenArrayAsList.add((Integer)zahlenArrayAsList.get(zahlenArrayAsList.size() - 1)
//                + (Integer)zahlenArrayAsList.get(zahlenArrayAsList.size() - 2));
//        zahlenArrayAsList.add(34);
        zahlenArrayAsList.set(3, 34);
        System.out.println(zahlenArrayAsList);
        System.out.println(Arrays.toString(zahlenArray));
        System.out.println("");
        System.out.println("");
        System.out.println(("Fazit: Das Array und die backed-Collection-Liste "
                + "werden immer simultan gehändelt.\nDie Liste kann in ihrer "
                + "Größe nicht verändert werden, da Arrays dies nicht "
                + "zulassen!!").toUpperCase());
    }

    private void go02() {
        int[] zahlenArray = new int[8];
        zahlenArray[0] = 1;
        zahlenArray[1] = 1;
        for (int k = 2; k < zahlenArray.length; k++) {
            zahlenArray[k] = zahlenArray[k - 1] + zahlenArray[k - 2];
        }
        List zahlenArrayAsList = Arrays.asList(zahlenArray);
        System.out.println(Arrays.toString(zahlenArray));
        System.out.println(zahlenArrayAsList);
        Marker.marker('_');
        Marker.marker('_');
        for (int k : (int[]) zahlenArrayAsList.get(0)) {
            System.out.println(k);
        }
    }

    private void go03() {
        Integer[] test = new Integer[]{1, 34, 1, 3, 2, 5, 13, 8, 21};
        List testAsList = Arrays.asList(test);
//        test = new Integer[]{2, 13, 5};      // Zeile 01
//        testAsList = Arrays.asList(test);
        System.out.println(testAsList);
        // wir sortieren mal von groß zu klein...
        testAsList.sort(
                new Comparator<Integer>() {
            @Override
            public int compare(Integer int01, Integer int02) {
                return -int01.compareTo(int02);
            }
        });
        System.out.println(testAsList);
        System.out.println(Arrays.toString(test));
        System.out.println(
                "Fazit: Das Objekt, für welche die asList()-Methode "
                + "aufgerufen wurde, ist \nentscheidend,  " + "nicht  ".toUpperCase()
                + "die Referenzvariable!");
        // Zeile 01 einkommentieren, dann sieht man das noch besser!!
    }
}
