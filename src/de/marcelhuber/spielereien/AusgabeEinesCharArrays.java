package de.marcelhuber.spielereien;

/**
 *
 * @author Marcel Huber
 */
public class AusgabeEinesCharArrays {

    public static void main(String[] args) {
        int counter = 0;
        for (char ch = 'A'; ch < 'x'; ch++) {
            ++counter;
            if (counter % 10 != 0) {
                System.out.print(ch + " | ");
            } else {
                System.out.println(ch);
            }
        }
        System.out.println("");
    }
}
