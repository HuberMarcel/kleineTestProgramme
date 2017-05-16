package de.marcelhuber.pruefungsvorbereitung.ocp;

import de.marcelhuber.systemtools.Pause;
import de.marcelhuber.systemtools.PressEnter;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class GenericsDemo {

    Calendar c;

    public static void main(String[] args) {
        new GenericsDemo().go();
        System.out.println("");
        PressEnter.toContinue();
        new GenericsDemo().go(true);
    }

    private void go() {
        go(false);
    }

    private void go(boolean checkIfIsInAQueue) {
        MyPocket<String> myName = new MyPocket<>("Marcel Huber");
        Calendar myDayOfBirth = Calendar.getInstance();
        myDayOfBirth.set(1980, 11, 27);
        MyPocket<Calendar> myBirthday = new MyPocket<>(myDayOfBirth);
        int myAgeNow = calculateMyAge(myDayOfBirth);
        MyPocket<Integer> myAge = new MyPocket<>(myAgeNow);
//        System.out.println(myName + ", " + myBirthday + ", " + myAge);
        System.out.println(myName + ", " + myAge);
        System.out.println("Bisher wurden " + MyPocket.getObjectCounter()
                + " MyPocket-Objekte erzeugt!");
//        System.out.println(myName.getValue() + ", " + myAge.getValue());
        Queue<Number> originalQueue = new LinkedList<>();
        originalQueue.add(35L);
        originalQueue.add((int) 33);
        originalQueue.add((long) 33);
        Integer spassZahl = 66;
        originalQueue.add(spassZahl);
        originalQueue.add(spassZahl);
        originalQueue.add(spassZahl);
        // die folgenden 3 Zeilen gehen nicht...
//        for (Number number : originalQueue) {
//            System.out.println(originalQueue.poll());
//        }
        long counter = 0;
        while (!originalQueue.isEmpty()) {
            System.out.println(++counter + ". Element wird entfernt: " + originalQueue.poll());
        }
        MyOwnQueue<String> myOwnQueue = new MyOwnQueue<>(checkIfIsInAQueue);
        System.out.println("");
        System.out.println("");
        System.out.println("NUN ZU MEINER EIGENEN QUEUE-IMPLEMENTIERUNG!!");
        System.out.print("Ist meine eigene Schlange momentan leer? Die Antwort lautet: ");
        System.out.println(myOwnQueue.isEmpty());
        showMyQueue(myOwnQueue);
        System.out.println("");
        myOwnQueue.add(new MyOwnQueueNode<>("Pascal"));
        System.out.print("Ist meine eigene Schlange momentan leer? Die Antwort lautet: ");
        System.out.println(myOwnQueue.isEmpty());
        showMyQueue(myOwnQueue);
        System.out.println("");
        myOwnQueue.add(new MyOwnQueueNode<>("Marcel"));
        myOwnQueue.add(new MyOwnQueueNode<>("Sascha"));
        myOwnQueue.add(new MyOwnQueueNode<>("Gisela"));
        myOwnQueue.add(new MyOwnQueueNode<>("Herbert"));
        showMyQueue(myOwnQueue);
        System.out.println("");
//        System.out.println("Die aktuelle Schlange würde in der folgenden "
//                + "Reihenfolge ausgegeben werden:\n" + myOwnQueue);
//        System.out.println("");
        //        myOwnQueue.information();
        MyOwnQueue.information();
        System.out.println("");
        System.out.println("Das erste Element ist momentan: ");
        System.out.println(myOwnQueue.peek());
        showMyQueue(myOwnQueue);
        System.out.println("");
        System.out.println("Jetzt entfernen wir das erste Element: "
                + myOwnQueue.poll());
        showMyQueue(myOwnQueue);
        System.out.println("Size: " + myOwnQueue.getSize());
        System.out.println("");
        System.out.println("Jetzt entfernen wir das erste Element: "
                + myOwnQueue.poll());
        showMyQueue(myOwnQueue);
        System.out.println("Aktuelle Größe der Queue: " + myOwnQueue.getSize());
        System.out.println("");
        showMyQueue(myOwnQueue);
        System.out.println("");
        System.out.println("");
        int i = 1;
        System.out.println("Jetzt behalten wir nur die ersten " + (i + 1) + ". "
                + "Elemente: ");
        System.out.println("Aktuelle Größe der Queue vorher: " + myOwnQueue.getSize());
        System.out.println("Der entfernte Queue-Anteil ist: " + myOwnQueue.cutTheQueue(i));
        showMyQueue(myOwnQueue);
        System.out.println("");
        System.out.println("Aktuelle Größe der Queue: " + myOwnQueue.getSize());
        MyOwnQueueNode<String> myOwnQueueNodeNr01 = new MyOwnQueueNode<>("Herbert");
        System.out.println("Hinzufügen eines neuen " + myOwnQueueNodeNr01 + "s!");
        myOwnQueue.add(myOwnQueueNodeNr01);
        showMyQueue(myOwnQueue);
        System.out.println("Size: " + myOwnQueue.getSize());
        System.out.println(myOwnQueue);
        System.out.println("");
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Nochmal adden?!?!?");
        myOwnQueue.add(myOwnQueueNodeNr01);
        showMyQueue(myOwnQueue);
        System.out.println("Fazit: Hier kann man den selben(!) Knoten nicht "
                + "mehrfach hinzufügen!");
        MyOwnQueueNode<String> myOwnQueueNodeNr02 = new MyOwnQueueNode<>("Pascal");
        MyOwnQueueNode<String> myOwnQueueNodeNr03 = new MyOwnQueueNode<>("Marcel");
        MyOwnQueueNode<String> myOwnQueueNodeNr04 = new MyOwnQueueNode<>("Gisela");
        MyOwnQueueNode<String> myOwnQueueNodeNr05 = new MyOwnQueueNode<>("Sascha");
        System.out.println("Zerstöre die Queue mit clearAndDestroyAllNextReferences()!");
        System.out.print("Ansicht vor clearAndDestroyAllNextReferences(): ");
        showMyQueue(myOwnQueue);
        System.out.print("Ansicht nach clearAndDestroyAllNextReferences(): ");
        myOwnQueue.clearAndDestroyAllNextReferences();
        showMyQueue(myOwnQueue);
        System.out.println("xxxxxxxxxx    Zeile 127    xxxxxxxxxx");
        myOwnQueue.add(myOwnQueueNodeNr01);
        System.out.println(myOwnQueueNodeNr01 + ", "
                + myOwnQueueNodeNr01.getValue() + ", "
                + myOwnQueueNodeNr01.getNext() + ", "
                + myOwnQueueNodeNr01.getIsInAQueue());
        System.out.println(myOwnQueueNodeNr01 + " gehört ja zur Queue myOwnQueue: " + myOwnQueue);
        showMyQueue(myOwnQueue);
        System.out.println(myOwnQueueNodeNr02 + ", "
                + myOwnQueueNodeNr02.getValue() + ", "
                + myOwnQueueNodeNr02.getNext() + ", "
                + myOwnQueueNodeNr02.getIsInAQueue());
        System.out.println(myOwnQueueNodeNr03 + ", "
                + myOwnQueueNodeNr03.getValue() + ", "
                + myOwnQueueNodeNr03.getNext() + ", "
                + myOwnQueueNodeNr03.getIsInAQueue());
        System.out.println(myOwnQueueNodeNr04 + ", "
                + myOwnQueueNodeNr04.getValue() + ", "
                + myOwnQueueNodeNr04.getNext() + ", "
                + myOwnQueueNodeNr04.getIsInAQueue());
        System.out.println(myOwnQueueNodeNr05 + ", "
                + myOwnQueueNodeNr05.getValue() + ", "
                + myOwnQueueNodeNr05.getNext() + ", "
                + myOwnQueueNodeNr05.getIsInAQueue());
        showMyQueue(myOwnQueue);
        myOwnQueue.add(myOwnQueueNodeNr02);
        showMyQueue(myOwnQueue);
        myOwnQueue.add(myOwnQueueNodeNr03);
        myOwnQueue.add(myOwnQueueNodeNr04);
        myOwnQueue.add(myOwnQueueNodeNr05);
        myOwnQueue.add(myOwnQueueNodeNr02);
        myOwnQueue.add(myOwnQueueNodeNr04);
        myOwnQueue.add(myOwnQueueNodeNr03);
        myOwnQueue.add(myOwnQueueNodeNr01);
        myOwnQueue.add(myOwnQueueNodeNr02);
        myOwnQueue.add(myOwnQueueNodeNr04);
        System.out.println("xxxxxxxxxx    Zeile 163    xxxxxxxxxx");
        showMyQueue(myOwnQueue);
        System.out.println("Size: " + myOwnQueue.getSize());
        MyOwnQueue cuttedQueue = myOwnQueue.cutTheQueue(2);
        System.out.println("myOwnQueue First: " + myOwnQueue.getFirstElement());
        System.out.println("myOwnQueue Last: " + myOwnQueue.getLastInsertedElement());
        System.out.println("Cutted queue: " + cuttedQueue);
        System.out.println("Size of the cutted queue: " + cuttedQueue.getSize());
        System.out.println("CuttedQueue First: " + cuttedQueue.getFirstElement());
        System.out.println("CuttedQueue Last: " + cuttedQueue.getLastInsertedElement());
        System.out.println("");
        showMyQueue(myOwnQueue);
        System.out.println("Size: " + myOwnQueue.getSize());
        // myOwnQueue.clear();
        // das würde nicht reichen, wenn man die Liste
        // später wieder so füllen will, als wenn alle Knoten einzeln erzeugt 
        // werden
        // es ergibt auch keinen Sinn, erst myOwnQueue.clear() und danach
        // clearAndDestroyNextReference() aufzurufen, weil die letztstehende
        // Methode ja das FirstElement zum Starten braucht!
        myOwnQueue.clearAndDestroyAllNextReferences();
        System.out.println("xxxxxxxxxx    Zeile 184    xxxxxxxxxx");
        System.out.println("myOwnQueue ist nun zerstört!");
        System.out.println("myOwnQueue: ");
        showMyQueue(myOwnQueue);
        System.out.println("cuttedQueue: ");
        showMyQueue(cuttedQueue);
        System.out.println("Die Knoten und ihre Zustände (also Value/getNext-Verweise):");
        System.out.println("1: " + myOwnQueueNodeNr01 + "/" + myOwnQueueNodeNr01.getNext());
        myOwnQueue.add(myOwnQueueNodeNr01);     // Herbert  kann geaddet werden
        System.out.println("2: " + myOwnQueueNodeNr02 + "/" + myOwnQueueNodeNr02.getNext());
        myOwnQueue.add(myOwnQueueNodeNr02);     // Pascal   kann geaddet werden
        System.out.println("3: " + myOwnQueueNodeNr03 + "/" + myOwnQueueNodeNr03.getNext());
        myOwnQueue.add(myOwnQueueNodeNr03);     // Marcel   kann geaddet werden
        System.out.println("4: " + myOwnQueueNodeNr04 + "/" + myOwnQueueNodeNr04.getNext());
        myOwnQueue.add(myOwnQueueNodeNr04);     // Gisela   kann nicht geaddet werden
        System.out.println("5: " + myOwnQueueNodeNr05 + "/" + myOwnQueueNodeNr05.getNext());
        myOwnQueue.add(myOwnQueueNodeNr05);     // Sascha   kann geaddet werden
        System.out.println("xxxxxxxxxx    Zeile 201    xxxxxxxxxx");
        myOwnQueue.add(myOwnQueueNodeNr02);
        myOwnQueue.add(myOwnQueueNodeNr04);
        myOwnQueue.add(myOwnQueueNodeNr03);
        myOwnQueue.add(myOwnQueueNodeNr01);
        myOwnQueue.add(myOwnQueueNodeNr02);
        myOwnQueue.add(myOwnQueueNodeNr04);
        System.out.println("");
        if (!checkIfIsInAQueue) {
            System.out.println("Hinweis: CuttedQueue enthält nun die Elemente "
                    + cuttedQueue + ", diese können - nur, wenn sie ohne Nachfolger sind - "
                    + "wieder\nin myOwnQueue aufgenommen werden!");
        } else {
            System.out.println("Hinweis: CuttedQueue enthält nun die Elemente "
                    + cuttedQueue + ", diese können hier nun gar nicht "
                    + "wieder\nin myOwnQueue aufgenommen werden!");
        }
        showMyQueue(myOwnQueue);
        System.out.println("Size: " + myOwnQueue.getSize());
        System.out.println("");
        showMyQueue(myOwnQueue);
        System.out.println("Size: " + myOwnQueue.getSize());
        System.out.println("");
        System.out.println("");
        System.out.println("Nun zerstören wir sowohl myOwnQueue als auch cuttedQueue: ");
        System.out.println("myOwnQueue.peek():  " + myOwnQueue.peek());
        System.out.println("cuttedQueue.peek(): " + cuttedQueue.peek());
        myOwnQueue.clearAndDestroyAllNextReferences();
        System.out.println("Pause");
        Pause.breakInSeconds(2);
        System.out.println("myOwnQueue First: " + myOwnQueue.getFirstElement());
        System.out.println("myOwnQueue Last: " + myOwnQueue.getLastInsertedElement());
        System.out.println("cuttedQueue First: " + cuttedQueue.getFirstElement());
        System.out.println("cuttedQueue Last: " + cuttedQueue.getLastInsertedElement());
        cuttedQueue.clearAndDestroyAllNextReferences();
//        System.out.print("MyOwnQueue: ");
//        showMyQueue(myOwnQueue);
//        System.out.print("CuttedQueue: ");
//        showMyQueue(cuttedQueue);
//        System.out.println("");
//        System.out.println("");
        System.out.println("Die Knoten und ihre Zustände (also Value/getNext-Verweise):");
        System.out.println("1: " + myOwnQueueNodeNr01 + "/" + myOwnQueueNodeNr01.getNext());
//        myOwnQueue.add(myOwnQueueNodeNr01);     // Herbert  kann geaddet werden
        System.out.println("2: " + myOwnQueueNodeNr02 + "/" + myOwnQueueNodeNr02.getNext());
//        myOwnQueue.add(myOwnQueueNodeNr02);     // Pascal   kann geaddet werden
        System.out.println("3: " + myOwnQueueNodeNr03 + "/" + myOwnQueueNodeNr03.getNext());
//        myOwnQueue.add(myOwnQueueNodeNr03);     // Marcel   kann geaddet werden
        System.out.println("4: " + myOwnQueueNodeNr04 + "/" + myOwnQueueNodeNr04.getNext());
//        myOwnQueue.add(myOwnQueueNodeNr04);     // Gisela   kann geaddet werden
        System.out.println("5: " + myOwnQueueNodeNr05 + "/" + myOwnQueueNodeNr05.getNext());
        myOwnQueue.add(myOwnQueueNodeNr05);     // Sascha   kann geaddet werden
        myOwnQueue.add(myOwnQueueNodeNr02);
        myOwnQueue.add(myOwnQueueNodeNr04);
        myOwnQueue.add(myOwnQueueNodeNr03);
        myOwnQueue.add(myOwnQueueNodeNr01);
        myOwnQueue.add(myOwnQueueNodeNr02);
        myOwnQueue.add(myOwnQueueNodeNr04);
        showMyQueue(myOwnQueue);
    }

    private int calculateMyAge(Calendar myBirthday) {
        Calendar now = Calendar.getInstance();
        int myAge = now.get(Calendar.YEAR) - myBirthday.get(Calendar.YEAR);
        int korrektur = 0;
        // rein zu Testzwecken kann man die folgenden Zeilen mal einzeln nacheinander einkommentieren
//        now.set(2017, 11, 26);
//        now.set(2017, 11, 27);
//        now.set(2017, 11, 28);
        // Ende der Testzwecke
        if (now.get(Calendar.MONTH) < myBirthday.get(Calendar.MONTH)) {
            korrektur = -1;
        } else if (now.get(Calendar.MONTH) == myBirthday.get(Calendar.MONTH)) {
            if (now.get(Calendar.DAY_OF_MONTH) < myBirthday.get(Calendar.DAY_OF_MONTH)) {
                korrektur = -1;
            }
        }
        myAge += korrektur;
        return myAge;
    }

    public void showMyQueue(MyOwnQueue<String> myOwnQueue) {
        System.out.println("Die aktuelle Schlange würde in der folgenden "
                + "Reihenfolge ausgegeben werden:\n" + myOwnQueue);
    }

}

class MyOwnQueue<T> {

    private MyOwnQueueNode<T> firstElement;
    private MyOwnQueueNode<T> lastInsertedElement;
    private MyOwnQueueNode<T> helper;
    private boolean checkIfNodeIsInAnotherQueue;     // falls true, so soll der Node die andere Queue nur nach poll() verlassen
    // dürfen
    private long size;

    public boolean isCheckIfNodeIsInAnotherQueue() {
        return checkIfNodeIsInAnotherQueue;
    }

    public MyOwnQueueNode<T> getFirstElement() {
        return firstElement;
    }

    public MyOwnQueueNode<T> getLastInsertedElement() {
        return lastInsertedElement;
    }

    public MyOwnQueue() {
        checkIfNodeIsInAnotherQueue = false;
    }

    public MyOwnQueue(boolean checkIfNodeIsInAnotherQueue) {
        this.checkIfNodeIsInAnotherQueue = checkIfNodeIsInAnotherQueue;
    }

    public void add(MyOwnQueueNode<T> element) {
        if (checkIfNodeIsInAnotherQueue) {
            if (element.getIsInAQueue()) {
//                System.out.println("ADDING!!! " + element + "/" + element.getNext());
                return;
            }
        }
        if (element != null & lastInsertedElement != element) {
            if (element.getNext() == null) {
//                System.out.println("ADDING");
                if (isEmpty()) {
                    firstElement = element;
                    lastInsertedElement = element;
                } else {
                    lastInsertedElement.setNext(element);
                    lastInsertedElement = element;
                }
                size++;
                element.setIsInAQueue(true);
            }
        }
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public MyOwnQueueNode<T> peek() {
        return firstElement;
    }

    public MyOwnQueueNode<T> poll() {
        MyOwnQueueNode<T> firstSaved;
        firstSaved = firstElement;
        if (firstElement == null) {
            return null;
        }
        if (checkIfNodeIsInAnotherQueue) {
            firstElement.setIsInAQueue(false);
        }
        helper = firstElement.getNext();
        firstElement.setNext(null);
        firstElement = helper;
        --size;
        return firstSaved;
    }

    /**
     * The method cutTheQueue(long number) cuts the Queue after first (number+1)
     * Elements!
     */
    public MyOwnQueue<T> cutTheQueue(long number) {
        int counter = 1;
        helper = firstElement;
        MyOwnQueue cuttedQueue = new MyOwnQueue<>(checkIfNodeIsInAnotherQueue);
        if (size == 0) {
            return null;
        }
        while (helper.getNext() != null & counter <= number) {
            counter++;
            helper = helper.getNext();
        }
        cuttedQueue.firstElement = helper.getNext();
        cuttedQueue.lastInsertedElement = lastInsertedElement;
        cuttedQueue.size = size - counter;
        lastInsertedElement = helper;
        System.out.println("Last Inserted because of "
                + "cutting after the " + (number + 1) + "th element: " + lastInsertedElement);
        helper.setNext(null);
        size = counter;
        return cuttedQueue;
    }

    public String toString() {
        StringBuilder returnTheQueue = new StringBuilder("[");
        MyOwnQueueNode<T> startNode = firstElement;
        if (firstElement != null) {
            helper = firstElement;
            returnTheQueue.append(helper.getValue());
            while (helper.getNext() != null) {
                returnTheQueue.append(", " + helper.getNext().getValue());
                helper = helper.getNext();
            }
        }
        returnTheQueue.append("]");
        return returnTheQueue.toString();
    }

    static public void information() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!! Das linkeste Element ist immer das aktuell erste !!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public long getSize() {
        return size;
    }

    public void clear() {
        lastInsertedElement = firstElement = null;
        size = 0;
    }

    public void clearAndDestroyAllNextReferences() {
        helper = firstElement;
        if (helper != null) {
            while (helper.getNext() != null) {
//                System.out.println("Clearing: FE: " + firstElement);
                if (checkIfNodeIsInAnotherQueue) {
                    helper.setIsInAQueue(false);
                }
                firstElement = helper.getNext();
                helper.setNext(null);
                if (firstElement != null) {
                    firstElement.setIsInAQueue(false);
                }
                helper = firstElement;
            }
        }
//        System.out.println("Nun: FE" + firstElement + "/" + firstElement.getNext());
//        System.out.println("Nun: LE" + lastInsertedElement + "/" + lastInsertedElement.getNext());
        firstElement = lastInsertedElement = null;
        size = 0;
    }
}

class MyOwnQueueNode<T> {

    private MyOwnQueueNode<T> next;
    private T value;
    private boolean isInAQueue;

    public MyOwnQueueNode(T value) {
        this.value = value;
    }

    public MyOwnQueueNode<T> getNext() {
        return next;
    }

    public void setNext(MyOwnQueueNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }

    public boolean getIsInAQueue() {
        return isInAQueue;
    }

    public void setIsInAQueue(boolean isInAQueue) {
        this.isInAQueue = isInAQueue;
    }
}

class MyPocket<T> {

    static private long objectCounter;
    private T value;

    public MyPocket() {
        ++objectCounter;
    }

    public MyPocket(T value) {
        this.value = value;
        ++objectCounter;
    }

    public static long getObjectCounter() {
        return objectCounter;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
//        return "MyPocket{" + "value=" + value + "/class" + value.getClass() + '}';
        return "" + value;
    }
}
