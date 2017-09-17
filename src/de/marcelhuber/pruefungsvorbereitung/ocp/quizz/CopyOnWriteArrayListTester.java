// Demonstration der CopyOnWriteList: iteriert wird über das Originalfeld,
// die Veränderungen sieht man auf einem kopierten Feld
package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import de.marcelhuber.systemtools.*;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class CopyOnWriteArrayListTester {

    static private List<Integer> list = new ArrayList<>();
    static private List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        list.add(1);
        list.add(3);
        list.add(5);
        Iterator<Integer> it = list.iterator();
        int counter = 1;
        while (it.hasNext()) {
            System.out.println(it.next());
//            list.add(++counter);
        }
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
        copyOnWriteList.add(1);
        copyOnWriteList.add(3);
        copyOnWriteList.add(5);
        it = copyOnWriteList.iterator();
        while (it.hasNext()) {
            copyOnWriteList.remove(0);
            // iteriert wird über eine Kopie des Originalfeldes
            System.out.println(it.next());
            copyOnWriteList.add(++counter);
            System.out.println("copyOnWriteList: " + copyOnWriteList);
            System.out.println("letztes Element: " + copyOnWriteList.get(2));
        }
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
        for (int entry : copyOnWriteList) {
            System.out.println("entry: " + entry);
            copyOnWriteList.add(entry * entry);
        }
        System.out.println("copyOnWriteList: " + copyOnWriteList);
    }
}
