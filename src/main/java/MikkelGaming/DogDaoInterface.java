package MikkelGaming;

public interface DogDaoInterface {
    boolean readDog(int id, boolean printDetails) throws Exception;
    boolean readDog(String name) throws Exception;
    void readAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
    void readAllDogsIdOnly() throws Exception;
    void updateDog(Dog dog) throws Exception;
    void deleteDog(int id) throws Exception;
    void printInfoCard(int id) throws Exception;
}
