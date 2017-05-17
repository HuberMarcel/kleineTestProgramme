package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class GenericsDemoForGenericsMethods {

    List<Integer> meineIntegerListe = new ArrayList<>();
    List<Animal> animals02 = new ArrayList<>();

    public static void main(String[] args) {
//        new GenericsDemoForGenericsMethods().go();
        new GenericsDemoForGenericsMethods().goListAnimalsAndDogs();
    }

    void goListAnimalsAndDogs() {
        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(("Dog01")));
        dogs.add(new Dog(("Dog02")));
        dogs.add(new Dog(("Dog03")));
        System.out.println("Dog-ArrayList:       " + dogs);
        //
        System.out.println("");
        animals.add(new Animal(("Animal01")));
        animals.add(new Animal(("Animal02")));
        animals.add(new Animal(("Animal03")));
        animals.add(new Animal(("Animal04")));
        animals.add(new Animal(("Animal05")));
        System.out.println("Animal-ArrayList:    " + animals);
        animals.add(new Dog("Dog04"));
//        animals02 = dogs;                          // das kann nicht funktionieren
//                                                   // da der Compiler den gleichen 
//                                                   // Typ bei <> erwartet
        addTheDogsInAnimals02(dogs);
        System.out.println("Animals02-ArrayList: " + animals02);
        addTheDogsInAnimals02Again(dogs);
    }

//    public <T extends Animal> void addTheDogsInAnimals02(List<T> dogs) {
    public void addTheDogsInAnimals02(List<? extends Animal> dogs) {
//        List<Animal> animals02 = dogs;
        List<?> animals02 = dogs;
//        animals02.add(new Dog("Wuffi"));   
        // kann nicht funktionieren, T kann ja auch ein 
        // Kind von Animal sein, welches nichts mit Dog zu tun hat

//        animals02.add(new Animal("AnimalNeu"));
        // auch das kann nicht funktionieren, da wir ja in einer mit T typisierten 
        // Liste ja nur Elemente der Kindklassen von T aufnehmen wollen
        // Elternklassen sind ggf. viel allgemeiner
    }

//    public <T super Animal>void addTheDogsInAnimals03Again(List<T> dogs) {
////        List<Animal> animals02 = dogs;
//        List<T> animals02 = dogs;
//    }
    // Die folgende wildCard entspricht dem hierdrüber
    public void addTheDogsInAnimals02Again(List<? super Dog> dogs) {
        // verwirrend, aber: ? super Dog zeigt an, dass dogs ein Typ
        // einer Superklasse von Dog ist          
//        List<Animal> animals02 = dogs;
//        List<?> animals02 = dogs;     // das würde so funktionieren
        List<? super Animal> animals02 = new ArrayList<>();
        // Hiermit ist ? mindestens vom Typ Animal, also alles, was ein Animal ist,
        // darf auch hinzugefügt werden
        animals02.add(new Dog("ichBinEinDog"));
        System.out.println(dogs.get(0));
        animals02.add(new Animal("ichBinEinAnimal"));
        Dog dog = (Dog) dogs.get(0);
//        dogs.add(new Animal("ichBinAuchNurEinTier"));   // nur Kinder von Dog passen hier rein
        // aufpassen: animals02 mit <? super Animal>; aber dogs mit <? super Dog> !!

        // da dogs.get(0) vom Typ einer Superklasse von Dog ist, übernehmen wir
        // hier die Verantwortung dafür, dass der Downcast (Dog) ... funktioniert 
        System.out.println("Dog-ArrayList:       " + dogs);
    }

    void go() {
//       meineIntegerListe.add("String");
        meineIntegerListe.add(1);
        meineIntegerListe.add(3);
        meineIntegerListe.add(5);
        meineIntegerListe.add(7);
        meineIntegerListe.add(9);
        System.out.println("Aktueller Stand meiner Liste:");
        System.out.println(meineIntegerListe);
        manipuliereMeineListe(meineIntegerListe);
        System.out.println("Nach der Manipulation:\n"
                + meineIntegerListe);
        List ichTesteDasAuch = meineIntegerListe;
        ichTesteDasAuch.add("coole Sache");
        System.out.println("Nach der Manipulation:\n"
                + meineIntegerListe);
        System.out.println(meineIntegerListe);
        meineIntegerListe.clear();
        meineIntegerListe.add(1);
        meineIntegerListe.add(3);
        meineIntegerListe.add(5);
        meineIntegerListe.add(7);
        meineIntegerListe.add(9);
    }

    public void manipuliereMeineListe(List meineListe) {
        meineListe.add("Hahaha!");
        meineListe.add("Das macht Spaß!");
        meineListe.add("Ich bin wirklich fies!");
        meineListe.add("Denn ich habe jetzt die meineListe<Objekt>-Brille auf!");
        meineListe.add("Ende mit Schrecken!");
        meineListe.add('E');
    }
}

class Animal {

    private String myAnimalName;

    public Animal() {
    }

    public Animal(String myAnimalName) {
        this.myAnimalName = myAnimalName;
    }

    public String getMyAnimalName() {
        return myAnimalName;
    }

    public void setMyAnimalName(String myAnimalName) {
        this.myAnimalName = myAnimalName;
    }

    public String toString() {
        return "" + myAnimalName;
    }
}

class Dog extends Animal {

    private String myDogName;

    public Dog(String myDogName) {
        this.myDogName = myDogName;
    }

    @Override
    public String getMyAnimalName() {
        return myDogName;
    }

    @Override
    public void setMyAnimalName(String myDogName) {
        this.myDogName = myDogName;
    }

    @Override
    public String toString() {
        return "" + myDogName;
    }
}
