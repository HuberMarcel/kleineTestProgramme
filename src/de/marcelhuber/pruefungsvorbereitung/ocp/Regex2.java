// OCP: Seite 466
package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marcel Huber; 06.09.2017
 */
public class Regex2 {

    public static void main(String[] args) {
        String str01 = "\\d*";
        String str02 = "ab34ef";
        Pattern p = Pattern.compile(str01);
        Matcher m = p.matcher(str02);
        while (m.find()) {
            System.out.println("start " + m.start());
            System.out.println("group " + m.group());
        }
    }
}
