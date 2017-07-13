package de.marcelhuber.pruefungsvorbereitung.ocp.chapter10;

/**
 *
 * @author Marcel Huber
 */
public class SingletonDemo {

    private Singleton singletonFuerTicketBuchung;

    public static void main(String[] args) {
        new SingletonDemo().go();
    }

    private void go() {
        singletonFuerTicketBuchung = Singleton.getINSTANCE();
        singletonFuerTicketBuchung.bookTickets("1A");
        singletonFuerTicketBuchung.bookTickets("1B");
        singletonFuerTicketBuchung.bookTickets("1C");
        singletonFuerTicketBuchung.bookTickets("1D");
        singletonFuerTicketBuchung.bookTickets("1A");
        singletonFuerTicketBuchung.bookTickets("1B");
        singletonFuerTicketBuchung.bookTickets("1C");
        singletonFuerTicketBuchung.bookTickets("1D");
        System.out.println("Die aktuell verbratenen Tickets:");
        System.out.println(singletonFuerTicketBuchung.getTicketCodes());
        try {
            singletonFuerTicketBuchung.getTicketCodes().add("HAHAHA");
        } catch (UnsupportedOperationException uoEx) {
            System.out.println("Manipulation der TicketCodes so nicht erlaubt!");
            uoEx.printStackTrace();
        }
    }
}
