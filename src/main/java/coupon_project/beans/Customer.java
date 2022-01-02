package coupon_project.beans;

import java.util.List;
import java.util.Objects;

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

    public Customer(int id, String firstName, String lastName, String email,
                    String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Customer(String firstName, String lastName, String email,
                    String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Customer(int id, String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
                ", email='" + email +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(firstName, customer.firstName)
                && Objects.equals(lastName, customer.lastName)
                && Objects.equals(email, customer.email) && Objects.equals(password, customer.password)
                && Objects.equals(couponsList, customer.couponsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, couponsList);
    }
}
