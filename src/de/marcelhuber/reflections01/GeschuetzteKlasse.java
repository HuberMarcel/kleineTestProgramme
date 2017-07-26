package de.marcelhuber.reflections01;

/**
 *
 * @author Marcel Huber
 */
public class GeschuetzteKlasse {

    private Testobject testobject;
    private int irgendeinZaehler;
    private String irgendeinString;
    public final String offentlicherString = "GeschuetzteKlasse";

    public GeschuetzteKlasse() {
        this(new Testobject(), 1, "");
    }

    private GeschuetzteKlasse(Testobject testobject, int irgendeinZaehler, String irgendeinString) {
        this.testobject = testobject;
        this.irgendeinZaehler = irgendeinZaehler;
        this.irgendeinString = irgendeinString;
    }

    public Testobject getTestobject() {
        return testobject;
    }

    public int getIrgendeinZaehler() {
        return irgendeinZaehler;
    }

    public String getIrgendeinString() {
        return irgendeinString;
    }

    private void ichTueNix() {
        System.out.println("Ich tue nix, außer diesen Quatsch schreiben!");
    }

    @Override
    public String toString() {
        String returnString;
        returnString = "testobject: " + testobject
                + "\nirgendeinZaehler: " + irgendeinZaehler
                + "\nirgendeinString: " + irgendeinString
                + "\noeffentlicherString: " + offentlicherString;
        return returnString;
    }
}

class Testobject {

    private String testobjectName;

    public String getTestobjectName() {
        return testobjectName;
    }

    public void setTestobjectName(String testobjectName) {
        this.testobjectName = testobjectName;
    }
}
