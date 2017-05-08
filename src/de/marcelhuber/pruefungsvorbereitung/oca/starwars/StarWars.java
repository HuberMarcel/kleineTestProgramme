package de.marcelhuber.pruefungsvorbereitung.oca.starwars;

import de.marcelhuber.pruefungsvorbereitung.oca.DarthVadersSonLuke;

/**
 *
 * @author Marcel Huber
 */
public class StarWars {

    public static void main(String[] args) {
        new StarWars().go();
    }

    private void go() {
        DarthVadersSonLuke luke = new DarthVadersSonLuke();
        System.out.println("Luke bekam einen Schlag auf den Kopf... das letzte, "
                + "an das er sich erinnerte, ist:");
        System.out.print("\"");
        luke.ichStelleMichVor();
        System.out.print("\"");
    }
}
