// wenn man dieses Interface implementiert, muss eine nicht-statische
// main-Methode geschrieben werden
package de.marcelhuber.pruefungsvorbereitung.oca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public interface IPreventTheStaticVoidMainMethod {

    final static String hinweis = "Ich bin ein fieses Interface: Wer mich implementiert, "
            + "der kann keine \nstatic void main(String... args) mehr benutzen - und "
            + "wenn jemand diese (Objektbezogene) main()-Methode von mir \nüberschreiben will, dann "
            + "muss der Access-Level public sein!";

    void main(String[] args);
}

class Test implements IPreventTheStaticVoidMainMethod {

    @Override
    public void main(String[] args) {
        System.out.println("Verdammte Hacke!");

    }

    public String toString() {
        return "Test-Objekt!";
    }

    // das obige Interface verhindert die folgenden Zeilen    
//    public static void main(String[] args) {
//        System.out.println("Verdammte Hacke, das geht nicht mehr!");
//    }
//    public static void main(String... args) {
//        System.out.println("Doppelte verdammte Hacke!");
//
//    }
}

//abstract class PreventTheStaticMain {
abstract class PreventTheStaticMain implements IPreventTheStaticVoidMainMethod {
// auch ich kann das, was das Interface oben kann; wer von mir erben will, wird's merken

//    abstract void main(String... hahahaBinIchfies); // wenn Interface IPrevent... implementiert, Access-Level!
    public abstract void main(String... hahahaBinIchfies);

    public String toString() {
        return "(abstract) PreventTheStaticMain - Hier gibt's kein Objekt!";
    }
}

class ChildOfPreventTheStaticMain extends PreventTheStaticMain {

    @Override
//    void main(String... hahahaBinIchfies) {   // analog zu oben
    public void main(String... hahahaBinIchfies) {
        System.out.println("Verdammte Hacke, jetzt geht das hier auch nicht!");
    }

//    public static void main(String[] args) {
//        System.out.println("Verdammte Hacke, ist das fies!");
//    }
    public String toString() {
        return "ChildOfPreventTheStaticMain-Objekt!";
    }
}

class IchTesteDieKlassenOben {

    List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        new IchTesteDieKlassenOben().go();
    }

    void go() {
        IPreventTheStaticVoidMainMethod a = new Test();
        IPreventTheStaticVoidMainMethod b = new ChildOfPreventTheStaticMain();
// Compilation-Fehler, wenn ChildOf... nicht das Interface linkerhand implementiert
        list.add(a);
        list.add(b);
        System.out.println(list);
        for (Object o : list) {
            ((IPreventTheStaticVoidMainMethod) o).main(new String[]{"fdsgfhj", "g", "dshgfhgds"});
        }
        System.out.println("IPreventTheStaticVoidMainMethod-Hinweis: "
                + IPreventTheStaticVoidMainMethod.hinweis);
        // Ergänzung: Wenn die abstrakte Klasse nicht das Interface IPreventTheStaticVoidMainMethod
        // implementiert, kann sie eine eigene void main(String... x) zur Verfügung stellen, 
        // die aber nicht unbedingt das Access-Level public haben muss. Alsdann kann dann
        // zumindest diese Objekt-Methode ggf. mit einem "weniger einschränkenden Access-Level"
        // überschrieben werden
    }
}
