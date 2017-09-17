package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class Babble extends Thread {

    static public synchronized void say(String s) {
        System.out.print(s + " ");
    }

    public static void main(String[] args) {
        Thread letters = new Thread() {
            @Override
            public void run() {
                synchronized (Thread.class) {
                    say("a");
                    say("b");
                    say("c");
                }
            }
        };
        Thread numbers = new Thread() {
            @Override
            public void run() {
//                synchronized (Thread.class) {
                synchronized (this) {
                    say("1");
                    say("2");
                    say("3");
                }
            }
        };
        SynchronizedNumbersOnLetters syncNumbers 
                = new SynchronizedNumbersOnLetters(numbers);
        letters.start();
//        try {
//            letters.join();
//        } catch (InterruptedException ex) {
//            System.err.println("Interrupted");
//        }
        numbers.start();
        syncNumbers.start();
        // immer 123 vor def, oder def vor 123
        // a b c kann sich aber dazwischenschieben, da nicht synchronized, nur
        // immer a vor b vor c dabei
        // Beispielhafte Ausgabe: a d e f b c 1 2 3
    }
}

class SynchronizedNumbersOnLetters extends Thread {

    private final Thread thread;

    public SynchronizedNumbersOnLetters(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        synchronized (thread) {
            Babble.say("d");
            Babble.say("e");
            Babble.say("f");
        }
    }
}
