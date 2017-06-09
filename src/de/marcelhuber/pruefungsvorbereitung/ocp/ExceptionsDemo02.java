package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Marcel Huber
 */
public class ExceptionsDemo02 {

    public static void main(String[] args) throws Exception {
        try {
            new ExceptionsDemo02().go01();
        } catch (Exception ex) {
            try {
                throw new MyOwnClassException("Hallo 2");
            } finally {
                System.err.println("ex: " + ex);
                System.out.println(Arrays.toString(ex.getSuppressed()));
                for (Throwable exce : ex.getSuppressed()) {
                    System.out.print("exce: " + exce + "  | ");
                }
            }
        }
//        new ExceptionsDemo02().go02();
    }

    private void go01() throws MyOwnClassException {
//        throw new MyOwnClassException();
        throw new MyOwnClassException("Hallo");
    }

////    Das untenstehende wäre ziemlich sinnlos, denn der Scope der Klasse
////    ist zu eingeschränkt...
//    private void go02() throws MyInnerClassException {
//        class MyInnerClassException extends Exception {
//
//            MyInnerClassException(){
//                this("");
//            }
//            
//            MyInnerClassException(String fehler) {
//                super("Fehlermeldung aus MyStaticInnerClassException: " + fehler);
//            }
//        }
//        try {
//            throw new MyInnerClassException();
//        } finally {
//            System.out.println("");
//        }
//    }
}

class MyOwnClassException extends Exception {

    MyOwnClassException() {
        this("");
    }

    MyOwnClassException(String fehler) {
        super("Fehlermeldung aus MyStaticInnerClassException: " + fehler);
    }
}
