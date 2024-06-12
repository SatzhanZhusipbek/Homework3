import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Ticket extends BaseTicket{

    private final BigDecimal TICKET_PRICE = BigDecimal.valueOf(100);

    private long time;

    @NullableWarning(key = "Variable [stadium_sector] is null in [Ticket]!”")
    private String stadiumSector;

    private String concertHall;

    private int eventCode;

    private boolean isPromo;

    private double weight;

    private LocalDateTime creationTime;

    private BigDecimal price;

    public Ticket(int ID, String concertHall, int eventCode, long time,
                  boolean isPromo, String stadiumSector, double weight) {
        super(ID);
        if (ID > 9999 ) {
            throw new IllegalArgumentException("The ID should be 4 digits max!");
        }
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("The concert hall should be 10 symbols max!");
        }
        if (eventCode > 999 ) {
            throw new IllegalArgumentException("The ID should be 3 digits max!");
        }
        if (!stadiumSector.contains("A") && !stadiumSector.contains("B") && !stadiumSector.contains("C")) {
            throw new IllegalArgumentException("The available stadium sectors are only A, B and C!");
        }
        this.time = time;
        this.stadiumSector = stadiumSector;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.isPromo = isPromo;
        this.weight = weight;
        creationTime = LocalDateTime.now();
        price = TICKET_PRICE;
        Ticket.allTickets().add(this);
    }

    public Ticket(String concertHall, int eventCode, long time) {
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("The concert hall should be 10 symbols max!");
        }
        if (eventCode > 999 ) {
            throw new IllegalArgumentException("The ID should be 3 digits max!");
        }
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        creationTime = LocalDateTime.now();
        price = TICKET_PRICE;
        Ticket.allTickets().add(this);
    }

    public Ticket() {
        creationTime = LocalDateTime.now();
        price = TICKET_PRICE;
        Ticket.allTickets().add(this);
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStadiumSector() {
        return this.stadiumSector;
    }

    public void setStadiumSector(String sector) {
        this.stadiumSector = sector;
    }

    public String getConcertHall() {
        return this.concertHall;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public boolean isPromo() {
        return this.isPromo;
    }

    public double getWeight() {
        return this.weight;
    }


    public void shared(String phone) {
        System.out.println("The ticket was shared by phone: "+phone);
    }

    public void shared(String phone, String email) {
        System.out.println("The ticket was shared by phone and email: "+phone
        +", "+email);
    }

    @Override
    public String toString() {
        return "Id: " + super.getID() + " Concert hall: " + concertHall +
                " event code: " + eventCode + " time: " +  LocalDateTime.
                ofInstant(Instant.ofEpochMilli(time),
                TimeZone.getDefault().toZoneId())
                + " stadium sector: " + stadiumSector;
    }

    @Override
    public String print() {
        return this.getClass().getName();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) obj;
        if (time != ticket.getTime()) {
            return false;
        }
        if (!stadiumSector.equals(ticket.getStadiumSector())) {
            return false;
        }
        if (!concertHall.equals(ticket.getConcertHall())) {
            return false;
        }
        if (eventCode!=ticket.getEventCode()) {
            return false;
        }

        if (isPromo != ticket.isPromo()) {
            return false;
        }
        return weight == ticket.getWeight();
    }

    @Override
    public int hashCode() {
        int result = getConcertHall().hashCode();
        result = 31 * result + getStadiumSector().hashCode();
        return result;
    }
}
