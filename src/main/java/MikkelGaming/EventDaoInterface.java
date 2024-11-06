package MikkelGaming;

public interface EventDaoInterface {
    void showAllLogs() throws Exception;
    void showAllEventTypes() throws Exception;
    void createEvent(DogEvent event) throws Exception;
}
