package de.marcelhuber.pruefungsvorbereitung.ocp.chapter11;

/**
 *
 * @author Marcel Huber; letzte Änderung: 09.08.2017
 */
public class Mitglied<T extends Mitglied> implements Comparable<T> {

    private String name;
    private String vorname;
    private long beitrittsJahr;

    public Mitglied(String name, String vorname, long beitrittsjahr) {
        this.name = name;
        this.vorname = vorname;
        this.beitrittsJahr = beitrittsjahr;
    }

    @Override
    public int compareTo(T obj) {
        if (this.beitrittsJahr < obj.getBeitrittsJahr()) {
            return -1;
        }
        if (this.beitrittsJahr == obj.getBeitrittsJahr()) {
            if (this.name == obj.getName()) {
                return (this.vorname).compareToIgnoreCase(obj.getVorname());
            } else {
                return (this.name).compareToIgnoreCase(obj.getName());
            }
        }
        return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorName) {
        this.vorname = vorName;
    }

    public long getBeitrittsJahr() {
        return beitrittsJahr;
    }

    public void setBeitrittsJahr(long beitritsJahr) {
        this.beitrittsJahr = beitritsJahr;
    }

    public String toString() {
        String returnString;
        returnString = "Name: " + name + "; Vorname: " + vorname + "; "
                + "Beitrittsjahr: " + beitrittsJahr;
        return returnString;
    }
}
