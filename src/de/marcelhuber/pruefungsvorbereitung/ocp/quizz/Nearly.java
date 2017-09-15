package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Marcel Huber; 15.09.2017
 */
public class Nearly {

    String value;

    Nearly(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object n) {
        if (n instanceof Nearly) {
            if (value.charAt(0) == ((Nearly) n).value.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Nearly n1 = new Nearly("aaa");
        Nearly n2 = new Nearly("aaa");
        String s = "-";
        if (n1.equals(n2)) {
            s += "1";
        }
        if (n1 == n2) {
            s += 2;
        }
        Set<Nearly> set = new HashSet<>();
        set.add(n1);
        set.add(n2);
        System.out.println(s + " " + set.size());
    }
}
