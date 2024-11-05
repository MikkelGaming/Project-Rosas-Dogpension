package MikkelGaming;

public class Customer {

    private int id;
    private String name;
    private String cprNum;
    private String phoneNum;
    private String email;

    public Customer(String name, String cprNum, String phoneNum, String email)
    {
        this.name = name;
        this.cprNum = cprNum;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCprNum() {
        return cprNum;
    }

    public void setCprNum(String cprNum) {
        this.cprNum = cprNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
