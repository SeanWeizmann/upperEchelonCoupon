package coupon_project.dbDao;

import coupon_project.beans.Customer;
import coupon_project.dao.CustomersDAO;
import coupon_project.db_util.DataBaseUtil;

import  java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomersDBDAO implements CustomersDAO {


    @Override
    public boolean isCustomerExits(String email, String pass) throws SQLException {
        String query = "select id from customers where email =\"" + email + "\" and password =\"" + pass + "\"";
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public boolean isCustomersExists(String email) throws SQLException {
        String query = "select id from customers where email =\"" + email + "\"";
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public boolean isCustomersExists(int customerId) throws SQLException {
        String query = "select id from customers where id =" + customerId;
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public void addCustomers(Customer customer) {
        String query = "insert into customers values(0,?,?,?,?);";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        DataBaseUtil.runQuery(query, params);

    }

    @Override
    public void updateCustomer(Customer customer) {
        String query = "Update customers Set first_name = ?, last_name = ? , Email = ? , password = ? where id = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        params.put(5, customer.getId());
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void deleteCustomer(int customerID) {
        String query = "DELETE FROM customers where id =" + customerID;
        DataBaseUtil.runQuery(query);
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        String query = "select id, first_name, last_name, Email from customers";
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()){
            int customerId = resultSet.getInt(1);
            String customerFirstName = resultSet.getString(2);
            String customerLastNme = resultSet.getString(3);
            String customerEmail = resultSet.getString(4);
            customers.add(new Customer(customerId, customerFirstName, customerLastNme, customerEmail));
        }
        return customers;
    }

    @Override
    public Customer getOneCustomer(int customerID) throws SQLException {
        String query = "select id, first_name, last_name, Email from customers where id =" + customerID;
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        resultSet.next();
        int customerId = resultSet.getInt(1);
        String customerFirstName = resultSet.getString(2);
        String customerLastName = resultSet.getString(3);
        String customerEmail = resultSet.getString(4);
        return new Customer(customerId, customerFirstName, customerLastName, customerEmail);
    }
}
