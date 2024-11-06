package MikkelGaming;

public interface VetDaoInterface {
    boolean readVet(int id) throws Exception;
    String printVet(int id) throws Exception;
    void readAllVets() throws Exception;
}
