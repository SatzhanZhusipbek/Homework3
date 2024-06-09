import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {

    private final BigDecimal TICKET_PRICE = BigDecimal.valueOf(100);

    private int ID;

    private String concertHall;

    private int eventCode;

    private long time;

    private boolean isPromo;

    private String stadiumSector;

    private double weight;

    private LocalDateTime creationTime;

    private BigDecimal price;

    public Ticket(int ID, String concertHall, int eventCode, long time,
                  boolean isPromo, String stadiumSector, double weight) {
        if (ID > 9999 ) {
            throw new IllegalArgumentException("The ID should be 4 digits max!");
        }
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("The concert hall should be 10 symbols max!");
        }
        if (eventCode > 999 ) {
            throw new IllegalArgumentException("The ID should be 3 digits max!");
        }
        if (!stadiumSector.contains("A") || !stadiumSector.contains("B") || !stadiumSector.contains("C")) {
            throw new IllegalArgumentException("The available stadium sectors are only A, B and C!");
        }
        this.ID = ID;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.weight = weight;
        creationTime = LocalDateTime.now();
        price = TICKET_PRICE;
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
    }

    public Ticket() {
        creationTime = LocalDateTime.now();
        price = TICKET_PRICE;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
