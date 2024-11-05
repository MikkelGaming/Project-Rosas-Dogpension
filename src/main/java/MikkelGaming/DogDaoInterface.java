package MikkelGaming;

public interface DogDaoInterface {
    void readDog(int id) throws Exception;
    void readAllDogs() throws Exception;
    void createDog(Dog dog) throws Exception;
    void createFeedingSchedule(FeedingSchedule fs) throws Exception;
    void readAllDogsIdOnly() throws Exception;
}
