package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;
// Hinweis: Lösung des Quizz ist falsch, denn longValue() gibt einen
//          long-Wert zurück, nicht einen Long

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class Convert {

    public static void main(String[] args) {
        Long xl = new Long(456L);
        long x01 = Long.valueOf("123");
        Long x02 = Long.valueOf("123");
        long x03 = xl.longValue();
        Long x04 = xl.longValue();
        long x05 = Long.parseLong("456");
        Long x06 = Long.parseLong("456");
        System.out.println(x01);
        System.out.println(x02);
        System.out.println(x03);
        System.out.println(x04);
        System.out.println(x05);
        System.out.println(x06);
    }
}
