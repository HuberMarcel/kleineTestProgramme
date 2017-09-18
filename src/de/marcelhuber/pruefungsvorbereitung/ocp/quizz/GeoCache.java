package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Marcel Huber; 18.09.2017
 */
public class GeoCache {

    public static void main(String[] args) {
        String[] s = {"map", "pen", "marble", "key"};
        Othello o = new Othello();
        Arrays.sort(s, o);
        for (String s2 : s) {
            System.out.print(s2 + " ");
        }
        // Vorsicht: binarySearch OHNE Comparator
        System.out.println(Arrays.binarySearch(s, "map"));
        System.out.println(Arrays.binarySearch(s, "map", o));
        System.out.println(Arrays.binarySearch(s, "marble"));
        System.out.println(Arrays.binarySearch(s, "marble", o));
    }

    static class Othello implements Comparator<String> {

        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
}
