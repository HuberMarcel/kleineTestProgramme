package de.marcelhuber.pruefungsvorbereitung.oca;

import java.util.*;
import javax.annotation.*;

/**
 *
 * @author Marcel Huber
 */
public class VokabularEnglischDeutschAnzeigen {

    List<String> fachwoerterBuch = new ArrayList<>();

    public static void main(String[] args) {
        new VokabularEnglischDeutschAnzeigen().go();
    }

    private void go() {
        VokabularEnglischDeutsch woerterBuch = new VokabularEnglischDeutsch();
//        System.out.println(woerterBuch.keySet());
        for (String wort : woerterBuch.keySet()) {
            fachwoerterBuch.add(wort);
        }
        Collections.sort(fachwoerterBuch);
//        System.out.println(fachwoerterBuch);
        ResourceBundle bundle = ResourceBundle.getBundle("de.marcelhuber.pruefungsvorbereitung.oca.VokabularEnglischDeutsch");
        long maxStringLength = 0;
        for (String wort : fachwoerterBuch) {
            if (wort.length() > maxStringLength) {
                maxStringLength = wort.length();
            }
        }
        maxStringLength = maxStringLength+1;
        for (String wort : fachwoerterBuch) {
            System.out.printf("%"+maxStringLength+"s - %s%n",wort,bundle.getString(wort));
        }
    }
}
