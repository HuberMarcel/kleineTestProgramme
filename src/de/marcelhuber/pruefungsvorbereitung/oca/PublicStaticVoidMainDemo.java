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
        int j = y += x += 2;     // hier von rechts nach links abgearbeitet
        System.out.println("x: " + x + ", y: " + y + ", j: " + j);
        // x: 6, y: 28 , j: 28
        AnotherPublicStaticVoidMain.main(new String[]{"Hallo!!", "Liebe Welt!"});
        ChildOfPublicStaticVoidMain.main(new String[]{"Hallo!!", "Coole Welt!"});
        // In der Prüfung stand vielleicht auch sowas da:
//         AnotherPublicStaticVoidMain.main({"Hallo!!", "Liebe Welt!"});
        AndAnotherPublicStaticVoidMain.main("Hallo ", "Welt");
//        AndAnotherPublicStaticVoidMain.main({"Hallo ", "Welt"});       // das geht so nicht
    }
}

class AndAnotherPublicStaticVoidMain {

    public static void main(String... args) {
        System.out.println(args[0] + "" + args[1]);
    }
}

class AnotherPublicStaticVoidMain {

    public static void main(String[] args) {
        System.out.println(args[0] + " " + args[1]);
    }
}

class ChildOfPublicStaticVoidMain extends PublicStaticVoidMainDemo {

    public static void main(String[] args) {
        System.out.println("Ich bin eine Kindklasse!");
    }

}
