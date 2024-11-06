package MikkelGaming;

public interface CustomerDaoInterface {
    boolean readCustomer(int id) throws Exception;
    void readAllCustomers() throws Exception;
    int createCustomer(Customer customer) throws Exception;
}
