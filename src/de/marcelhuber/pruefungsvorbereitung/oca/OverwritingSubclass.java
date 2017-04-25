package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class OverwritingSubclass extends Overwriting { // Access-Level ist egal

    public void ichBinEinePrivateMethode(){
        System.out.println("Ich - aus der Kindklasse - nenne mich zwar privat, "
                + "bin es aber eigenttlich gar nicht!");
    }
    
    static void ichBinStatisch() {
        System.out.println("Ich bin statisch/Kindklasse!");
    }

//    long ichBinNichtStatisch() { // das geht nicht/primitiver Datenrückgabetyp muss identisch sein
    @Override
    int ichBinNichtStatisch() {
        System.out.println("Ich bin nicht statisch/Kindklasse!");
        return 0;
    }

    // Number ichBinNichtStatischLong(){ wenn hier Number steht, kann in der Elternklasse nicht Long stehen, 
    // da Long Kindklasse von Number
    @Override
    Long ichBinNichtStatischLong() { // Bei Referenztypen darf Kindklassenobjekt zurückgeliefert werden beim Überschreiben 
        System.out.println("Kindklasse!");
        return 5L;
    }

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new OverwritingSubclass().go();
    }

    private void go() {      // Ausgaben: E:Elternklasse; K:Kindklasse
        System.out.println("");
        super.ichBinNichtStatisch();                             // E
        super.ichBinNichtStatischLong();                         // E
        Overwriting.ichBinStatisch();                            // E
        System.out.println("");
        // Alle 3 produzieren den gleichen Output
        OverwritingSubclass.ichBinStatisch();                    // K
        this.ichBinStatisch();                                   // K
        ichBinStatisch();                                        // K
        System.out.println("");
        // Alle 4 produzieren den gleichen Output
        Overwriting.ichBinEineStatischeMethode();                // E
        OverwritingSubclass.ichBinEineStatischeMethode();        // E
        ichBinEineStatischeMethode();                            // E
        this.ichBinEineStatischeMethode();                       // E
        System.out.println("");
        //
        ichBinNichtStatisch();                                   // K
        ichBinNichtStatischLong();                               // K 
        Overwriting parent = new Overwriting();                  
        OverwritingSubclass child = new OverwritingSubclass();
        System.out.println("");
        Overwriting.ichBinStatisch();                            // E
        parent.ichBinStatisch();                                 // E
        System.out.println("");
        OverwritingSubclass.ichBinStatisch();                    // K
        child.ichBinStatisch();                                  // K
        System.out.println("");
        ((Overwriting) child).ichBinStatisch();      // statische Methode Elternklasse              // E 
        System.out.println("");
        ((Overwriting) child).ichBinNichtStatisch(); // überschriebene Methode Kindklassenobjekt    // K
        System.out.println("");
        child.ichBinEineStatischeMethode();                      // E
        ((Overwriting) child).ichBinEineStatischeMethode();      // E
        System.out.println("");             
        child.ichBinEinePrivateMethode();                        // K
//        ((Overwriting) child).ichBinEinePrivateMethode();        // geht natürlich nicht, da diese Methode nur innerhalb 
//                                                                 // der Elternklasse Overwriting verfügbar ist
        
        // Ausgaben: EEE KKK EEEE KK EE KK E K EE
    }
}
