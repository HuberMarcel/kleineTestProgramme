package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class InstanceOfTest {

    public static void main(String[] args) {
        Familie family = new Familie();
        Familie familyKind = new Kind();
        Eltern eltern = new Eltern();
        Vater herbert = new Vater();
        Mutter gisela = new Mutter();
        Kind marcel = new Kind();
        boolean b1 = (marcel instanceof Familie);
        boolean b2 = (familyKind instanceof Kind);
//        // zwischen Eltern und Kind existiert keinerlei Vererbungsbeziehung,
//        // daher ist die folgende Zeile nicht möglich
//        boolean b3 = (marcel instanceof Eltern);
//        // analoge Begründung
//        boolean b4 = (marcel instanceof Vater);
        boolean b3 = (gisela instanceof Eltern);
        boolean b4 = (herbert instanceof Familie);
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
        System.out.println("b3: " + b3);
        System.out.println("b4: " + b4);
        System.out.println(family);
        System.out.println(eltern);
    }
}

class Familie {

    @Override
    public String toString() {
        return "Familie Huber";
    }
}

class Eltern extends Familie {

    @Override
    public String toString() {
        return "Eltern: Herbert und Gisela | " 
                + super.toString().split(" ")
                [super.toString().split(" ").length-1].toUpperCase();
    }
}

class Vater extends Eltern {
}

class Mutter extends Eltern {
}

class Kind extends Familie {
}
