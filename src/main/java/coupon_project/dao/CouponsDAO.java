package coupon_project.dao;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.dbDao.CompaniesDBDAO;
import org.checkerframework.checker.units.qual.C;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface CouponsDAO {


    /**
     * This method allows you to delete coupon purchase by end Date
     * @param endDate using Local date
     */
    void deleteCouponPurchaseByEndDateBefore(LocalDate endDate);
    /**
     * This method allows you to get customer's coupons by max price
     *
     * @param customerId -choosing customer by ID
     * @param maxPrice   -choosing the max price
     * @return list of coupons
     * @throws SQLException if customer does not exist
     */
    List<Coupon> getAllCouponsOfCustomerByMaxPrice(int customerId, double maxPrice) throws SQLException;

    /**
     * This method allows you to get customer's coupons by category
     *
     * @param customerId -choosing customer by ID
     * @param category   -Choosing category by enum
     * @return list of coupons
     * @throws SQLException if customer does not exist
     */
    List<Coupon> getAllCouponsOfCustomerByCategory(int customerId, Category category) throws SQLException;

    /**
     * This method allows you to check if specific customer purchased a specific coupon
     *
     * @param customerId -choosing customer by ID
     * @param couponId   -choosing coupon by ID
     * @return true if customer purchased that coupon
     * @throws SQLException if customer or coupon does not exist
     */
    boolean isCouponPurchasedByCustomer(int customerId, int couponId) throws SQLException;

    /**
     * This method allows you to get all customer's coupons
     *
     * @param customerId -choosing customer by ID
     * @return list of coupon
     * @throws SQLException if customer does not exist
     */
    List<Coupon> getAllCustomerCoupons(int customerId) throws SQLException;

    /**
     * This method allows you to get the company's coupon with the highest prices
     *
     * @param companyId -using company ID
     * @return list of coupons
     * @throws SQLException if the list is empty
     */
    List<Coupon> getAllCouponsOfCompanyMaxPrice(int companyId, double maxPrice) throws SQLException;

    /**
     * This method allows you to get company's coupons with the same category
     *
     * @param companyId -using company ID
     * @param category  -using Enum to choose category
     * @return list of coupon in the same company with the same category
     * @throws SQLException if list is empty
     */
    List<Coupon> getAllCouponsOfCompanyByCategory(int companyId, Category category) throws SQLException;

    /**
     * This method shows all coupons of the company
     *
     * @param companyId -choose company by ID
     * @return list of coupons
     * @throws SQLException if list is empty
     */
    List<Coupon> getAllCouponsOfCompany(int companyId) throws SQLException;

    /**
     * This method allows you to check if coupon exists in the DB
     *
     * @param couponId -searching by ID
     * @return true if coupon exists
     * @throws SQLException if ID is not exist
     */
    boolean isCouponExists(int couponId) throws SQLException;

    /**
     * This method allows you to check if this company has that specific coupon
     *
     * @param couponId  -choosing a company by ID
     * @param companyId -searching by ID
     * @return single object
     * @throws SQLException if coupon is not found
     */
    boolean isCouponExistsForThatCompany(int couponId, int companyId) throws SQLException;

    /**
     * This method allows you to check if there is the same title of coupon in the same company
     *
     * @param coupon -create/update a new object and equals them by their title
     * @return true if coupon with the same title is exist
     * @throws SQLException if connection is lost
     */
    boolean isCouponTitleExistsInTheSameCompany(Coupon coupon) throws SQLException;

    /**
     * This method allows tou to add coupon
     *
     * @param coupon creating new object
     */
    void addCoupon(Coupon coupon);

    /**
     * This method allows you to update an existing coupon
     *
     * @param coupon update the object
     */
    void updateCoupon(Coupon coupon);

    /**
     * This method allows you to delete coupon
     *
     * @param couponId -deleting by ID
     */
    void deleteCoupon(int couponId);

    void deleteCouponByEndDateBefore(LocalDate endDate);

    /**
     * This method shows you the coupons from the DB
     *
     * @return list of coupons
     * @throws SQLException if the list is empty
     */
    List<Coupon> getAllCoupons() throws SQLException;

    /**
     * This method allows you to get all coupons that belong to the same company
     *
     * @param companyID -searching by ID
     * @return list of coupons with the same company_id
     * @throws SQLException if there is no company with this ID
     */
    List<Coupon> getAllCompanyCoupons(int companyID) throws SQLException;

    /**
     * this method allows you to retrieve a specific coupon from the DB
     *
     * @param couponId -retrieve by ID
     * @return single coupon
     * @throws SQLException if the ID is not exists
     */
    Coupon getOneCoupon(int couponId) throws SQLException;

    /**
     * This method allows you to add coupon purchase to DB
     *
     * @param customerID -who buys the coupon
     * @param couponID   -which coupon the customer buys
     */
    void addCouponPurchase(int customerID, int couponID);

    /**
     * This method allows you to delete coupon purchase
     *
     * @param customerID -coupon that belong to this customer
     * @param couponID   -which coupon you want you delete
     */
    void deleteCouponPurchase(int customerID, int couponID);

    /**
     * This method allows you to delete coupon purchase by using coupon ID only
     *
     * @param couponId -delete by ID
     */
    void deleteCouponPurchase(int couponId);

    /**
     * This method allows you to delete coupon purchase by customer ID only
     *
     * @param customerId -delete by ID
     */
    void deleteCouponPurchaseByCustomerId(int customerId);
}
