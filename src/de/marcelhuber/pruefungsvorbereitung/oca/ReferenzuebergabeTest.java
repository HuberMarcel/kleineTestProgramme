package de.marcelhuber.pruefungsvorbereitung.oca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class ReferenzuebergabeTest {

    public static void main(String[] args) {
        List<Integer> list01 = new ArrayList<>();
        List<Integer> list02 = new ArrayList<>();
        ReferenzuebergabeTest dummyObject = new ReferenzuebergabeTest();
        dummyObject.go01(list01, list02);
        System.out.println("list01: " + list01);
        System.out.println("list02: " + list02);
    }

    private void go01(List<Integer> x, List<Integer> y) {
        x.add(new Integer("12"));
        y = x;
    }
}
