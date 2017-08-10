// Seite 647ff.
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber; letzte Änderung: 10.8.2017
 */
public class AnimalDoctorGeneric {

    static private int animalCounter;
    static private int dogCounter;

    private List<Animal> animals;

    public class Animal {

        private final int animalID;

        public Animal() {
            animalID = ++animalCounter;
        }

        @Override
        public String toString() {
            return "Tier Nummer: " + animalID;
        }
    }

    public class Dog extends Animal {

        private final int dogID;

        public Dog() {
            dogID = ++dogCounter;
        }

        @Override
        public String toString() {
            return super.toString() + ", Hund Nummer: " + dogID + ";";
        }
    }

    public static void main(String[] args) {
        AnimalDoctorGeneric dummyObject = new AnimalDoctorGeneric();
        dummyObject.go01();
    }

    private void go01() {
        animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Dog());
        System.out.println(animals);
        addNewDogCorrectlyToAnimals(animals);
        System.out.println(animals);
        // die folgende auskommentierte Zeile funktioniert nicht, weil der
        // Typ der Liste, die übergeben wird (Animals) nicht identisch mit 
        // dem Typ der Liste, die in der genannten Methode "empfangen" wird,
        // ist!!
//        addNewDogIncorrectlyToAnimals(animals);
        List<Dog> dogs = new ArrayList<>();
        addNewDogIncorrectlyToAnimals(dogs);
        System.out.println(dogs);
    }

    private void addNewDogCorrectlyToAnimals(List<Animal> animals) {
        animals.add(new Dog());
    }

    private void addNewDogIncorrectlyToAnimals(List<Dog> animals) {
        animals.add(new Dog());
    }
}
