import java.util.ArrayList;
import java.util.List;

public abstract class BaseTicket {


    private int ID;

    private static final List<BaseTicket> allTickets = new ArrayList<>();

    public BaseTicket(int id) {
        this.ID = id;
    }
    public BaseTicket() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        ID = id;
    }

    public String print() {
        return "print content in console";
    }

    public abstract long getTime();

    public abstract void setTime(long time);

    public abstract String getStadiumSector();

    public abstract void setStadiumSector(String sector);

    public static List<BaseTicket> allTickets() {
        return allTickets;
    }
}
