package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Marker;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marcel Huber
 */
public class RegexDemo {

    public static void main(String[] args) {
        RegexDemo dummy = new RegexDemo();
//        dummy.goRegex();
        String regex = "%T";
        String untersuchungsString = "Das %T ist %T ein String zum %TTesten!";
        long[] result = dummy.findRegexInString(regex, untersuchungsString);
        System.out.println("Fundstellen vom Regex\n"
                + "\n\t'" + regex + "'"
                + "\nim Untersuchungsstring\n"
                + "\n\t'" + untersuchungsString + "':");
        System.out.println(Arrays.toString(result));
        Marker.marker();
        System.out.println("Zum Vergleich:");
        zeigeStringUndDarunterDieStellen(untersuchungsString);
    }

    private void goRegex() {
        // Aufbau: Ein zu untersuchender String, bspw. hier: satz
        //         Ein Regex (regular expression - regulärer Ausdruck)
        //         Ein Pattern-Objekt-Compiler für den Regex
        //         Ein Matcher-Objekt für die Matches des Regex 
        //         Logik: pattern-Objekt wird mit regex kompiliert
        //                --> Pattern.compile(regex) der Klasse Pattern
        //                --> pattern.matcher(satz) liefert "Ergebnis der Untersuchung"

        String satz = "Ich bin ein interessanter % Satz, der % von einem Regex "
                + "untersucht werden soll!";
        Pattern pattern;
        // das Pattern Objekt soll den RegexExpression enthalten
        pattern = Pattern.compile("%");
        Matcher matcher = pattern.matcher(satz);
        while (matcher.find()) {
            System.out.println(matcher.start());
        }
    }

    public long[] findRegexInString(String regex, String untersuchungsString) {
        long[] result;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(untersuchungsString);
        int matcherLength = 0;
        while (matcher.find()) {
            ++matcherLength;
            System.out.println("Treffer an Position: " + matcher.start());
            System.out.println(matcherLength);
        }
//        matcher = pattern.matcher(untersuchungsString);
        matcher.reset();
        result = new long[matcherLength];
        int counter = 0;
        while (matcher.find()) {
            result[counter++] = matcher.start();
        }
        return result;
    }

    private static void zeigeStringUndDarunterDieStellen(String untersuchungsString) {
        System.out.println("Untersuchungsstring:");
        System.out.println(untersuchungsString);
        int stellenAnzahl = untersuchungsString.length();
        char zehnerZaehler = 'A';
        for (int k = 0; k < stellenAnzahl; k++) {
            if (k == 0 || k % 10 != 0) {
                System.out.print(k % 10);
            } else {
                System.out.print(zehnerZaehler++);
            }
        }
        System.out.println("");
    }
}
