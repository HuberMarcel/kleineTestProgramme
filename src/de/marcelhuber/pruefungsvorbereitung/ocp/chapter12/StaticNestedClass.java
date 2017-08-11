// Buch Seite 699 ff.
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter12;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; letzte Änderung: 11.08.2017
 */
public class StaticNestedClass {

    static private long x = 10;
    private long y = 20;

    static final class InnerStaticNestedClass {

        static private long innerX = 30;
        private long innerY = 40;

        public void testeMichInnerStatic() {
            System.out.println("testeMich");
        }

        static public void testeMichInnerStaticStatic() {
            System.out.println("testeMich - static");
            System.out.println(x);
//            // das folgende funktioniert NICHT!!
//            System.out.println(this.getY());
        }

        public static long getInnerX() {
            return innerX;
        }

        public long getInnerY() {
            return innerY;
        }
    }

    public void testeMich() {
        System.out.println("testeMich");
    }

    static public void testeMichStatic() {
        System.out.println("testeMich - static");
    }

    public static void main(String[] args) {
        StaticNestedClass dummyObject = new StaticNestedClass();
        dummyObject.go01();
        dummyObject.go02();
    }

    private void go01() {
        InnerStaticNestedClass objectInnerStaticNestedClass
                = new InnerStaticNestedClass();
        objectInnerStaticNestedClass.testeMichInnerStatic();
        objectInnerStaticNestedClass.testeMichInnerStaticStatic();
    }

    private void go02() {
        System.out.println("");
        System.out.println("go02()-Methode");
        Marker.marker('_');
        Marker.marker('_');
        InnerStaticNestedClass objectInnerStaticNestedClass
                = new InnerStaticNestedClass();
        System.out.println(objectInnerStaticNestedClass.getInnerY());
        System.out.println(objectInnerStaticNestedClass.innerY);
//        System.out.println(objectInnerStaticNestedClass.innerX);
        System.out.println(InnerStaticNestedClass.innerX);
//        System.out.println(objectInnerStaticNestedClass.getInnerX());
        System.out.println(InnerStaticNestedClass.getInnerX());
    }

    public long getY() {
        return y;
    }
}
