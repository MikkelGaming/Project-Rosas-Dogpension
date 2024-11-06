package MikkelGaming;

public interface FeedingDaoInterface {
    boolean readSchedule(int id) throws Exception;
    String printSchedule(int id) throws Exception;
    void readAllSchedules() throws Exception;
    int createSchedule(FeedingSchedule schedule) throws Exception;
    void readFoodTypes() throws Exception;
}
