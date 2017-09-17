package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class Suitcase {

    private int id;

    public Suitcase(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Suitcase a = new Suitcase(1);
        Suitcase b = new Suitcase(1);
        Suitcase c = b;
        String result = "-";
        if (a == b) {
            result += "1";
        }
        if (b == c) {
            result += "2";
        }
        b = c;
        if (a.equals(b)) {
            result += "3";
        }
        if (b.equals(c)) {
            result += "4";
        }
        System.out.println(result);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Suitcase) obj).id == this.id;
    }
}
