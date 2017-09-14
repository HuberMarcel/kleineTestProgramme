package de.marcelhuber.pruefungsvorbereitung.ocp;

/**
 *
 * @author Marcel Huber, 14.09.2017
 */
public class Bulbs {

    enum Turn {
        ON("bright"),
        OFF("dark");
        String name;

        Turn(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        System.out.println(Turn.ON);
    }
}
