package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class Example {

    static class Test01 extends Number {

        @Override
        public int intValue() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public long longValue() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public float floatValue() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public double doubleValue() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class Test02 extends Test01 {
    }

    public static void main(String[] args) {
        Short s = 15;
        Number n = s;
        Boolean b;
//        b = (Number instanceof s);
        b = (s instanceof Short);
        System.out.println("(s instanceof Short):  " + b);
        b = (s instanceof Number);
        System.out.println("(s instanceof Number): " + b);
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
        b = (n instanceof Short);
        System.out.println("(n instanceof Short):  " + b);
        b = (n instanceof Number);
        System.out.println("(n instanceof Number): " + b);
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
        Number test01 = new Test01();
        Number test02 = new Test02();
        Test02 test03 = new Test02();
        Test01 test04 = new Test02();
        b = (test01 instanceof Short);
        System.out.println("(test01 instanceof Short):  " + b);
        b = (test01 instanceof Test02);
        System.out.println("(test01 instanceof Test02): " + b);
        b = (test02 instanceof Short);
        System.out.println("(test02 instanceof Short):  " + b);
        b = (test02 instanceof Test02);
        System.out.println("(test02 instanceof Test02): " + b);
        b = (test03 instanceof Test01);
        System.out.println("(test02 instanceof Test01): " + b);
//        // Problem: Long ist keine Kindklasse von Test02
//        b = (test03 instanceof Long);
//        System.out.println("(test02 instanceof Long): " + b);
        b = (test04 instanceof Test02);
        System.out.println("(test04 instanceof Test02): " + b);
    }
}
