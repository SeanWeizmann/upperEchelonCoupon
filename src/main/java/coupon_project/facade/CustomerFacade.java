package coupon_project.facade;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.dao.CustomersDAO;
import coupon_project.dbDao.CouponsDBDAO;
import coupon_project.dbDao.CustomersDBDAO;
import coupon_project.exceptions.InvalidException;
import coupon_project.exceptions.NoFoundException;
import coupon_project.exceptions.SomethingWentWrong;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CustomerFacade extends ClientFacade {

    public CustomerFacade() {
        this.customersDAO = new CustomersDBDAO();
        this.couponsDAO = new CouponsDBDAO();
    }

    @Override
    public boolean login(String userName, String password) {
        try {
            return customersDAO.isCustomerExits(userName, password);
        }catch (SQLException err){
            throw new SomethingWentWrong(WRONG);
        }
    }

    public synchronized void addCouponPurchase(int customerId, int couponId) throws NoFoundException, InvalidException {
        try {
            if (couponsDAO.isCouponPurchasedByCustomer(customerId, couponId)){
                throw new NoFoundException("This coupon has been purchased already");
            }
            Coupon couponDetail = couponsDAO.getOneCoupon(couponId);
            if (!(couponDetail.getAmount() >= 1)){
                throw new InvalidException("coupon amount is 0");
            }
            if (couponDetail.getEndDate().isBefore(LocalDate.now())){
                throw new InvalidException("coupons has expired");
            }
            couponDetail.setAmount(couponDetail.getAmount() -1);
            couponsDAO.updateCoupon(couponDetail);
            couponsDAO.addCouponPurchase(customerId, couponId);
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public List<Coupon> getAllCustomerCoupon(int customerId) throws NoFoundException {
        try{
            return couponsDAO.getAllCustomerCoupons(customerId);
        }catch (SQLException err){
            throw new NoFoundException("There is no found purchase coupon for this customer");
        }
    }

    public List<Coupon> getAllCustomerCouponsByCategory(int customerID, Category category) throws NoFoundException {
        try {
            return couponsDAO.getAllCouponsOfCustomerByCategory(customerID, category);
        }catch (SQLException err){
            throw new NoFoundException("Customer han no coupons of that category");
        }
    }

    public List<Coupon> getAllCustomerCouponsByMaxPrice(int customerId, double maxPrice) throws NoFoundException {
        try {
            return couponsDAO.getAllCouponsOfCustomerByMaxPrice(customerId, maxPrice);
        }catch (SQLException err){
            throw new NoFoundException("Customer has no coupons with above this price");
        }
    }

    public Customer getCustomerDetail(int customerId) throws NoFoundException {
        try {
            return customersDAO.getOneCustomer(customerId);
        }catch (SQLException err){
            throw new NoFoundException("Customer with ID " + customerId + " is not exist");
        }
    }
}
