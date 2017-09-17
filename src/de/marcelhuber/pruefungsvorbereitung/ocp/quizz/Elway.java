package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class Elway {

    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.exit(0);
//        }
        args = new String[1];
        args[0] = "" + 32;
        try {
            final int x = Integer.parseInt(args[0]);
            Elway dummyObject = new Elway();
            final int y = dummyObject.go01(x);
            System.out.println(dummyObject.go01(y));
        } catch (Exception e) {
            System.out.println("parse boo boo");
        }
    }

    private int go01(int z) {
        return z++;
    }
}
