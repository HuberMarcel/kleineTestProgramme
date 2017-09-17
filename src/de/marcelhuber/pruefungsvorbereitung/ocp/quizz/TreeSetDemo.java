package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.TreeSet;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> stuff = new TreeSet<>();
        stuff.add(2);
        stuff.add(8);
        stuff.add(4);
        stuff.add(6);
        System.out.println(stuff.tailSet(2));
        System.out.println(stuff.tailSet(2, false));
        System.out.println(stuff.tailSet(2, true));
        System.out.println(stuff.tailSet(4, false));
        System.out.println(stuff.tailSet(4, true));
    }
}
