package MikkelGaming;

import java.sql.Date;

public class Dog {
    public int id;
    public int customerID;
    public String name;
    public Date birthday;
    public String race;
    public String specialRequirements;
    public int preferredVetID;
    public int weight;
    public int expectedStay;
    public int feedingID;
    public String vaccines;
    public String fleaTreatment;
    public String insurance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public int getPreferredVetID() {
        return preferredVetID;
    }

    public void setPreferredVetID(int preferredVetID) {
        this.preferredVetID = preferredVetID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getExpectedStay() {
        return expectedStay;
    }

    public void setExpectedStay(int expectedStay) {
        this.expectedStay = expectedStay;
    }

    public int getFeedingID() {
        return feedingID;
    }

    public void setFeedingID(int feedingID) {
        this.feedingID = feedingID;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public String getFleaTreatment() {
        return fleaTreatment;
    }

    public void setFleaTreatment(String fleaTreatment) {
        this.fleaTreatment = fleaTreatment;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Dog(int customerID, String name, Date birthday, String race, String specialRequirements, int preferredVetID, int weight, int expectedStay, int feedingID)
    {
        this.customerID = customerID;
        this.name = name;
        this.birthday = birthday;
        this.race = race;
        this.specialRequirements = specialRequirements;
        this.preferredVetID = preferredVetID;
        this.weight = weight;
        this.expectedStay = expectedStay;
        this.feedingID = feedingID;

    }

    public Dog()
    {

    }
}
