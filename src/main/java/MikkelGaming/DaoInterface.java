package MikkelGaming;

public interface DaoInterface {
    void readDog(int id) throws Exception;
    void readAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
    void readCustomer(int id) throws Exception;
    void readAllCustomers() throws Exception;
    void createCustomer(Customer customer) throws Exception;
}
