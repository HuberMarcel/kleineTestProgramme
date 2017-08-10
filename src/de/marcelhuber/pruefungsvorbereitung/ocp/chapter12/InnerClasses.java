package de.marcelhuber.pruefungsvorbereitung.ocp.chapter12;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; letzte Änderung: 10.08.2017
 */
public class InnerClasses {

    private final String innerClassesName = "InnerClasses";

    public class InnerClassOfInnerClasses {

        private final String innerClassOfInnerClassesName
                = "innerClassOfInnerClassesName";

        @Override
        public String toString() {
            return "toString()-Methode der inneren Klasse, die äußere heißt: "
                    + innerClassesName + " und innere Klasse: "
                    + innerClassOfInnerClassesName;
        }
    }

    @Override
    public String toString() {
        return "toString()-Methode der äußeren Klasse, mit Namen: "
                + innerClassesName + " und innere Klasse: "
                + new InnerClassOfInnerClasses().innerClassOfInnerClassesName;
    }
}

class TestInnerClasses { //extends InnerClasses {

    public static void main(String[] args) {
        TestInnerClasses dummyObject = new TestInnerClasses();
        dummyObject.go01();
    }

    private void go01() {
        InnerClasses objectAeussereKlasse = new InnerClasses();
        // wenn man extends benutzt, reicht linkerhand 
        // InnerClassOfInnerClasses objectInnereKlasse 
        InnerClasses.InnerClassOfInnerClasses objectInnereKlasse 
                = new InnerClasses().new InnerClassOfInnerClasses();
        System.out.println("");
        System.out.println("");
        System.out.println(objectAeussereKlasse);
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
        System.out.println("");
        System.out.println(objectInnereKlasse);
        Marker.marker('_');
        Marker.marker('_');
    }
}
