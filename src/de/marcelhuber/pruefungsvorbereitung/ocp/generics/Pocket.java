package de.marcelhuber.pruefungsvorbereitung.ocp.generics;

/**
 *
 * @author Marcel Huber
 */
class Pocket<P> {

    static private int pocketValueGetterCounter = 0;  // zählt, wie oft die getValue-Methode benutzt wird
    private int objectPocketValueGetterCounter = 0;   // zählt, wie oft die getValue-Methode pro Objekt benutzt wird - im no-arg-Konstruktor

    private P value;

    <P> Pocket() {
//        value = null; redundante Zeile
        getValue();
        objectPocketValueGetterCounter++;
    }

    <P> Pocket(Pocket<P> p) {
        p.setValue(p.getValue());
        System.out.println(getValue());
    }

    public static int getPocketValueGetterCounter() {
        return pocketValueGetterCounter;
    }

    public int getObjectPocketValueGetterCounter() {
        return objectPocketValueGetterCounter;
    }

    public P getValue() {
        ++pocketValueGetterCounter;
        return value;
    }

    public void setValue(P value) {
        this.value = value;
    }
}
