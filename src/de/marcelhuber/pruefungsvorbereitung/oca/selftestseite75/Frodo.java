package de.marcelhuber.pruefungsvorbereitung.oca.selftestseite75;

/**
 *
 * @author Marcel Huber
 */
public class Frodo extends Hobbit {

    public static void main(String[] args) {
        int myGold = 7;
//        System.out.println(countGold(myGold, 6));
        System.out.println(new Frodo().countGold(myGold, 6));  // das geht, weil gleiches Packet
    }
}

class Hobbit {
//    static
    int countGold(int x, int y) {
        return x + y;
    }
}
