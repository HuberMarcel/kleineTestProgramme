package de.marcelhuber.pruefungsvorbereitung.ocp;

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

    MenschBuilder MenschBuilder(String name, int alter) {
        this.name = name;
        this.alter = alter;
        return this;
    }

    MenschBuilder wohnort(String wohnort) {
        this.wohnort = wohnort;
        return this;
    }

    MenschBuilder telefonnummer(String telefonummer) {
        this.telefonnummer = telefonummer;
        return this;
    }

    MenschBuilder statusVerheiratet(boolean statusVerheiratet) {
        this.statusVerheiratet = statusVerheiratet;
        return this;
    }

    public Mensch build() {
        return new Mensch(this);
    }
}
