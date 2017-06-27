package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.Pause;
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
        // Buch Seite 435...
        // \d: Zahlen 0...9
        // \D: Alles ausser Zahlen 0...9
        // \s: whitespace-character: Leerzeichen, \t, \n, \f, \r
        // \S: Alles außer whitespace-character...
        // \w: Ein Wort-Buchstabe: {a-z, A-Z, 0...9, _} 
        // \W: Klar, analog zu oben
        // \b: Wortgrenze: Anfang/Ende des Strings und Wechsel zwischen \w und \W und umgekehrt
        // \B: Klar, analog zu oben
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\d", "a12c3e456f")));
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\D", "a12c3e456f")));
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\s", "a12c3e456f")));
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\S", "a12c3e456f")));
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\w", "a12c3e456f")));
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\W", "a12c3e456f")));
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\b", "a12c3e456f")));
        System.out.println(
                Arrays.toString(dummy.findRegexInString("\\B", "a12c3e456f")));
        System.out.println("");
        String beispielSatz = "Dies ist ein sehr interessanter Satz, der nun "
                + "in seinen einzelnen Wörtern ausgegeben werden soll!";
        String[] beispielSatzZerlegt;
//        beispielSatzZerlegt= beispielSatz.split("[e][i][n]");
//        beispielSatzZerlegt = beispielSatz.split("ein");
        beispielSatzZerlegt = beispielSatz.split(" ");
        for (String wort : beispielSatzZerlegt) {
            System.out.print(wort);
            Pause.breakInMillis(700);
            System.out.print("\r");
            // lösche/leere die Zeile in dem Bereich, wo das Wort war
            // ACHTUNG: Auf der Netbeans-Konsole wird immer die Zeile gelöscht, 
            //          zum Testen besser in der Windows-Konsole laufen lassen#
            //          dort sieht man, dass alte nichtüberschriebene Stelle
            //          "stehenbleiben"
            clearTheLine(wort.length());
        }
        System.out.println("");
    }

    private static void clearTheLine(int wortLaenge) {
        for (int k = 0; k < wortLaenge; k++) {
            System.out.print(" ");
        }
        System.out.print("\r");
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
//        System.out.println("Anzahl der gefundenen Treffer: "
//                + matcherLength + "!");
        while (matcher.find()) {
            ++matcherLength;
//            System.out.println("Treffer an Position: " + matcher.start());
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
