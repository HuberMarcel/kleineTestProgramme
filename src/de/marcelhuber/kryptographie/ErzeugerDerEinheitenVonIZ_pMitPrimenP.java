package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.PrimzahlTest;
import de.marcelhuber.systemtools.Marker;
//import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Marcel Huber
 */
public class ErzeugerDerEinheitenVonIZ_pMitPrimenP {

    private long p;
    private long kleinsterErzeuger;
    private List<Long> teilerfremdeExponenten;
    private TreeSet<Long> mengeDerErzeuger;
    private TreeSet<Long> mengeDerErzeugerKontrolle;
    private TreeSet<Long> mengeDerEinheiten;               // damit bilden wir Mengendifferenzen am Ende
    TreeSet<Long> mengeDerEinheitenFix = new TreeSet<>();  
    // dient zum Iterieren über die 
    // fixe Menge der Einheiten

    public static void main(String[] args) {
        new ErzeugerDerEinheitenVonIZ_pMitPrimenP().go();
    }

    private void go() {
        boolean wdh = true;
        while (wdh) {
            boolean pIsPrim = false;
            PrimzahlTest pzTestDummy = new PrimzahlTest();
            do {
                System.out.print("Geben Sie eine Primzahl ein: ");
                p = ReadInput.readLong();
                String kontrolle = pzTestDummy.naiverPrimzahlTest(p);
                if (p < 1) {
                    pIsPrim = false;
                    System.out.println("Primzahlen sind aber >= 2.");
                } else {
                    pIsPrim = pzTestDummy.getIsPrim();
                }
                if (!pIsPrim) {
                    System.out.println("Das war keine Primzahl:\n"
                            + kontrolle);
                    System.out.println("Neuer Versuch...\n");
                }
            } while (!pIsPrim);
            // Hinweis: gerne mal p=17 testen, dann ist 2 kein Erzeuger, sondern 3
            System.out.println("Wir wollen alle Erzeuger der Gruppe "
                    + "(IZ/" + p + "*IZ)^x berechnen. Dazu finden wir einen ersten "
                    + "Erzeuger!");
            findeDenKleinstenErzeuger();
            System.out.println("");
            System.out.print("Wollen Sie einen weiteren Durchlauf des Programms? "
                    + "(true = ja): ");
            wdh = ReadInput.readBoolean();
            if (wdh) {
                System.out.println("");
            }
        }
    }

    private void findeDenKleinstenErzeuger() {
        TreeSet<Long> meineTestMenge = new TreeSet<>();
        for (long z = 1; z < p; z++) {
            meineTestMenge.clear();
            for (long exp = 0; exp < p - 1; exp++) {
//                meineTestMenge.add((long) (Math.pow(z, exp) % p));
                meineTestMenge.add(potenzModPeffizient(z, exp, p));
            }
//            System.out.println(meineTestMenge.size());
            if (meineTestMenge.size() == p - 1) {
                kleinsterErzeuger = z;
                break;
            }
        }
        System.out.println("Die Zahl " + kleinsterErzeuger + " erzeugt "
                + "die Menge der Einheiten (IZ/" + p + "*IZ)^x.");
        findeDieTeilerfremdenExponenten();
    }

    private void findeDieTeilerfremdenExponenten() {
        teilerfremdeExponenten = new ArrayList<>();
        GgT ggTDummy = new GgT();
        for (long exp = 1; exp < p; exp++) {
            // Hinweis: Buchmann, Einführung in die Kryptographie
            //          5. Auflage, Seite 36, Theorem 3.10.6
            //          man beachte: |(IZ/pIZ)^x| = p-1
            if (Math.abs(ggTDummy.ggTEuclid(exp, p - 1)) == 1) {
                teilerfremdeExponenten.add(exp);
            }
        }
        System.out.println("Dieses Array enthält alle zu " + (p - 1) + " teilerfremden "
                + "Zahlen: ");
        System.out.println(teilerfremdeExponenten);
        createMeineErzeuger();
    }

    private void createMeineErzeuger() {
        mengeDerErzeuger = new TreeSet<>();
        for (Long exp : teilerfremdeExponenten) {
//            System.out.println((long) (Math.pow(kleinsterErzeuger, exp)) % p);
//            mengeDerErzeuger.add((long) (Math.pow(kleinsterErzeuger, exp)) % p);
            mengeDerErzeuger.add(potenzModPeffizient(kleinsterErzeuger, exp, p));
        }
        System.out.println("");
        Marker.marker();
        System.out.println("Die Menge der Erzeuger von (IZ/" + p + "*IZ)^x "
                + "ist: " + mengeDerErzeuger);
        Marker.marker();
        System.out.println("");
        fazit();
    }

    private void fazit() {
        mengeDerEinheiten = new TreeSet<>();
        rebuildMengeDerEinheiten(mengeDerEinheiten);
        System.out.println("");
        Marker.marker();
        System.out.println("Die Einheitengruppe (IZ/" + p + "*IZ)^x hat die Ordnung "
                + (p - 1) + ".");
        System.out.println("D.h., es ist phi(" + p + ") = " + (p - 1) + ".");
        System.out.println("Die Anzahl der Erzeuger von (IZ/" + p + "*IZ)^x ist aber "
                + "nicht phi(" + p + "), sondern phi(" + (p - 1) + ").");
        System.out.println("Es ist also:                      phi(" + (p - 1) + ") = " + mengeDerErzeuger.size() + ".");
        System.out.println("Kontrolle: teilerfremdeExponenten.size() = "
                + teilerfremdeExponenten.size());
        Marker.marker();
        System.out.println("");
        System.out.println("");
        kontrollRechnung();
    }

    private void kontrollRechnung() {
        Marker.marker();
        System.out.println("!! Komplette Kontrollrechnung !!");
        Marker.marker();
        System.out.println("");
        TreeSet<Long> U = new TreeSet<>();
        rebuildMengeDerEinheiten(mengeDerEinheitenFix);
        mengeDerErzeugerKontrolle = new TreeSet<>();

        for (Long einheit : mengeDerEinheitenFix) {
            U.clear();
            for (long exp = 0; exp < p; exp++) {
                U.add(potenzModPeffizient(einheit, exp, p));
            }
            System.out.println("U = U(" + einheit + ") = " + U);
            System.out.print("(IZ/" + p + "*IZ)^x \\ + " + U + " = ");
            mengeDerEinheiten.removeAll(U);
            System.out.print(mengeDerEinheiten);
//            PressEnter.toContinue();
            System.out.print(" ==> " + einheit);
            if (mengeDerEinheiten.isEmpty()) {
                System.out.println(" ist ein Erzeuger von (IZ/" + p + ")^x!");
                mengeDerErzeugerKontrolle.add(einheit);
            } else {
                System.out.println(" ist KEIN Erzeuger von (IZ/" + p + ")^x!");
            }
            rebuildMengeDerEinheiten(mengeDerEinheiten);
            System.out.println("Kontrolle: Wir hatten die Menge der Erzeuger eben berechnet "
                    + "zu: " + mengeDerErzeuger);
            System.out.println("Nach der jetzigen Kontrollrechnung:                         "
                    + "    " + mengeDerErzeugerKontrolle);
//            System.out.println(potenzModPeffizient(10, 3, p));
        }
    }

    private void rebuildMengeDerEinheiten(TreeSet<Long> mengeDerEinheiten) {
        for (long k = 1; k < p; k++) {
            mengeDerEinheiten.add(k);
        }
    }

    // (Math.pow(einheit,exp) % p) wird relativ schnell *falsch berechnend*
    // in der untigen Methode bleiben die Zahlen "klein", i.W. unabhängig von der
    // "Größe" des Exponenten 
    private long potenzModPeffizient(long einheit, long exp, long p) {
        long returnValue;
        if (exp == 0) {
            returnValue = 1;
        } else {
            returnValue = einheit % p;
            for (int k = 0; k < exp - 1; k++) {
                returnValue *= einheit;
                returnValue = returnValue % p;
            }
        }
        return returnValue;
    }
}
