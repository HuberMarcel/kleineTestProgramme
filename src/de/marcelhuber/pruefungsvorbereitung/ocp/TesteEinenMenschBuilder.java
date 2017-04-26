package de.marcelhuber.pruefungsvorbereitung.ocp;

/**
 *
 * @author Marcel Huber
 */
class TesteEinenMenschBuilder {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new TesteEinenMenschBuilder().go();
    }

    void go() {
        Mensch marcel
                = new MenschBuilder()
                .MenschBuilder("Marcel", 36)
                .statusVerheiratet(false)
                .telefonnummer("06 51 ** ** ** **")
                .wohnort("Trier").build();
        Mensch stefanBauer
                = new Mensch(
                        new MenschBuilder().MenschBuilder("Stefan Bauer", 12)
                        .statusVerheiratet(false).wohnort("An der Grenze")
                        .telefonnummer("xx xx xx xx xx xx"));
        System.out.println("");
        System.out.println(marcel);
        System.out.println("");
        System.out.println(stefanBauer);
    }

}
