package coupon_project.facade;

import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.dbDao.CouponsDBDAO;
import coupon_project.dbDao.CustomersDBDAO;
import coupon_project.exceptions.InvalidException;
import coupon_project.beans.Company;
import coupon_project.dbDao.CompaniesDBDAO;
import coupon_project.exceptions.NoFoundException;
import coupon_project.exceptions.SomethingWentWrong;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminFacade extends ClientFacade {


    public AdminFacade() {
        this.companiesDAO = new CompaniesDBDAO();
        this.couponsDAO = new CouponsDBDAO();
        this.customersDAO = new CustomersDBDAO();
    }

    public boolean login(String email, String password) {
        String emailCheck = "admin@admin.com";
        String passCheck = "admin";
        return email.equals(emailCheck) && passCheck.equals(password);
    }


    public synchronized void addCompany(Company company) throws InvalidException {
        try {
            if (companiesDAO.isCompanyExistsByName(company.getName())) {
                throw new InvalidException("Name already taken");
            }
            if (companiesDAO.isCompanyExists(company.getEmail())) {
                throw new InvalidException("Email already taken");
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        companiesDAO.addCompany(company);
    }


    public synchronized void updateCompany(Company company) throws InvalidException, NoFoundException {
        try {
            if (!companiesDAO.isCompanyExists(company))
                throw new NoFoundException("company does not exists");
            if (companiesDAO.isCompanyExists(company.getEmail()) && !(companiesDAO.getOneCompany(company.getId()).getEmail().equals(company.getEmail()))) {
//                Company companyFromDB = companiesDAO.getOneCompany(company.getId());
//                boolean isCompanyFromDBEmailEqualsToCompanyForUpdateEmail = company.getEmail().equals(companyFromDB.getEmail());
                throw new InvalidException("Email already taken");
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        companiesDAO.updateCompany(company);
    }

    public synchronized void deleteCompany(int companyId) throws NoFoundException {
        try {
            if (!companiesDAO.isCompanyExists(companyId)) {
                throw new NoFoundException("company does not exists");
            }
            List<Coupon> couponOfCompany = couponsDAO.getAllCompanyCoupons(companyId);
            for (Coupon coupon : couponOfCompany) {
                couponsDAO.deleteCouponPurchase(coupon.getId());
                couponsDAO.deleteCoupon(coupon.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        companiesDAO.deleteCompany(companyId);
    }

    public List<Company> getAllCompanies() throws SomethingWentWrong {
        try {
            return companiesDAO.getAllCompanies();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SomethingWentWrong(WRONG);
        }
    }

    public Company getOneCompany(int companyId) throws NoFoundException {
        try {
            if (!companiesDAO.isCompanyExists(companyId)) {
                throw new NoFoundException("Company with id " + companyId + " does not exists");
            }
            return companiesDAO.getOneCompany(companyId);
        } catch (SQLException e) {
            throw new SomethingWentWrong(WRONG);
        }
    }

    public synchronized void addCustomer(Customer customer) throws InvalidException {
        try {
            if (customersDAO.isCustomersExists(customer.getEmail())) {
                throw new InvalidException("Email already taken");
            }
        } catch (SQLException e) {
            throw new SomethingWentWrong("Something went wrong- Please try again later");
        }
        customersDAO.addCustomers(customer);
    }

    public synchronized void updateCustomer(Customer customer) throws NoFoundException, InvalidException {
        try {
            if (!customersDAO.isCustomersExists(customer.getId())) {
                throw new NoFoundException("customer with id " + customer.getId() + " does not exists");
            }
            if (customersDAO.isCustomersExists(customer.getEmail()) && !(customersDAO.getOneCustomer(customer.getId()).getEmail().equals(customer.getEmail()))) {
                throw new InvalidException("Email already taken");
            }
            customersDAO.updateCustomer(customer);
        } catch (SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }

    }

    public synchronized void deleteCustomer(int customerId) throws NoFoundException {
        try {
            if (!customersDAO.isCustomersExists(customerId)) {
                throw new NoFoundException("Customer does not exists");
            }
            couponsDAO.deleteCouponPurchaseByCustomerId(customerId);
            customersDAO.deleteCustomer(customerId);
        } catch (SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }
    }


    public List<Customer> getAllCustomer() throws SomethingWentWrong {
        try {
            return customersDAO.getAllCustomers();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            throw new SomethingWentWrong(WRONG);
        }
    }

    public Customer getOneCustomer(int customerId) throws NoFoundException {
        try {
            if (!customersDAO.isCustomersExists(customerId)) {
                throw new NoFoundException("Customer with ID " + customerId + " does not exists");
            }
            return customersDAO.getOneCustomer(customerId);
        } catch (SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }
    }

}
