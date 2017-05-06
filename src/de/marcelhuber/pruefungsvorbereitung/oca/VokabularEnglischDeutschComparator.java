package de.marcelhuber.pruefungsvorbereitung.oca;

import java.util.Comparator;
import java.util.Locale;



/**
 *
 * @author Marcel Huber
 */
public class VokabularEnglischDeutschComparator implements Comparator<String>{

    @Override
    public int compare(String string01, String string02) {
        return string01.toLowerCase().compareTo(string02.toLowerCase());
    }
    
}
