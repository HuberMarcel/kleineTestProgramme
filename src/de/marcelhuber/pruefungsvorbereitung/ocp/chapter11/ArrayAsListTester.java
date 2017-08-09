package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

import de.marcelhuber.systemtools.PressEnter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class ArrayAsListTester {

    public static void main(String[] args) {
        ArrayAsListTester dummyObject = new ArrayAsListTester();
        dummyObject.go01();
        dummyObject.go02();
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
    }
}
