package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marcel Huber; 18.09.2017
 */
public class Regex {

    public static void main(String[] args) {
        String s01 = "ab";
        String s02 = "abaacbabc";
        Pattern p = Pattern.compile(s01);
        Matcher m = p.matcher(s02);
        while (m.find()) {
            System.out.println("von Position: " + m.start()
                    + " bis " + m.end() + " gefunden: " + m.group());
        }
    }
}
