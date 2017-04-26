package de.marcelhuber.pruefungsvorbereitung.ocp.builder;

/**
 *
 * @author Marcel Huber
 */
class MenschBuilder{

    String name;                   // Pflichtattribut
    int alter;                     // Pflichtattribut
    String wohnort;
    String telefonnummer;
    boolean statusVerheiratet;

    public MenschBuilder MenschBuilder(String name, int alter) {
        this.name = name;
        this.alter = alter;
        return this;
    }

    public MenschBuilder wohnort(String wohnort) {
        this.wohnort = wohnort;
        return this;
    }

    public MenschBuilder telefonnummer(String telefonummer) {
        this.telefonnummer = telefonummer;
        return this;
    }

    public MenschBuilder statusVerheiratet(boolean statusVerheiratet) {
        this.statusVerheiratet = statusVerheiratet;
        return this;
    }

    public Mensch build() {
        return new Mensch(this);
    }
}
