package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import static java.lang.System.out;

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class _ {

    public static void main(String[] args) {
        args = new String[3];
        args[0] = "-";
        args[1] = "A";
        args[2] = ".";
//        String $=null;
        String $ = "";
        for (int x = 0; ++x < args.length; x++) {
            $ += args[x];
            out.println($);
        }
    }
}
