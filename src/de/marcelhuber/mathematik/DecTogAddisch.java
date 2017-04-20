package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.ReadInput;
import de.marcelhuber.mathematischeHilfsprogramme.LongArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class DecTogAddisch {

    private long decNumber;
    private long gBase;

    public static void main(String[] args) {
        new DecTogAddisch().go();
    }

    private void go() {
        System.out.println("Geben Sie die Zahl (ohne Leerzeichen) in "
                + "Dezimalschreibweise ein:");
        decNumber = ReadInput.readLong();
        System.out.println("Ihre Eingabe: " + decNumber);
        hinweis();
        gBase = readGBase();
        List<Long>[] exponentenZiffern;
        exponentenZiffern = calculateDecTogAddisch(Math.abs(decNumber), gBase);
        Long[] exponentenAlsArray = new Long[exponentenZiffern[0].size()];
        exponentenZiffern[0].toArray(exponentenAlsArray);
        Long[] ziffernAlsArray = new Long[exponentenZiffern[1].size()];
        exponentenZiffern[1].toArray(ziffernAlsArray);
        System.out.println("Folgende Ziffern (für |" + decNumber + "|):");
        System.out.println(Arrays.toString(ziffernAlsArray));
        System.out.println("Die zur Basis " + gBase + " gehörigen Exponenten dieser Ziffern:");
        System.out.println(Arrays.toString(exponentenAlsArray));
        System.out.println("d.h. es gilt: ");
        if (decNumber != 0) {
            System.out.print(decNumber + " = " + (decNumber / Math.abs(decNumber))
                    + " * { ");
        } else {
            System.out.print(decNumber + " = { ");
        }
        for (int i = 0; i < exponentenAlsArray.length; i++) {
            System.out.print("" + ziffernAlsArray[i] + " * "
                    + gBase + "^(" + exponentenAlsArray[i] + ")");
            if (i < exponentenAlsArray.length - 1) {
                System.out.print(" + ");
            } else if (i == exponentenAlsArray.length - 1) {
                System.out.println(" }");
            }
        }
        System.out.println("\nÜbliche Zifferndarstellung (von links nach rechts "
                + "mit fallenden Potenzen,\nalso gespiegelt zu oben):");
        Long[] decInGaddischNotation
                = new Long[(int) ((long) (exponentenAlsArray[exponentenAlsArray.length - 1]) + 1)];
        // Wichtig: Long kann nicht in Integer geparset werden, aber Long kann in 
        // long und long dann in int geparset werden
        // Hinweis: das decInGaddischNotation-Objekt ist mit null-en vorinitialisiert,
        // da es durch new... auf dem Heap liegt!
        int counter = 0;
        for (int i = 0; i < ziffernAlsArray.length; i++) {
            // counter und die folgende while-Schleife, um anstatt null den
            // sinnvolleren Wert 0 zu sehen
            while (counter < exponentenAlsArray[i]) {
                decInGaddischNotation[counter] = 0L;
                counter++;
            }
            decInGaddischNotation[(int) (0 + exponentenAlsArray[i])] = ziffernAlsArray[i];
            counter++;
            // durch 0+... wird der Long-Wert in long geboxed
        }
        if (decNumber < 0) {
            System.out.print("-1 * ");
        }
//        System.out.println("{ Testausgabe vor Spiegelung:");
//        System.out.println(Arrays.toString(decInGaddischNotation) + " }");
//        PressEnter.toContinue();
//        decInGaddischNotation = (Long[]) mirrorMyArray(decInGaddischNotation);
        LongArray.MirrorTheArray(decInGaddischNotation);
        System.out.println(Arrays.toString(decInGaddischNotation) + "_" + gBase);
        System.out.println("d.h. es gilt: ");
        if (decNumber != 0) {
            System.out.print(decNumber + " = " + (decNumber / Math.abs(decNumber))
                    + " * { ");
        } else {
            System.out.print(decNumber + " = { ");
        }
        for (int i = 0; i < decInGaddischNotation.length; i++) {
            System.out.print("" + decInGaddischNotation[i] + " * "
                    + gBase + "^(" + (decInGaddischNotation.length - 1 - i) + ")");
            if (i < decInGaddischNotation.length - 1) {
                System.out.print(" + ");
            } else if (i == decInGaddischNotation.length - 1) {
                System.out.println(" }");
            }
            StringBuilder leerRaum = new StringBuilder("");
            for (long j = 0; j < 3 + (Long.toString(decNumber)).length(); j++) {
                leerRaum.append(" ");
            }
            if (i > 0 && i % 4 == 0) {
                System.out.println("");
                System.out.print(leerRaum);
            }
        }
        System.out.println("");
//        long[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
//        LongArray.MirrorTheArray(test);
//        System.out.println(Arrays.toString(test));
        long[] exponenten;
        long[] ziffern;
        exponenten = calculateDecTogAddischAsArray(Math.abs(decNumber), gBase)[0];
        ziffern = calculateDecTogAddischAsArray(Math.abs(decNumber), gBase)[1];
        System.out.println("\nExponenten mit der neuen Methode (für |"
                + decNumber + "| = " + Math.abs(decNumber) + "): ");
        System.out.println(Arrays.toString(exponenten));
        System.out.println("Ziffern mit der neuen Methode(für |"
                + decNumber + "| = " + Math.abs(decNumber) + "): ");
        System.out.println(Arrays.toString(ziffern));
    }

    private long[] floorLogDecDivideG(long dec, long g) {
        long[] exponentUndZiffer = new long[2];
        exponentUndZiffer[0] = -1; // an der Stelle 0 der Exponent
        long prod = 1;
        do {
            prod *= g;
            exponentUndZiffer[0]++;
        } while (prod <= dec);
        exponentUndZiffer[1] = dec / (long) Math.pow(g, exponentUndZiffer[0]);
//        System.out.println("Exponent: "+exponentUndZiffer[0]);
//        System.out.println("Ziffer: "+exponentUndZiffer[1]);
        return exponentUndZiffer;
    }

    private long readGBase() {
        do {
            System.out.println("Geben Sie die Basis g > 1 ein:");
            gBase = ReadInput.readLong();
            if (gBase > 1) {
                continue;
            }
            System.out.println("Sie müssen ene ganze Zahl > 1 eingeben!");
            System.out.println("Ihre letzte Eingabe war g: " + gBase);
            hinweis();
        } while (gBase <= 1);
        return gBase;
    }

    public List<Long>[] calculateDecTogAddisch(long dec, long g) {
        List<Long>[] exponentenZiffernListe = new ArrayList[2];
//        exponentenZiffernListe[0] = new ArrayList<Long>();
//        exponentenZiffernListe[1] = new ArrayList<Long>();
        List<Long> ziffern = new ArrayList<>();
        List<Long> exponenten = new ArrayList<>();
        long differenz = dec;

        long[] exponentZiffer = new long[2];

        do {
//            System.out.println("Exponent: " + floorLogDecDivideG(differenz, g)[0]);
//            System.out.println("Ziffer: " + floorLogDecDivideG(differenz, g)[1]);
            exponentZiffer = floorLogDecDivideG(differenz, g);
            exponenten.add(0, exponentZiffer[0]);
            ziffern.add(0, exponentZiffer[1]);
//            System.out.println(ziffern.get(0));
            differenz -= ziffern.get(0) * Math.pow(g, exponentZiffer[0]);
//            System.out.println("differenz: " + differenz);
//            PressEnter.toContinue();
        } while (differenz > 0);

        exponentenZiffernListe[0] = exponenten;
        exponentenZiffernListe[1] = ziffern;

//        Long[] testArray = new Long[ziffern.size()];
//        ziffern.toArray(testArray);
//        System.out.println(Arrays.toString(testArray));
        return exponentenZiffernListe;
    }

    public long[][] calculateDecTogAddischAsArray(long dec, long g) {
        // gleiches Ergebnis wie in calculateDecTogAddisch, nur dass
        // hier anstatt der Listen mit Longs ein Array von long-Arrays
        // returned wird; in exponnentenZiffernArrays[0] stehen die
        // Exponenten, in exponnentenZiffernArrays[1] die Ziffern
        List<Long>[] exponentenZiffern = calculateDecTogAddisch(dec, g);
//        for (int i = 0; i < exponentenZiffern[0].size(); i++) {
//            System.out.println("exponent: "+exponentenZiffern[0].get(i));
//            System.out.println("ziffer: "+exponentenZiffern[1].get(i));  
//        }
        Long[][] exponentenZiffernArraysL = new Long[2][1];
        long[][] exponentenZiffernArrays;
        exponentenZiffernArraysL[0][0] = 1L;
        exponentenZiffernArraysL[1][0] = 5L;

//////        so wäre es hier eigentlich sinnvoller!!
////        Long[][] exponentenZiffernArraysL = new Long[2][exponentenZiffern[0].size()];
////        long[][] exponentenZiffernArrays = new long[2][exponentenZiffern[1].size()];
////        exponentenZiffern[0].toArray(exponentenZiffernArraysL[0]);
////        exponentenZiffern[1].toArray(exponentenZiffernArraysL[1]);
//        die .toArray-Methode braucht anscheinend die exakte Feldgröße der Liste für
//        das Array!
        Long[] helpArray = new Long[exponentenZiffern[0].size()];
        exponentenZiffern[0].toArray(helpArray);
        exponentenZiffernArraysL[0] = helpArray;
        helpArray = new Long[exponentenZiffern[1].size()];
        exponentenZiffern[1].toArray(helpArray);
        exponentenZiffernArraysL[1] = helpArray;
        exponentenZiffernArrays = new long[2][Math.max(
                exponentenZiffernArraysL[0].length, exponentenZiffernArraysL[1].length)];
//        
        for (int i = 0; i < exponentenZiffernArraysL[0].length; i++) {
            exponentenZiffernArrays[0][i] = exponentenZiffernArraysL[0][i];
            exponentenZiffernArrays[1][i] = exponentenZiffernArraysL[1][i];
        }
        return exponentenZiffernArrays;
    }

    private void hinweis() {
        System.out.println("HINWEIS: Unsinnige Eingaben wurden zu 0 konvertiert!\n");
    }

    private Object[] mirrorMyArray(Object[] myArray) {
        Object[] myMirroredArray = new Object[myArray.length];
        if (myArray instanceof Long[]) {
            myMirroredArray = new Long[myArray.length];
        };
        for (int i = 0; i < myArray.length; i++) {
            myMirroredArray[i] = myArray[myArray.length - 1 - i];
        }
        return myMirroredArray;
    }
}
