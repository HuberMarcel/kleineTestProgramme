package de.marcelhuber.pruefungsvorbereitung.ocp.chapter10;

//import com.sun.javafx.collections.UnmodifiableListSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Marcel Huber
 */
public class Singleton {

    static private final Singleton INSTANCE;
    private Set<String> ticketCodes;
    private boolean newTicketIsBooked;

    static {
        INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public Singleton getInstance() {
        return INSTANCE;
    }

    public void bookTickets(String ticketCode) {
        if (ticketCodes == null) {
            ticketCodes = new HashSet<>();
        }
        int sizeOfBookedTickets = ticketCodes.size();
        ticketCodes.add(ticketCode);
        if (ticketCodes.size() == sizeOfBookedTickets + 1) {
            System.out.println("Ticket " + ticketCode + " gebucht!");
            newTicketIsBooked = true;
        } else {
            System.out.println("Für das Ticket " + ticketCode + " ist die Buchung "
                    + "fehlgeschlagen!");
            newTicketIsBooked = false;
        }
    }

    public boolean isNewTicketIsBooked() {
        return newTicketIsBooked;
    }

    public static Singleton getINSTANCE() {
        return INSTANCE;
    }

    public Set<String> getTicketCodes() {
        return Collections.unmodifiableSet(ticketCodes);
    }
}
