package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.util.Arrays;

/**
 *
 * @author Marcel Huber; 14.09.2017
 */
public class Zippy {

    static String[] x = {"Hallo", "Welt"};
    static int[][] a = {{1, 2}, {3}};
    static Object c = new long[4];
    static Object[] d = x;
    static Object y = x;
    static Object z = x[0];
    public static void main(String[] args) {
        System.out.println(d);
        System.out.println(y);
        System.out.println(z);
        System.out.println(Arrays.toString(d));
    }
}
