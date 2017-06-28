package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.PressEnter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TesteRegexDemo {

    public static void main(String[] args) {
        TesteRegexDemo dummy = new TesteRegexDemo();
        dummy.go();
    }

    private void go() {
        zeigeUntersuchungsthema("d+ - mindestens einmaliges Vorkommen einer Ziffer 0...9");
        System.out.println("");
        regexInString("\\d+", "1 a12 234b");
        PressEnter.toContinue();
        System.out.println("\n");
        //
        zeigeUntersuchungsthema("d - einmaliges Vorkommen einer Ziffer");
        regexInString("\\d", "1 a12 234b");
        PressEnter.toContinue();
        System.out.println("\n");
        //
        zeigeUntersuchungsthema("d? - höchstens einmaliges (kein! oder einmal) Vorkommen einer Ziffer");
        regexInString("\\d?", "1 a12 234b");
//        regexInString("\\d?", "xa a1bc23xa abcxa");
        System.out.println(Pattern.matches("\\d?", "1 a12 234b"));
        System.out.println("");
        PressEnter.toContinue();
        System.out.println("\n");
        //
        zeigeUntersuchungsthema("d*[a-z]* - kein oder mehrmaliges Vorkommen von Ziffern gefolgt von beliebig vielen Kleinbuchstaben");
//        regexInString("\\d*", "1 a12 234b");
        regexInString("\\d*[a-z]*", "1112234fgdfg");
//        System.out.println(Pattern.matches("\\d*", "1 a12 234b"));
////        Pattern.matches("\\d*", "1 a12 234b") liefert false
        System.out.println(Pattern.matches("\\d*[a-z]*", "1112234fgdfg"));
        // Pattern.matches("\\d*[a-z]*", "1112234fgdfg"): Besteht der String rechts aus bel. vielen Ziffern gefolgt von beliebig vielen Kleinbuchstaben?
        System.out.println("");        
        PressEnter.toContinue();
        System.out.println("\n");
        //
        zeigeUntersuchungsthema("d*[a-z]? - kein oder mehrmaliges Vorkommen von Ziffern gefolgt von keinem oder einem Kleinbuchstaben");
//        regexInString("\\d*", "1 a12 234b");
        regexInString("\\d*[a-z]?", "1112234fgdfg");
        System.out.println(Pattern.matches("\\d*[a-z]?", "1112234fgdfg"));
        // Pattern.matches("\\d*[a-z]*", "1112234fgdfg"): Besteht der String rechts aus bel. vielen Ziffern gefolgt von maximal einem Kleinbuchstaben?
        System.out.println("");        
        PressEnter.toContinue();
        System.out.println("\n");
        //
        zeigeUntersuchungsthema("d*[a-z]? - kein oder mehrmaliges Vorkommen von Ziffern gefolgt von keinem oder einem Kleinbuchstaben");
//        regexInString("\\d*", "1 a12 234b");
        regexInString("\\d*[a-z]?", "1112234g");
        System.out.println(Pattern.matches("\\d*[a-z]?", "1112234g"));
        // Pattern.matches("\\d*[a-z]*", "1112234fgdfg"): Besteht der String rechts aus bel. vielen Ziffern gefolgt von maximal einem Kleinbuchstaben?
        System.out.println("");        
        PressEnter.toContinue();
        System.out.println("\n");
        //
    }

    private void regexInString(String regex, String wort) {
        RegexDemo dummy = new RegexDemo();
        long[] result;
        result = dummy.findRegexInString(regex, wort);
        String[] regexGroups = dummy.getRegexGroups();
        showTaskAndResult(regex, wort, result, regexGroups, true);
    }

    private void showTaskAndResult(String regex, String wort,
            long[] result, String[] regexGroups, boolean schleifenausgabe) {
        System.out.println("regex:               " + regex);
//        System.out.println("source:              " + wort);
        RegexDemo.zeigeStringUndDarunterDieStellen(wort);
        System.out.println("");
        System.out.println("Fundstellen:");
        System.out.println(Arrays.toString(result));
        System.out.println("Gruppen:");
        System.out.println(Arrays.toString(regexGroups));
        if (schleifenausgabe) {
            System.out.println("");
            Marker.marker();
            for (int k = 0; k < result.length; k++) {
                System.out.println("Fundstelle:     " + result[k]);
                System.out.println("Gefunden wurde: " + regexGroups[k]);
                if (k < result.length - 1) {
                    System.out.println("");
                }
            }
            Marker.marker();
        }
    }

    private void zeigeUntersuchungsthema(String thema) {
        System.out.println(thema);
        for (int k = 0; k < thema.length(); k++) {
            System.out.print("_");
        }
        System.out.println("");
    }
}
