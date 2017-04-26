package de.marcelhuber.pruefungsvorbereitung.ocp.builder;

/**
 *
 * @author Marcel Huber
 */
class Mensch {

    private String name;                   // Pflichtattribut
    private int alter;                     // Pflichtattribut
    private String wohnort;
    private String telefonnummer;
    private boolean statusVerheiratet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public boolean isStatusVerheiratet() {
        return statusVerheiratet;
    }

    public void setStatusVerheiratet(boolean statusVerheiratet) {
        this.statusVerheiratet = statusVerheiratet;
    }

    @Override
    public String toString() {
        return toString(this);
    }

    public String toString(Mensch mensch) {
        String menschDaten
                = "Name:                 " + name
                + "\nAlter:              " + alter
                + "\nWohnort:            " + wohnort
                + "\nStatus verehelicht: " + statusVerheiratet
                + "\nTelefonnummer:      " + telefonnummer;
        return menschDaten;
    }

//    private Mensch(MenschBuilder mb) {
    Mensch(MenschBuilder mb) {
        this.name = mb.name;
        this.alter = mb.alter;
        this.wohnort = mb.wohnort;
        this.telefonnummer = mb.telefonnummer;
        this.statusVerheiratet = mb.statusVerheiratet;
    }
}
