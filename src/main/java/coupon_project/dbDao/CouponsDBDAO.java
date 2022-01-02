package coupon_project.dbDao;


import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.dao.CouponsDAO;
import coupon_project.db_util.DataBaseUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponsDBDAO implements CouponsDAO {


    @Override
    public void deleteCouponPurchaseByEndDateBefore(LocalDate endDate) {
        String query = "DELETE FROM customers_vs_coupons where coupon_id in (select id from coupons where end_date < ? )";
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, Date.valueOf(endDate));
        DataBaseUtil.runQuery(query, param);
    }

    @Override
    public List<Coupon> getAllCouponsOfCustomerByMaxPrice(int customerId, double maxPrice) throws SQLException {
        String query = "select * from coupons where price <=" + maxPrice + " and id in (select coupon_id from customers_vs_coupons where customer_id =" + customerId + ")";
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyID = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyID, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCustomerByCategory(int customerId, Category category) throws SQLException {
        String query = "select * from coupons where category =\"" + category + "\" and id in (select coupon_id from customers_vs_coupons where customer_id =" + customerId + ")";
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyID = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyID, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public boolean isCouponPurchasedByCustomer(int customerId, int couponId) throws SQLException {
        String query = "select * from customers_vs_coupons where customer_id =" + customerId + " and coupon_id =" + couponId;
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        System.out.println();
        return resultSet.next();
    }

    @Override
    public List<Coupon> getAllCustomerCoupons(int customerId) throws SQLException {
        String query = "select * from coupons where id in (select coupon_id from customers_vs_coupons where customer_id =" + customerId + ")";
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyID = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyID, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCompanyMaxPrice(int companyId, double maxPrice) throws SQLException {
        String query = "select * from coupons where company_id =" + companyId + " and price <=" + maxPrice;
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyID = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyID, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCompanyByCategory(int companyId, Category category) throws SQLException {
        String query = "select * from coupons where company_id =" + companyId + " and category =\"" + category + "\"";
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyID = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyID, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCompany(int companyId) throws SQLException {
        String query = "select * from coupons where company_id =" + companyId;
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyID = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyID, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public boolean isCouponExists(int couponId) throws SQLException {
        String query = "select id from coupons where id =" + couponId;
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public boolean isCouponExistsForThatCompany(int couponId, int companyId) throws SQLException {
        String query = "select id from coupons where id =" + couponId + " and company_id =" + companyId;
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public boolean isCouponTitleExistsInTheSameCompany(Coupon coupon) throws SQLException {
        String query = "select title from coupons where title  =\"" + coupon.getTitle() + "\"and company_id =" + coupon.getCompanyID();
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public void addCoupon(Coupon coupon) {
        String query = "insert into coupons value(0,?,?,?,?,?,?,?,?,?)";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategory().toString());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, Date.valueOf(coupon.getStartDate()));
        params.put(6, Date.valueOf(coupon.getEndDate()));
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void updateCoupon(Coupon coupon) {
        String query = "Update coupons Set company_id = ? , category = ? , title = ? , description = ? " +
                ", start_date = ?, end_date = ?, amount = ?, price = ?, image = ? where id = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategory().toString());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, Date.valueOf(coupon.getStartDate()));
        params.put(6, Date.valueOf(coupon.getEndDate()));
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        params.put(10, coupon.getId());
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void deleteCoupon(int couponId) {
        String query = "DELETE FROM coupons where id =" + couponId;
        DataBaseUtil.runQuery(query);
    }

    @Override
    public void deleteCouponByEndDateBefore(LocalDate endDate) {
        String query = "DELETE FROM coupons where end_date < ?";
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, Date.valueOf(endDate));
        DataBaseUtil.runQuery(query, param);
    }


    @Override
    public List<Coupon> getAllCoupons() throws SQLException {
        String query = "select id, company_id, category, title, description, start_date, end_date, amount, price, image from coupons";
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyId = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyId, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCompanyCoupons(int companyID) throws SQLException {
        String query = "select * from coupons where company_id=" + companyID;
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        List<Coupon> coupons = new ArrayList<>();
        while (resultSet.next()) {
            int couponId = resultSet.getInt(1);
            int companyId = resultSet.getInt(2);
            Category couponCategory = Category.valueOf(resultSet.getString(3));
            String title = resultSet.getString(4);
            String description = resultSet.getString(5);
            LocalDate startDate = LocalDate.parse(resultSet.getString(6));
            LocalDate endDate = LocalDate.parse(resultSet.getString(7));
            int amount = resultSet.getInt(8);
            int price = resultSet.getInt(9);
            String image = resultSet.getString(10);
            coupons.add(new Coupon(couponId, companyId, couponCategory, title, description, startDate, endDate, amount, price, image));
        }
        return coupons;
    }

    @Override
    public Coupon getOneCoupon(int couponId) throws SQLException {
        String query = "select id, company_id, category, title, description, start_date, end_date, amount, price, image from coupons where id=" + couponId;
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        resultSet.next();
        int couponID = resultSet.getInt(1);
        int companyId = resultSet.getInt(2);
        Category couponCategory = Category.valueOf(resultSet.getString(3));
        String title = resultSet.getString(4);
        String description = resultSet.getString(5);
        LocalDate startDate = LocalDate.parse(resultSet.getString(6));
        LocalDate endDate = LocalDate.parse(resultSet.getString(7));
        int amount = resultSet.getInt(8);
        int price = resultSet.getInt(9);
        String image = resultSet.getString(10);
        return new Coupon(couponID, companyId, couponCategory, title, description, startDate, endDate, amount, price, image);
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {
        String query = "insert into customers_vs_coupons value(?,?)";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {
        String query = "delete from customers_vs_coupons where customer_id = ? and coupon_id = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void deleteCouponPurchase(int couponId) {
        String query = "delete from customers_vs_coupons where coupon_id = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponId);
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void deleteCouponPurchaseByCustomerId(int customerId) {
        String query = "delete from customers_vs_coupons where customer_id = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerId);
        DataBaseUtil.runQuery(query, params);
    }
}
