package coupon_project.dao;

import coupon_project.beans.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomersDAO {

    /**
     * This method allows you to check if customer exists in the DB
     * @param email -search by email
     * @param pass -search by password
     * @return true if company exists
     * @throws SQLException if the connection is lost
     */
    boolean isCustomerExits(String email, String pass) throws SQLException;

    /**
     * This method allows you to check if customer exists in the DB
     * @param email -searching by email only
     * @return true id customer exits
     * @throws SQLException if connection is lost
     */
    boolean isCustomersExists(String email) throws SQLException;

    /**
     * This method allows you to check if customer exists in the DB
     * @param customerId -searching by id only
     * @return true if customer exists
     * @throws SQLException if connection is lost
     */
    boolean isCustomersExists(int customerId) throws SQLException;

    /**
     * this method allows you to add customer and save it to the DB
     * @param customer -creating new object
     */
    void addCustomers(Customer customer);

    /**
     * This method allows you to update an existing company
     * @param customer -update an existing object
     */
    void updateCustomer(Customer customer);

    /**
     * This method allows you to delete a customer
     * @param customerID -deleting by ID
     */
    void deleteCustomer(int customerID);

    /**
     * This method shows you the customers from the DB
     * @return list of customers
     * @throws SQLException if the list is empty
     */
    List<Customer> getAllCustomers() throws SQLException;

    /**
     * This method allows you to retrieve a specific customer from the DB
     * @param customerID -retrieve by ID
     * @return single customer
     * @throws SQLException if the ID is not exist
     */
    Customer getOneCustomer(int customerID) throws SQLException;
}
