// Idee:
// Für eine ganze Zahl g > 1 und einen ganzzahligen Exponenten exp > 0 wollen
// wir g^{exp} ausrechnen. Sei exp = sum_{k=0}^n a_k 2^k die Binärdarstellung
// von exp. Dann gilt
//     g^{exp} = g^{sum_{k=0}^n a_k 2^k} = prod_{k=0}^n b_k
// mit b_r := 1, falls a_r = 0 und b_r := g^{2^r} für a_r = 1
// Ausserdem beachte man: 
//     g^{2^{r+1}} = g^{2 * 2^r} = (g^{2^r})^2
package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.Marker;
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

    public static void main(String[] args) {
        new SchnelleExponentiation().go();
    }

    private void go() {
        boolean wdh = true;
        while (wdh) {
            System.out.print("Geben Sie die Basis g > 1 ein: ");
            g = ReadInput.readLong();
            System.out.print("Geben Sie den Exponenten exp > 0 ein: ");
            exp = ReadInput.readLong();
            System.out.print("Geben Sie das Modul m aus IN ein: ");
            m = ReadInput.readLong();
            //
            calcSchnelleExponentiation(g, exp, m);
            //
            System.out.println("");
            Marker.marker();
            System.out.print("Wollen Sie eine weitere Berechnung durchführen "
                    + "(true = ja): ");
            wdh = ReadInput.readBoolean();
        }
    }

    private void calcSchnelleExponentiation(long g, long exp, long m) {
        List<List<Long>> expInBinaerdarstellungExponentenZiffern
                = new DecTogAddisch().calculateDecTogAddisch(exp, 2);
        List<Long> expInBinaerdarstellungExponenten
                = expInBinaerdarstellungExponentenZiffern.get(0);
        List<Long> expInBinaerdarstellungZiffern
                = expInBinaerdarstellungExponentenZiffern.get(1);
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
        //
        // Berechne nun g^{exp} mod m effizient!
        List<Long> exponenten = expInBinaerdarstellungExponenten;
        // TODO: Morgen hier mal weitermachen...!!!
    }
}
