import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicketService {
    private static final List<Ticket> tickets = new ArrayList<>();
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket(196, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "A", 10.5);
        Ticket ticket3 = new Ticket("Pantheon", 101, LocalDateTime.parse("2024-06-30T19:30:00").
                atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli());
        Ticket ticket4 = new Ticket(197, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "A", 10.5);
        Ticket ticket5 = new Ticket(198, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "A", 10.5);
        Ticket ticket6 = new Ticket(190, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "B", 10.5);
        Ticket ticket7 = new Ticket(191, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "B", 10.5);
        Ticket ticket8 = new Ticket(192, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "B", 10.5);
        Ticket ticket9 = new Ticket(193, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "B", 10.5);
        Ticket ticket10 = new Ticket(194, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "C", 10.5);
        Ticket ticket11 = new Ticket(187, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "C", 10.5);
        tickets.add(ticket11); tickets.add(ticket2); tickets.add(ticket3);
        tickets.add(ticket4); tickets.add(ticket5); tickets.add(ticket6);
        tickets.add(ticket7); tickets.add(ticket8); tickets.add(ticket9);
        tickets.add(ticket10);
        System.out.println(Ticket.allTickets());
        ticket1.shared("23771992736");
        ticket1.shared("87771992736", "megabrain@gmail.com");
        Client client = new Client();
        Admin admin = new Admin();
        System.out.println(client.printRole());
        System.out.println(admin.printRole());
        client.getTicket(); admin.checkTicket();
        Ticket ticket12 = new Ticket();

    }
    public static List<Ticket> ticketsByStadiumSector(String stadiumSector) {
        List<Ticket> searchedTickets = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (Objects.equals(tickets.get(i).getStadiumSector(), stadiumSector)) {
                searchedTickets.add(tickets.get(i));
            }
        }
        return searchedTickets;
    }

    public static Ticket getTicketById(int id) {
        Ticket searchedTicket = null;;
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getID()==id) {
                searchedTicket = tickets.get(i);
            }
        }
        return searchedTicket;
    }
}
