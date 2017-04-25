package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class KovarianteRueckgabenDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new KovarianteRueckgabenDemo().go(10, new String[]{"sdfg fdgfg ", "dkfgshf",});  // Z1
//        new KovarianteRueckgabenDemo().go();     // Z2
    }

    // Immer nur Z1 zusammen einkommentiert und dann Z2 aus oder umgekehrt    
    private void go(int i, String... args) {  // Z1
//    private void go() {     // Z2 
        System.out.println("Kovarianter Rückgabetyp: Der Rückgabetyp der überschriebenen "
                + "Methode ist ein Kind (Untertyp) der Klasse der ursprünglichen Methode!");
        System.out.println("Parents getMe() {\n return this; }");
        System.out.println("Childs getMe() {\n return this; }");
        System.out.println("Klassenhierarchie:");
        System.out.println("Parents");
        System.out.println("    Childs (extends Parents)");
        System.out.println("");
        Parents childAsParent = new Childs();
        Childs child = new Childs();
        Parents parents = new Parents();
//      Childs parentsAsChild = new Parents();    // das geht natürlich nicht
        (child.getMe()).callMyClassName();          // K: Kindklasse
        childAsParent.getMe().callMyClassName();    // K
        parents.getMe().callMyClassName();          // E: Elternklasse
    }
}
