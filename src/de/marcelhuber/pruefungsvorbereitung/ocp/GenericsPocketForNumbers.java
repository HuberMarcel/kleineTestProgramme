package de.marcelhuber.pruefungsvorbereitung.ocp;
// diese Klasse macht noch nicht genau das, was sie eigentlich machen soll
// typgerechtes addieren der Zahlen, d.h. die summe am Ende sollte vom 
// gleichen Typ sein, nicht Long...

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class GenericsPocketForNumbers<T extends Number> {

    private List<T> numbers;

    public GenericsPocketForNumbers(List<T> zahlenListe) {
        numbers = new ArrayList<>();
        while (!zahlenListe.isEmpty()) {
            numbers.add(zahlenListe.remove(0));
            System.out.println("numbers:     " + numbers);
            System.out.println("zahlenListe: " + zahlenListe);
        }
    }

//    public <T extends Number> T addiereAlleMeineZahlen() {
    public T addiereAlleMeineZahlen() {
        long summe = 0;

        while (!numbers.isEmpty()) {
//            PressEnter.toContinue();
            summe += (long) (Long.parseLong("" + numbers.remove(0)));
        }
        System.out.println("summe " + summe + " als byte: " + (byte) summe);
        System.out.println(this.getClass());
        return (T) (((Long) summe));
    }

    public List<T> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<T> numbers) {
        this.numbers = numbers;
    }

    public String toString() {
        return "" + addiereAlleMeineZahlen();
    }
}
