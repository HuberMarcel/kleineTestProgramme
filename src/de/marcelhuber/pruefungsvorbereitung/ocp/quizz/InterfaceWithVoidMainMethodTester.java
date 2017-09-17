// Demonstration: Wenn eine Klasse das hier vorgegebene Interface implementiert,
//                dann muss eine public void main(String[] args) konkretisiert
//                werden, und damit gibt es dann keine public static void main...
package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.Arrays;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class InterfaceWithVoidMainMethodTester implements InterfaceWithVoidMainMethod {

    {
        this.main("Hahaha", "Hohoho");
    }

//    public static void main(String[] args) {
//        
//    }
    public void main(String... args) {
        System.out.println("Hallo");
        System.out.println(Arrays.toString(args));
    }
}

interface InterfaceWithVoidMainMethod {

    public void main(String... args);
//    public void main(String args);
}
