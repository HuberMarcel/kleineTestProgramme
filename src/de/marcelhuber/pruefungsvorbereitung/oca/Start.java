// Aus dem Study-Guide-Quiz
package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
class A {

    public void say() {
        System.out.print("Hey! ");
    }
}

class B extends A {

    public void say(String name) {
        System.out.print("Hello, " + name);
    }
}

class C extends A {
}

public class Start {

    public static void main(String[] args) {
//        B b = new A();     // B ist KINDKLASSE von A
        B b = new B();
        b.say();
        b.say("John Lennon");
    }
}
