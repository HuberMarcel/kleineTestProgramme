package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class ClassCastException {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new ClassCastException().go();
    }

    private void go() {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.makeNoise(); // die zuletzt überschriebene Methode wird ausgeführt
//      dog.eat(); // geht nicht, da Animal-Brille
        ((Dog) dog).eat();
        if (dog instanceof Cat) {
            ((Cat) dog).eatWhatACatEats();
        } else {
            System.out.println("(Info [keine Klasse]): A Hund is doch ka Katz!");
        }
        //        ((Cat) dog).eat(); // ClassCastException: cce
//        (Cat) ((Dog) dog).eatsCat(); // muss irgendwas machen
        ((Cat) ((Dog) dog).eatsCat()).eat();
        ((Dog) dog).eatsCat();
        // ClassCastException ist nicht Throwable
//        try {
//            ((Cat) dog).eatWhatACatEats();
//        } catch (ClassCastException cce) {
//            System.out.println("Hallo!");
//        }
    }
}

abstract class Animal {

    public void makeNoise() {
        System.out.println("(Animal) hrhrhrhr... ");
    }
}

class Dog extends Animal {

    public void makeNoise() {
        System.out.println("(Dog) Wuff!");
    }

    public void eat() {
        System.out.println("(Dog) i'll take an human, hahahaha!");
    }

    Cat eatsCat() {
//        Cat lucky = new Cat();  // sobald es einen Konstruktor gibt, muss der Default durch no-arg ersetzt werden
        Cat lucky = new Cat("lucky");
        System.out.println("(Dog) Ich fresse " + lucky.getName() + " ! ");
        return lucky;
    }

}

class Cat extends Animal {

    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void makeNoise() {
        System.out.println("(Cat) Miauuuuuu!");
    }

    public void eatWhatACatEats() {
        System.out.println("(Cat) Katzen würden Whiskas kaufen!");
    }

    public void eat() {
        System.out.println("(Cat) i'll take a fish!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
