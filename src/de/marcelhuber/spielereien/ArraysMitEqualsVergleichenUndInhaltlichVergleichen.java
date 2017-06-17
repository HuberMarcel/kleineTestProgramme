package de.marcelhuber.spielereien;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.Pause;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class ArraysMitEqualsVergleichenUndInhaltlichVergleichen {

    boolean allWithKlassengleichheit;
    static byte counterVergleicheFelderInhaltlich;
    Long[] arrayOriginalLong = new Long[]{1L, 2L, 4L, 7L, 15L};
    Integer[] arrayOriginalInteger = {1, 2, 4, 7, 15};
    long[] longArray = new long[]{1, 1, 2, 3, 5, 8, 11, 128, 200};
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 11, 128, (byte) 200};  // nicht identisch zu intArray wegen Verlust beim Cast
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 11, 128, 200};           // identisch zu intArray
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 011, 128, 200};            // nicht identisch zu intArray, da 011 = 1*8+1=9
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 013, 128, 200};              // identisch zu intArray, da 013 = 1*8+3=11
    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 0xB, 128, 200};                // identisch zu intArray, da 0xB = 11
    int[] intArray = new int[]{1, 1, 2, 3, 5, 8, 11, 128, 200};

    public static void main(String[] args) {
//        System.out.println("Inter-Objekt instanceof Number? :"
//                + (new Integer(10) instanceof Number));
//        System.out.println(Vater.class.isAssignableFrom(Sohn.class));    // true: Vater ist Superklasse von Sohn
//        System.out.println(Sohn.class.isAssignableFrom(Vater.class));    // false: Sohn ist keine Superklasse von Vater
//        System.out.println(Sohn.class.isAssignableFrom(Sohn.class));     // true: Sohn ist Superklasse von sich selbst
        Vater vaterHans = new Vater("Hans");
        Vater vaterPeter = new Vater("Peter");
        System.out.println("vaterHans.equals(vaterPeter)?: "
                + (vaterHans.equals(vaterPeter)));
        System.out.println("");
        vaterPeter.setName("Hans");
        System.out.println("Jetzt heißt vaterPeter auch \"Hans\"!");
        System.out.println("vaterHans.equals(vaterPeter)?: "
                + (vaterHans.equals(vaterPeter)));
        System.out.println("");
        System.out.println("");
        Sohn sohnHans = new Sohn("xyz");
        System.out.println("vaterHans.equals(sohnHans)?: "
                + (vaterHans.equals(sohnHans)));
        System.out.println("\n");
        System.out.println("Jetzt setzen wir den Namen des Sohns auch auf Hans!");
        sohnHans.setName("Hans");
        System.out.println("vaterHans.equals(sohnHans)?: "
                + (vaterHans.equals(sohnHans)));
        System.out.println("\n\n");
        new ArraysMitEqualsVergleichenUndInhaltlichVergleichen().compareTheTwoArrays();
    }

    private void compareTheTwoArrays() {
        if (arrayOriginalLong.equals(arrayOriginalInteger)) {
            System.out.println("Die beiden Long- und Integer-Felder sind "
                    + "identisch!".toUpperCase());
        } else {
            System.out.println("Die beiden Long- und Integer Felder sind "
                    + "verschieden!".toUpperCase());
        }
        if (arrayOriginalLong.equals(arrayOriginalInteger)) {
            System.out.println("Die beiden long- und int-Felder sind "
                    + "identisch!".toUpperCase());
        } else {
            System.out.println("Die beiden long- und int-Felder sind "
                    + "verschieden!".toUpperCase());
        }
        System.out.println("\n\n");
        System.out.println("Fazit:".toUpperCase());
        System.out.println("Bei equals wird auch der Typ des Arrays beim "
                + "Vergleich benutzt!");
        boolean inhaltsVergleichWrapperFelder
                = vergleicheFelderInhaltlich(arrayOriginalInteger, arrayOriginalLong);
        System.out.println("Ist das Integer- mit dem Long-Feld inhaltlich "
                + "gleich? Unsere Berechnung sagt: " + inhaltsVergleichWrapperFelder);
        System.out.println("\n\n");
        boolean inhaltsVergleichElementarerDatentypFelder
                = vergleicheFelderInhaltlich(intArray, longArray);
        System.out.println("Ist das int- mit dem long-Feld inhaltlich "
                + "gleich? Unsere Berechnung sagt: " + inhaltsVergleichElementarerDatentypFelder);
        System.out.println("\n\n");
        inhaltsVergleichElementarerDatentypFelder
                = vergleicheFelderInhaltlich(intArray, longArrayManipulated);
        System.out.println("Ist das int- mit dem manipulated long-Feld inhaltlich "
                + "gleich? Unsere Berechnung sagt: " + inhaltsVergleichElementarerDatentypFelder);
        System.out.println("\n\n");
        System.out.println("\n\n");
        Vater[] vaterFeld01 = {new Vater("Hans"), new Vater("peter"), new Sohn("Marcel")};
        Vater[] vaterFeld02 = {new Vater("Hans"), new Sohn("Xavier"), new Vater("Marcel")};
        vaterFeld02[1].setName("peter");
        allWithKlassengleichheit = true;
        allWithKlassengleichheit = false;
        for (int k = 0; k < vaterFeld01.length; k++) {
            vaterFeld01[k].setEqualsNurMitKlassengleichheit(allWithKlassengleichheit);
            vaterFeld02[k].setEqualsNurMitKlassengleichheit(allWithKlassengleichheit);
        }
        boolean inhaltsVergleichVaterSohnFelder
                = vergleicheFelderInhaltlich(vaterFeld01, vaterFeld02);
        System.out.println("vaterFeld01 inhaltlich gleich mit vaterFeld02?: "
                + inhaltsVergleichVaterSohnFelder);
    }

    private boolean vergleicheFelderInhaltlich(Object feld01, Object feld02) {
        Marker.marker();
        Marker.marker();
        System.out.println(++counterVergleicheFelderInhaltlich + ". Aufruf der "
                + "Vergleichsmethode!");
        System.out.println("");
        boolean nurWrapper = true;
        boolean returnWert = true;
        if (feld01 == feld02) {
            returnWert = true;
            return returnWert;
        }
//        System.out.println(feld01.getClass().getName());
        int[] intFeld = new int[0];
        long[] longFeld = new long[0];
        if (feld01.getClass().getName().equals("[I")) {
            intFeld = (int[]) feld01;
        }
        if (feld02.getClass().getName().equals("[J")) {
            longFeld = (long[]) feld02;
        }
        if (intFeld.length > 0 || longFeld.length > 0) {
            nurWrapper = false;
        }
        if (!nurWrapper) {
            System.out.println("1. Array: " + Arrays.toString(intFeld));
            System.out.println("2. Array: " + Arrays.toString(longFeld));
            for (int k = 0; k < intFeld.length; k++) {
                if (!(intFeld[k] == longFeld[k])) {
                    System.out.println("");
                    Marker.marker();
                    System.out.println("Hinweis:".toUpperCase());
                    System.out.println("An der Stelle " + k + " hat das erste Feld "
                            + "den Wert " + intFeld[k] + ", das zweite aber "
                            + longFeld[k] + "!");
                    Marker.marker();
                    System.out.println("");
                    System.out.println("");
                    returnWert = false;
                    return returnWert;
                }
            }
        } else {
            Object[] feld1 = (Object[]) feld01;
            Object[] feld2 = (Object[]) feld02;
            if (feld1.length != feld2.length) {
                returnWert = false;
                return returnWert;
            }
            for (int k = 0; k < feld1.length; k++) {
                if (!((feld1[k].getClass().isAssignableFrom(feld2[k].getClass()))
                        || (feld2[k].getClass().isAssignableFrom(feld1[k].getClass())))) {
                    Pause.breakInMillis(2000);
                    System.err.println("Klassenunterschied an Stelle: " + k);
                    returnWert = false;
                    return returnWert;
                } else {
                    if (!(feld1[k].equals(feld2[k]))) {
                        Pause.breakInMillis(2000);
                        System.err.println("Wertunterschied an Stelle: " + k);
                        System.out.println(("[Hinweis: Kann auch passieren, wenn bei "
                                + "der equals()-Methode equalsNurMitKlassengleichheit=true "
                                + "gesetzt wurde!]").toUpperCase());
                        returnWert = false;
                        return returnWert;
                    }
                }
//            System.out.println(Number.class.isAssignableFrom(Integer.class));   // Ist Number Superklasse von Integer?
//                System.out.println(Number.class.isInstance(new Integer("1")));        // kann man ein Integer-Obj. in ein Number casten
            }
        }
        return returnWert;
    }
}

class Vater {

    private boolean equalsNurMitKlassengleichheit;

    private String name = "";

    public Vater() {
    }

    public Vater(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // equals mit der Option ohne Unterklassenobjekte!!
    public boolean equals(Object o) {
        boolean returnWert = false;
        if (equalsNurMitKlassengleichheit) {
//            System.out.println("1.: " + this.getClass().isAssignableFrom(o.getClass()));
//            System.out.println("2.: " + o.getClass().isAssignableFrom(this.getClass()));
            if (!((this.getClass().isAssignableFrom(o.getClass()))
                    && o.getClass().isAssignableFrom(this.getClass()))) {
                returnWert = false;
                return returnWert;
            }
        }
//        System.out.println("Vatername: " + ((Vater) o).getName());
//        System.out.println("this.name: " + getName());
        if (!(equalsNurMitKlassengleichheit)) {
            if (!(o instanceof Vater)) {
                returnWert = false;
                return returnWert;
            }
        }
        if ((((Vater) o).getName()).equals(this.getName())) {
            returnWert = true;
            return returnWert;
        }
        return returnWert;
    }

//    // equals "Standardweg"
//    public boolean equals(Object o) {
//        boolean returnWert = false;
//        if (!(o instanceof Vater)) {
//            returnWert = false;
//            return returnWert;
//        }
////        System.out.println("Vatername: " + ((Vater) o).getName());
////        System.out.println("this.name: " + getName());
//        if ((((Vater) o).getName()).equals(this.getName())) {
//            returnWert = true;
//            return returnWert;
//        }
//        return returnWert;
//    }
    public boolean isEqualsNurMitKlassengleichheit() {
        return equalsNurMitKlassengleichheit;
    }

    public void setEqualsNurMitKlassengleichheit(boolean equalsNurMitKlassengleichheit) {
        this.equalsNurMitKlassengleichheit = equalsNurMitKlassengleichheit;
    }
}

class Sohn extends Vater {

    public Sohn(String name) {
        setName(name);
    }
}
