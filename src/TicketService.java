import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private List<Ticket> tickets = new ArrayList<>(10);

    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket(196, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "A", 10.5);
        Ticket ticket3 = new Ticket("Pantheon", 101, LocalDateTime.parse("2024-06-30T19:30:00").
                atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli());


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
