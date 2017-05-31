// Idee:
// Für eine ganze Zahl g > 1 und einen ganzzahligen Exponenten exp > 0 wollen
// wir g^{exp} ausrechnen. Sei exp = sum_{k=0}^n a_k 2^k die Binärdarstellung
// von exp. Dann gilt
//     g^{exp} = g^{sum_{k=0}^n a_k 2^k} = prod_{k=0}^n b_k
// mit b_r := 1, falls a_r = 0 und b_r := g^{2^r} für a_r = 1
// Ausserdem beachte man: 
//     g^{2^{r+1}} = g^{2 * 2^r} = (g^{2^r})^2
//
// Vergleiche: Buchmann, Einführung in die Kryptographie, 5. Auflage
// S. 38 / Kapitel 3.12
// TODO: Implementierung wie im Pseudo-Code auf Seite 39
//
//       pow(groupElement base, int exponent, groupElement result)
//       begin
//           result = 1
//           while (exponent > 0)
//               if (isEven(exponent) == false)
//                   result = result * base
//               base = base*base
//               exponent = exponent/2
//           end while
//       end
package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.Pause;
import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class SchnelleExponentiation {

    private long g;
    private long exp;
    private long m;            // modul
    private long ergebnis;     // hier wollen wir g^{exp} mod m speichern! 
    private long kontrollErgebnis;
    private long g_Potenz;
    private boolean zeigeHinweise;
    private long timeSchnelleExponentiation;
    private long timeNaiveExpontiation;

    public static void main(String[] args) {
        new SchnelleExponentiation().go();
    }

    private void go() {
        boolean wdh = true;
        while (wdh) {
            g = 0;
            exp = -1;
            m = 0;
            while (g < 2) {
                System.out.print("Geben Sie die Basis g > 1 ein:               ");
                g = ReadInput.readLong();
                if (g < 2) {
                    System.out.println("Es soll g > 1 sein... NEUER VERSUCH!\n");
                }
            }
            while (exp < 0) {
                System.out.print("Geben Sie den Exponenten exp >= 0 ein:       ");
                exp = ReadInput.readLong();
                if (exp < 0) {
                    System.out.println("Es soll exp >= 0 sein... NEUER VERSUCH!\n");
                }
            }
            while (m < 1) {
                System.out.print("Geben Sie das Modul m aus IN = IN \\{0} ein:  ");
                m = ReadInput.readLong();
                if (m < 1) {
                    System.out.println("Es soll m > 0 sein... NEUER VERSUCH!\n");
                }
            }
            //
            timeSchnelleExponentiation = System.nanoTime();
            calcSchnelleExponentiation(g, exp, m);
            timeSchnelleExponentiation = System.nanoTime() - timeSchnelleExponentiation;
            System.out.println("");
            System.out.println("Ergebnis:\n" + ergebnis
                    + " = " + g + "^{" + exp + "}  (mod " + m + ")");
            //
            timeNaiveExpontiation = System.nanoTime();
            calcNaiveExponentiation(g, exp, m);
            timeNaiveExpontiation = System.nanoTime() - timeNaiveExpontiation;
            System.out.println("Kontrollrechnung (naiv/aufwändig) liefert das Ergebnis:\n"
                    + kontrollErgebnis);
            if (ergebnis != kontrollErgebnis) {
                Pause.breakInSeconds(3);
                System.err.println("DA IST WAS SCHIEFGELAUFEN!");
            } else {
                System.out.println("WUNDERBAR:\nBeide Ergebnisse sind "
                        + "IDENTISCH!! :) :) :)");
                Pause.breakInSeconds(2);
            }
            System.out.println("");
            System.out.println("Zeit [s] für die schnelle Exponentiation: "
                    + (1.0 * timeSchnelleExponentiation) / 1_000_000_000);
            System.out.println("Zeit [s] für die naive Exponentiation:    "
                    + (1.0 * timeNaiveExpontiation) / 1_000_000_000);
            System.out.println("Verhältnis schnell/naiv:                  "
                    + (timeSchnelleExponentiation * 1.0 / timeNaiveExpontiation));
            System.out.println("");
            System.out.println("");
            Marker.marker();
            System.out.print("Wollen Sie eine weitere Berechnung durchführen "
                    + "(true = ja): ");
            wdh = ReadInput.readBoolean();
            if (wdh) {
                System.out.println("\n\n\n\n\n");
            }
        }
    }

    private long calcSchnelleExponentiation(long g, long exp, long m) {
        if (exp == 0) {
            return ergebnis = 1 % m;
        }
        List<List<Long>> expInBinaerdarstellungExponentenZiffern
                = new DecTogAddisch().calculateDecTogAddisch(exp, 2);
        List<Long> expInBinaerdarstellungExponenten
                = expInBinaerdarstellungExponentenZiffern.get(0);
        List<Long> expInBinaerdarstellungZiffern
                = expInBinaerdarstellungExponentenZiffern.get(1);
        if (zeigeHinweise) {
            System.out.println("Exponenten: " + expInBinaerdarstellungExponenten);
            System.out.println("Ziffern:    " + expInBinaerdarstellungZiffern);
            System.out.println("Hinweis: Da wir hier eine Binärdarstellung (des "
                    + "Exponenten) haben, und wir nur die Exponenten anzeigen,\n"
                    + "wenn die zugehörige Ziffer ungleich 0 (und damit 1) ist, "
                    + "genügt uns das Exponenten-Feld!");
            System.out.println("Es gilt also:");
            StringBuilder str = new StringBuilder();
            for (Long expo : expInBinaerdarstellungExponenten) {
                str.append("+ 2^{" + expo + "}");
            }
            str.delete(0, 2);
            System.out.println("exp = " + exp + " = " + str);
        }
        //
        // Berechne nun g^{exp} mod m effizient!
        List<Long> exponenten = expInBinaerdarstellungExponenten;
        // TODO: Morgen hier mal weitermachen...!!!
        g_Potenz = g % m;
        ergebnis = 1;
        long letztePosition = 0;
        for (int j = 0; j < exponenten.size(); j++) {
            for (long k = letztePosition; k < exponenten.get(j); k++) {
                g_Potenz *= g_Potenz;
                g_Potenz %= m;
            }
            ergebnis *= g_Potenz;
            ergebnis %= m;
            letztePosition = exponenten.get(j);
        }
        return ergebnis;
    }

    private long calcNaiveExponentiation(long g, long exp, long m) {
        kontrollErgebnis = 1 % m;
        for (int k = 0; k < exp; k++) {
            kontrollErgebnis *= g;
            kontrollErgebnis %= m;
//            System.out.println("k=" + k
//                    + "  --  kontrollErgebnis=" + kontrollErgebnis);
//            PressEnter.toContinue();
        }
        return kontrollErgebnis;
    }
}
