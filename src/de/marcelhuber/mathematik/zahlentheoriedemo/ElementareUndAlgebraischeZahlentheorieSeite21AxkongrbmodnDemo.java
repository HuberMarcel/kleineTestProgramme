package de.marcelhuber.mathematik.zahlentheoriedemo;

import de.marcelhuber.mathematik.zahlentheorie.ElementareUndAlgebraischeZahlentheorieSeite21Axkongrbmodn;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.ReadInput;

/**
 *
 * @author Marcel Huber
 */
public class ElementareUndAlgebraischeZahlentheorieSeite21AxkongrbmodnDemo {

    public static void main(String[] args) {
        long a;
        long b;
        long n;
        boolean erneuterDurchlauf = false;
        int eingabeErneuterDurchlauf;
        do {
            System.out.println("Aufgabe: Gesucht sind alle ganzzahligen Lösungen x "
                    + "der Kongruenz");
            System.out.println("\n    a * x kongruent b (mod n).");
            System.out.println("");
            System.out.print("Geben Sie a ein:     ");
            a = ReadInput.readLong();
            System.out.print("Geben Sie b ein:     ");
            b = ReadInput.readLong();
            do {
                System.out.print("Geben Sie n > 0 ein: ");
                n = ReadInput.readLong();
                if (!(n > 0)) {
                    System.out.println("n muss > 0 sein!");
                }
            } while (!(n > 0));
            ElementareUndAlgebraischeZahlentheorieSeite21Axkongrbmodn dummy
                    = new ElementareUndAlgebraischeZahlentheorieSeite21Axkongrbmodn();
            System.out.println("");
            if (!dummy.loeseDieKongruenzgleichung(a, b, n)) {
                System.out.println("Da ggT(" + a + "," + n + ") = " + dummy.getD()
                        + " kein Teiler von " + b + " ist, "
                        + "ist die genannte Kongruenz "
                        + "\n\n    " + a + " * x kongruent " + b + " (mod " + n + ")\n\n"
                        + "nicht lösbar!");
            } else {
                System.out.println("Die genannte Kongruenz"
                        + "\n\n    " + a + " * x kongruent " + b + " (mod " + n + ")\n\n"
                        + "hat modulo " + (n / dummy.getD()) + " die Lösung x = "
                        + dummy.getxKlassenGlobal() + ".");
                System.out.println("(Eine weitere Lösung wäre also bspw. x = "
                        + (dummy.getxKlassenGlobal() + (n / dummy.getD())) + ").");
            }
            if (b > n) {
                System.out.println("[Hinweis: ".toUpperCase()
                        + "Sie sollten b = " + b + " durch (b % n) = "
                        + b + " % " + n + " = " + (b % n)
                        + " ersetzen!)]");
            }
            System.out.println("Ende der Berechnung !!".toUpperCase());
            System.out.println("");
            System.out.println("");
            Marker.marker();
            System.out.println("");
            System.out.print("Wollen Sie eine weitere Rechnung durchführen "
                    + "(geben Sie die Zahl 1 für JA\nein oder eine andere für Abbruch!)?: ");
            eingabeErneuterDurchlauf = ReadInput.readIntWithExceptionHandling();
            if (eingabeErneuterDurchlauf == 1) {
                erneuterDurchlauf = true;
                System.out.println("");
                Marker.marker();
                System.out.println("");
                System.out.println("");
            } else {
                erneuterDurchlauf = false;
            }
        } while (erneuterDurchlauf);
    }
}
