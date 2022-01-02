package coupon_project.beans;

import java.util.List;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Coupon> couponsList;

    // Constructor
    public Customer(int id, String firstName, String lastName, String email,
                    String password, List<Coupon> couponsList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.couponsList = couponsList;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Coupon> getCouponsList() {
        return couponsList;
    }

    // Setters
    public void setCouponsList(List<Coupon> couponsList) {
        this.couponsList = couponsList;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", couponsList=" + couponsList +
                '}';
    }
}
