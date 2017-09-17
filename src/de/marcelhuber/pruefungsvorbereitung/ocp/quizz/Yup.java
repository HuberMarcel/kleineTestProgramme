package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class Yup {

    static private int x = 4;
    private final int y = 12;

    public int getX() {
        return x;
    }

    public void setX(int x) {
//        Yup.X = x;
        this.x = x;
    }

    public static void main(String[] args) {
        new Yup().setX(50);
        System.out.println("x: " + x);
    }
}
