package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.HashSet;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class HashSetDemo extends HashSet<Person> {

    public static void main(String[] args) {
        HashSetDemo group = new HashSetDemo();
        group.add(new Person("Hans"));
        group.add(new Person("Lotte"));
        group.add(new Person("Jane"));
        group.add(new Person("Hans"));
        group.add(new Person("Jane"));
        System.out.println("Total: " + group.size());
    }

//    public boolean add(Object o){
    public boolean add(Person o) {
        System.out.println("Adding: " + o);
        return super.add(o);
    }
}

class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
