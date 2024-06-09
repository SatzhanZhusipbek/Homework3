import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private final List<Ticket> tickets;

    public TicketService(int capacity) {
        this.tickets = new ArrayList<>(capacity);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTicketsByStadiumSector(String stadiumSector) {
        List<Ticket> ticketsByStadiumSector = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (stadiumSector.equals(ticket.getStadiumSector())) {
                ticketsByStadiumSector.add(ticket);
            }
        }
        return ticketsByStadiumSector;
    }
}
