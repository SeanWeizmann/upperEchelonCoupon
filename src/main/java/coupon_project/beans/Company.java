package coupon_project.beans;

import java.util.List;
import java.util.Objects;

public class Company {

    /**
     * Fields of company
     */
    private int id;
    private String name;
    private String email;
    private String password;
    private List<Coupon> coupons;

    /**
     * Constructor
     * @param id -company ID
     * @param name -company's name
     * @param email -company's email
     * @param password -company's password
     * @param coupons -every company got coupons
     */
    public Company(int id, String name, String email, String password, List<Coupon> coupons) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.coupons = coupons;
    }

    /**
     * Constructor
     * @param id -company ID
     * @param name -company's name
     * @param email -company's email
     * @param password -company's password
     */
    public Company(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor
     * @param id -company ID
     * @param name -company's name
     * @param email -company's email
     */
    public Company(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Constructor
     * @param name -company's name
     * @param email -company's email
     * @param password -company's password
     */
    public Company(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    /**
     * Constructor with id only
     * @param id -company's ID
     */
    public Company(int id) {
        this.id = id;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    // Setters
    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    // ToString Method
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + "}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(name, company.name) && Objects.equals(email, company.email)
                && Objects.equals(password, company.password) && Objects.equals(coupons, company.coupons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, coupons);
    }
}
