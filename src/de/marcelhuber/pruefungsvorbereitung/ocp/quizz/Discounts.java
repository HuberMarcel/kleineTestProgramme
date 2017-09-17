package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class Discounts {

    public static void main(String[] args) {
        int x = 5;
        int y = 6;
//        if (x + y > 10) {
//            if (x < y) {
//                if (x > 7) 
//                    System.out.print("a ");
//                 else 
//                    System.out.print("b ");
//            }
//            System.out.print("c ");}
//         else 
//            System.out.print("d ");
        if (x + y > 10) {
            if (x < y) {
                if (x > 7) {
                    System.out.print("a ");
                } else {
                    System.out.print("b ");
                }
                System.out.print("c ");
            } else {
                System.out.print("d ");
            }
        }
        System.out.println("");
    }
}
