import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {

        TicketService ticketService = new TicketService(10);
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket(196, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "A", 10.5);
        Ticket ticket3 = new Ticket("Pantheon", 101, LocalDateTime.parse("2024-06-30T19:30:00").
                atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli());

        Ticket ticket4 = new Ticket(196, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "A", 10.5);
        Ticket ticket5 = new Ticket(196, "Pantheon",
                101, LocalDateTime.parse("2024-06-30T19:30:00").atZone(ZoneId.of("Asia/Almaty")).
                toInstant().toEpochMilli(), false, "B", 10.5);

        ticketService.addTicket(ticket2);
        ticketService.addTicket(ticket4);
        ticketService.addTicket(ticket5);

        System.out.println(ticketService.getTicketsByStadiumSector("A").size());
        System.out.println(ticketService.getTicketsByStadiumSector("B").size());
        System.out.println(ticketService.getTicketsByStadiumSector("C").size());
    }
}
