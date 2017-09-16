package de.marcelhuber.pruefungsvorbereitung.ocp.quizz.xcom;

import static java.lang.System.out;
import static de.marcelhuber.pruefungsvorbereitung.ocp.quizz.Stuff.*;

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class User {

    public static void main(String[] args) {
        new User().go();
    }

    void go() {
        out.println(doStuff(MY_CONSTANT));
    }
}
