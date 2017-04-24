package de.marcelhuber.pruefungsvorbereitung.oca;

import de.marcelhuber.mathematik.Primfaktorzerlegung;

/**
 *
 * @author Marcel Huber
 */
public class GetClassDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new GetClassDemo().go();
    }

    private void go() {
        Primfaktorzerlegung pfz = new Primfaktorzerlegung();
        System.out.println("Mit getClass bekommt man den (durch das Package "
                + "gegebenen) vollqualifizierten Namen der Klasse, welche "
                + "das Objekt erzeugt/instanziiert hat:");
        System.out.println(pfz.getClass());
        System.out.println(Primfaktorzerlegung.class);
        System.out.println(pfz.getClass() == Primfaktorzerlegung.class);
        Overwriting parent = new Overwriting();
        OverwritingSubclass child = new OverwritingSubclass();
        System.out.println("Parent-Klasse: " + parent.getClass());
        System.out.println("Child-Klasse:  " + child.getClass());
        System.out.println("Child-Klasse: " + ((Overwriting) child).getClass());
        System.out.println("Wichtig also: Es wird immer die Klasse ausgegeben, "
                + "die für die Erzeugung des Objektes verantwortlich war.\nAuch, "
                + "wenn man nach oben casted, wird die Kindklasse ausgegeben!");
        System.out.println("");
        System.out.println("child instanceof OverwritingSubclass:       "
                + (child instanceof OverwritingSubclass));
        System.out.println("child instanceof Overwriting:               "
                + (child instanceof Overwriting));
        System.out.println("(((Overwriting) child) instanceof Overwriting: "
                + (((Overwriting) child) instanceof Overwriting));
        System.out.println(Integer.MAX_VALUE);       // vom Typ int
        System.out.println(Integer.MAX_VALUE + 1);   // vom Typ int
        System.out.println(Integer.MAX_VALUE + 1L);  // vom Typ long
//        System.out.println((Integer.MAX_VALUE+1L) instanceof Long);    // geht nicht
//        System.out.println((Integer.MAX_VALUE+1L) instanceof long);    // geht nicht, da long primitiv
        System.out.println((Long) (Integer.MAX_VALUE + 1L) instanceof Long);
        System.out.println((Number) (Integer.MAX_VALUE + 1L) instanceof Long);
        System.out.println((Object) (Integer.MAX_VALUE + 1L) instanceof Long);
    }
}
