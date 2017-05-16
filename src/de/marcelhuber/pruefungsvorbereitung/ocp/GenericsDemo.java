package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.text.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class GenericsDemo {

    Calendar c;

    public static void main(String[] args) {
        new GenericsDemo().go();
    }

    private void go() {
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
