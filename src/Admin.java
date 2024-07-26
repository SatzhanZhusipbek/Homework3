public class Admin implements User{

    @Override
    public String printRole() {
        return getClass().getName();
    }

    public void checkTicket() {
        System.out.println("Checking a ticket");
    }
}
