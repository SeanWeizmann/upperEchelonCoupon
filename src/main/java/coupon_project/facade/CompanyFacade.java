package coupon_project.facade;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.dbDao.CompaniesDBDAO;
import coupon_project.dbDao.CouponsDBDAO;
import coupon_project.exceptions.InvalidException;
import coupon_project.exceptions.NoFoundException;
import coupon_project.exceptions.SomethingWentWrong;
import org.checkerframework.checker.units.qual.C;

import java.sql.SQLException;
import java.util.List;

public class CompanyFacade extends ClientFacade {

    public CompanyFacade() {
        this.companiesDAO = new CompaniesDBDAO();
        this.couponsDAO = new CouponsDBDAO();
    }

    @Override
    public boolean login(String userName, String password) {
        try {
            return companiesDAO.isCompanyExists(userName, password);
        } catch (SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }
    }

    public synchronized void addCoupon(Coupon coupon) throws InvalidException {
        try {
            if (couponsDAO.isCouponTitleExistsInTheSameCompany(coupon)) {
                throw new InvalidException("Coupon with the same title in the same company");
            }
            couponsDAO.addCoupon(coupon);
        } catch (SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }
    }

    public synchronized void updateCoupon(Coupon coupon) throws InvalidException, NoFoundException {
        try {
            if (!couponsDAO.isCouponExistsForThatCompany(coupon.getId(), coupon.getCompanyID())) {
                throw new NoFoundException("Coupon with id " + coupon.getId() + " does not belong to that company");
            }
            if (couponsDAO.isCouponTitleExistsInTheSameCompany(coupon) && !(couponsDAO.getOneCoupon(coupon.getId()).getTitle().equals(coupon.getTitle()))) {
                throw new InvalidException("Title already taken");
            }
            couponsDAO.updateCoupon(coupon);
        } catch (SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }

    }

    public synchronized void deleteCoupon(int couponId) throws NoFoundException {
        try {
            if (!couponsDAO.isCouponExists(couponId)) {
                throw new NoFoundException("coupon with ID " + couponId + " does not exists");
            }
            couponsDAO.deleteCouponPurchase(couponId);
            couponsDAO.deleteCoupon(couponId);
        } catch (SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }
    }

    public List<Coupon> getAllCoupons(int companyId){
        try {
           return couponsDAO.getAllCouponsOfCompany(companyId);
        }catch(SQLException err) {
            throw new SomethingWentWrong(WRONG);
        }
    }

    public List<Coupon> getAllCouponsForThatCompanyByCategory(Category category, int companyId){
        try {
          return couponsDAO.getAllCouponsOfCompanyByCategory(companyId, category);
        }catch (SQLException err){
            throw new SomethingWentWrong(WRONG);
        }
    }


    public List<Coupon> getAllCouponsOfCompanyByMaxPrice(int companyId, double maxPrice){
        try {
            return couponsDAO.getAllCouponsOfCompanyMaxPrice(companyId, maxPrice);
        }catch (SQLException err){
            throw new SomethingWentWrong(WRONG);
        }
    }

    public Company getCompanyDetails(int companyId) throws NoFoundException {
        try {
            if (!companiesDAO.isCompanyExists(companyId)){
                throw new NoFoundException("Company with id " + companyId + " does not exists");
            }
            return companiesDAO.getOneCompany(companyId);
        }catch (SQLException err){
            throw new SomethingWentWrong(WRONG);
        }
    }

}

