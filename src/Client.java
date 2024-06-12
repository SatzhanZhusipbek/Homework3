public class Client implements User{

    @Override
    public String printRole() {
        return getClass().getName();
    }

    public void getTicket() {
        System.out.println("Getting a ticket");
    }
}
