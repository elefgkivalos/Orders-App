package gr.gkiv.orders.domain;

public class Customer {
    private long id;
    private String name;
    private String phoneNumber;

    public Customer() {

    }

    public Customer(long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
