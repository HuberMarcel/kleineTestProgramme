package de.marcelhuber.pruefungsvorbereitung.oca;
// Aufruf der main-Methode der Demo-Klasse - Rest funktioniert dann

/**
 *
 * @author Marcel Huber
 */
public class PublicStaticVoidMainDemo {

    public static void main(String[] args) {
        int x = 4;
        int y = 22;
        int j = y += x += 2;     // von rechts nach links abgearbeitet
        System.out.println("x: " + x + ", y: " + y + ", j: " + j);
        // x: 6, y: 28 , j: 28
        AnotherPublicStaticVoidMain.main(new String[]{"Hallo!!", "Liebe Welt!"});
        ChildOfPublicStaticVoidMain.main(new String[]{"Hallo!!", "Coole Welt!"});
    }
}

class AnotherPublicStaticVoidMain {

    public static void main(String[] args) {
        System.out.println(args[0] + " " + args[1]);
    }
}

class ChildOfPublicStaticVoidMain {

    public static void main(String[] args) {
        System.out.println("Ich bin eine Kindklasse!");
    }

}
