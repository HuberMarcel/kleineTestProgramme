package de.marcelhuber.pruefungsvorbereitung.oca.selftestseite159;

/**
 *
 * @author Marcel Huber
 */
// auskommentiert ist das, wie es im Buch steht/
// auch mal die Zeilen Z! auskommentieren

//public class Tenor extends Singer {
//
//    @Override
//    public String sing() {
//        return "fa";
//    }
//
//    public static void main(String[] args) {
//        Tenor t = new Tenor();
//        Singer s = new Tenor();
//        System.out.println(t.sing() + " " + s.sing());
//    }
//}
//
//class Singer {
//
//    public String sing() {
//        return "la";
//    }
//}


public class Tenor extends Singer {

    public static String sing() {                              // Z1
        return "fa";                                           // Z1
    }                                                          // Z1

    public static void main(String[] args) {
        Tenor t = new Tenor();
        Singer s = new Tenor();
        System.out.println(t.sing() + " " + s.sing());
    }
}

class Singer {

    public static String sing() {
        return "la";
    }
}
