package MikkelGaming;

public interface CustomerDaoInterface {
    void readCustomer(int id) throws Exception;
    void readAllCustomers() throws Exception;
    void createCustomer(Customer customer) throws Exception;
}
