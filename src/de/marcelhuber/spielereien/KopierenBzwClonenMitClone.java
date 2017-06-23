package de.marcelhuber.spielereien;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.PressEnter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class KopierenBzwClonenMitClone {

    public static void main(String[] args) {
        System.out.println("    Demo flache Kopie:".toUpperCase());
        new KopierenBzwClonenMitClone().goDemoFlacheKopie();
        System.out.println("");
        System.out.println("");
        PressEnter.toContinue();
        System.out.println("    Demo tiefe Kopie:".toUpperCase());
        new KopierenBzwClonenMitClone().goDemoTiefeKopie();
    }

    private void goDemoFlacheKopie() {
        IntWrapperSchlechtClonebar intWrSchl01 = new IntWrapperSchlechtClonebar(5);
        intWrSchl01.addiere(7);
        System.out.println("Name und Wert des IntWrapperSchlechtClonebar-Objekts:"
                + "           "
                + intWrSchl01);
        IntWrapperSchlechtClonebar intWrSchl02 = intWrSchl01.clone();
        System.out.println("Name und Wert des geklonten "
                + "IntWrapperSchlechtClonebar-Objekts: "
                + intWrSchl02);
        System.out.println("Addieren wir beim ersten Objekt noch 8 drauf:");
        intWrSchl01.addiere(8);
        System.out.println("so hat es nun den Wert: "
                + intWrSchl01);
        System.out.println("Aber das geklonte Objekt hat weiterhin den Wert:    "
                + "            " + intWrSchl02);
        System.out.println("Aber die Objekte sind schlecht kopiert, denn:");
        System.out.println("Ändern wir jetzt \"nur\" den Namen des ersten "
                + "Objekts (intWrSchl01.setObjektName(\"NurObjekt01SollNeuenNamenHaben\");), "
                + "\nauf den beide Objekte verweisen,so wirkt sich das dummerweise "
                + "auf beide aus!\n");
        intWrSchl01.setObjektName("NurObjekt01SollNeuenNamenHaben");
        System.out.println("Name und Wert des ersten Objekts:                    "
                + intWrSchl01);
        System.out.println("Name und Wert des zweiten Objekts:                   "
                + intWrSchl02);
    }

    private void goDemoTiefeKopie() {
        IntWrapperGutClonebar intWrGut01 = new IntWrapperGutClonebar(5);
        intWrGut01.addiere(7);
        System.out.println("Name und Wert des IntWrapperSchlechtClonebar-Objekts:"
                + "           "
                + intWrGut01);
        IntWrapperGutClonebar intWrGut02 = intWrGut01.clone();
        System.out.println("Name und Wert des geklonten "
                + "IntWrapperSchlechtClonebar-Objekts: "
                + intWrGut02);
        System.out.println("Addieren wir beim ersten Objekt noch 8 drauf:");
        intWrGut01.addiere(8);
        System.out.println("so hat es nun den Wert: "
                + intWrGut01);
        System.out.println("Aber das geklonte Objekt hat weiterhin den Wert:    "
                + "            " + intWrGut02);
        System.out.println("Hier sind die Objekte gut kopiert, denn:");
        System.out.println("Ändern wir jetzt \"nur\" den Namen des ersten "
                + "Objekts, so wirkt sich das nun nicht mehr auf beide aus!\n");
        intWrGut01.setObjektName(new StringWrapper("NurObjekt01SollNeuenNamenHaben"));
        System.out.println("Name und Wert des ersten Objekts:                    "
                + intWrGut01);
        System.out.println("Name und Wert des zweiten Objekts:                   "
                + intWrGut02);
        Marker.marker();
        Marker.marker();
        System.out.println("Ändern wir jetzt \"nur\" den Namen des ersten "
                + "Objekts, so wirkt sich das nun nicht mehr auf beide aus!\n");
        intWrGut01.setObjektName("NurObjekt01SollNeuenNamenHaben");
        System.out.println("Name und Wert des ersten Objekts:                    "
                + intWrGut01);
        System.out.println("Name und Wert des zweiten Objekts:                   "
                + intWrGut02);
        Marker.marker();
        Marker.marker();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        StringWrapper strWra01 = new StringWrapper("Hallo");
        StringWrapper strWra02 = strWra01.clone();
        System.out.println("strWra01: " + strWra01);
        System.out.println("strWra02: " + strWra02);
        strWra01.setName(strWra01.getName() + " Welt!");
        System.out.println("strWra01: " + strWra01);
        System.out.println("strWra02: " + strWra02);
    }
}

class IntWrapperGutClonebar implements Cloneable {

    private static int counter = 0;

    private int intWert;
    private StringWrapper objektName;

    public IntWrapperGutClonebar(int intWert) {
        this.intWert = intWert;
        objektName = new StringWrapper(++counter
                + ". IntWrapperGutClonebarObjekt");
    }

    public void addiere(int j) {
        intWert += j;
    }

    public int getIntWert() {
        return intWert;
    }

    @Override
    public String toString() {
        return "Name: " + getObjektName() + " - Wert: " + getIntWert();
    }

    public StringWrapper getObjektName() {
        return objektName;
    }

    public void setObjektName(StringWrapper objektName) {
        this.objektName = objektName;
    }

    public void setObjektName(String objektName) {
        this.objektName.setName(objektName);
    }

    @Override
    public IntWrapperGutClonebar clone() {
        Object cloneObject = null;
        try {
            cloneObject = super.clone();
            ((IntWrapperGutClonebar) cloneObject).setObjektName(
                    ((IntWrapperGutClonebar) cloneObject).getObjektName().clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(IntWrapperSchlechtClonebar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (IntWrapperGutClonebar) cloneObject;
    }
}

class StringWrapper implements Cloneable {

    private String name;

    StringWrapper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public StringWrapper clone() {
        return new StringWrapper(this.getName());
    }
}

class IntWrapperSchlechtClonebar implements Cloneable {

    private static int counter = 0;

    private int intWert;
    private StringWrapperElementar objektName;

    public IntWrapperSchlechtClonebar(int intWert) {
        this.intWert = intWert;
        objektName = new StringWrapperElementar(++counter
                + ". IntWrapperSchlechtClonebarObjekt");
    }

    public void addiere(int j) {
        intWert += j;
    }

    public int getIntWert() {
        return intWert;
    }

    @Override
    public String toString() {
        return "Name: " + getObjektName() + " - Wert: " + getIntWert();
    }

    public StringWrapperElementar getObjektName() {
        return objektName;
    }

    public void setObjektName(String objektName) {
        this.objektName.setName(objektName);
    }

    public void setObjektName(StringWrapperElementar objektName) {
        this.objektName.setName(objektName.getName());
    }

    @Override
    public IntWrapperSchlechtClonebar clone() {
        Object cloneObject = null;
        try {
            cloneObject = super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(IntWrapperSchlechtClonebar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (IntWrapperSchlechtClonebar) cloneObject;
    }
}

class StringWrapperElementar {

    private String name;

    StringWrapperElementar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
