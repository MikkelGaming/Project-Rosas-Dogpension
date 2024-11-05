package MikkelGaming;

public class FeedingSchedule {

    private int id;
    private int frequency;
    private int foodType;
    private int amount;

    public FeedingSchedule(int frequency, int foodType, int amount)
    {
        this.frequency = frequency;
        this.foodType = foodType;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
