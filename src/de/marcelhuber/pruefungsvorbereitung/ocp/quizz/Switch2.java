package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 15.09.2017
 */
public class Switch2 {

    static final short x = 2;
    static final int y = 0;

    public static void main(String[] args) {
        for (int z = 0; z < 4; z++) {
            switch (z) {
                case x:
                    System.out.print("0 ");
                case x - 1:
                    System.out.print("1 ");
                    break;
                default:
                    System.out.print("def ");
                case x - 2:
                    System.out.print("2 ");
            }
        }
//        int z = Integer.MAX_VALUE;
        int z = 2;
        System.out.println("\n" + (z == x));
    }
}
