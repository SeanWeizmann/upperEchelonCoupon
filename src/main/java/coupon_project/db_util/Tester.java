package coupon_project.db_util;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;
import coupon_project.dbDao.CompaniesDBDAO;
import coupon_project.dbDao.CouponsDBDAO;
import coupon_project.dbDao.CustomersDBDAO;
import coupon_project.utils.DataUtils;
import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) throws SQLException, InterruptedException {
//        String sql1 = "CREATE TABLE 'coupon";
//        String sql = "DELETE * FROM COUPON WHERE name LIKE %?% AND qty>? " +
//                "AND companyVIP=? ";
//        Map<Integer, Object> params = new HashMap<>();
//        params.put(1, "soup");
//        params.put(2, 4);
//        params.put(3, false);
//        DataBaseUtil.runQuery(sql, params);
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//
//        Connection maConnection = ConnectionPool.getInstance().getConnection();
//        maConnection.prepareStatement("sql");

//        DataBaseManager.createDataBase();

//        DataBaseManager.createAllTables();
//        DataBaseManager.reCreateAllTables();
        CompaniesDBDAO companiesDBDAO = new CompaniesDBDAO();
//        System.out.println(companiesDBDAO.isCompanyExists(new Company(1,"sean", "rishon", "sadf@sadf.com")));
//        System.out.println(companiesDBDAO.isCompanyExists(new Company(2,"sean", "rishon", "sadf@sadf.com")));
//        System.out.println(companiesDBDAO.isCompanyExists(new Company(1,"sean", "rishon", "sadf@sadf.com")));
//
//        System.out.println(companiesDBDAO.isCompanyExists(new Company(4,"sean", "rishon", "sadf@sadf.com")));
//        System.out.println(companiesDBDAO.isCompanyExists("dsfa@asdf.com"));
//        System.out.println(companiesDBDAO.isCompanyExists("sean@sean.com"));
//        companiesDBDAO.addCompany(new Company("sean", "asd@wer.com", "12345"));
//        companiesDBDAO.addCompany(new Company("Nitsan", "ewr@wer.com", "dfhgj"));
//        companiesDBDAO.updateCompany(new Company(1, "sean", "asdf@gamil.com", "454545" ));

//        companiesDBDAO.updateCompany(new Company(1, "retr", "re","787878"));
//        companiesDBDAO.deleteCompany(1);
//        DataUtils dataUtils = new DataUtils();

//        this.companyID = companyID;
//        this.category = category;
//        this.title = title;
//        this.description = description;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.amount = amount;
//        this.price = price;
//        this.image = image;
        CouponsDBDAO couponsDBDAO = new CouponsDBDAO();
//        couponsDBDAO.addCoupon(new Coupon(3, Category.FOOD, "vegan", "hagd", LocalDate.now(), LocalDate.now(),
//                20, 45, "foto"));
//        couponsDBDAO.updateCoupon(new Coupon(1, 3, Category.FOOD, "vegan", "hagd", LocalDate.now(),
//                LocalDate.now(), 20, 45, "photo"));

        CustomersDBDAO customersDBDAO = new CustomersDBDAO();
//        System.out.println(customersDBDAO.isCustomersExists("sean@sean.com"));
//        customersDBDAO.addCustomers(new Customer("kanye", "west", "sdfg@tyj.com", "123789"));
//         System.out.println(customersDBDAO.isCustomersExists("sdfg@tyj.com"));

//        customersDBDAO.updateCustomer(new Customer(1, "jey", "z", "jay@z.com","3146"));
//        companiesDBDAO.getAllCompanies().forEach(System.out::println);
//        System.out.println( companiesDBDAO.getOneCompany(3));
//        customersDBDAO.deleteCustomer(1);
//        customersDBDAO.addCustomers(new Customer("jay-z", "Z", "oj@story.nigga", "9876"));
//        System.out.println(customersDBDAO.getAllCustomers());
//        System.out.println(customersDBDAO.getOneCustomer(2));

//        couponsDBDAO.deleteCoupon(1);

//        couponsDBDAO.addCoupon(new Coupon(2, Category.VACATION, "have fun", "coupons for couples",
//                LocalDate.now(), LocalDate.now(), 10, 5000, "photo"));
//        couponsDBDAO.addCoupon(new Coupon(3, Category.ELECTRICITY, "never mind", "don't buy from us",
//                LocalDate.now(), LocalDate.now(), 2, 10, "foto"));


//        System.out.println(customersDBDAO.getAllCustomers());
//        couponsDBDAO.addCoupon(new Coupon(3, Category.RESTAURANT, "hguouogyuo", "shit", LocalDate.now(),
//                LocalDate.now(), 18, 45, "pic"));
//        System.out.println(couponsDBDAO.getAllCoupons());

//        couponsDBDAO.addCoupon(new Coupon(3, Category.FOOD, "tasty", "indian", LocalDate.now(),
//                LocalDate.now(), 10, 45, "roho"));
//        couponsDBDAO.addCoupon(new Coupon(3, Category.RESTAURANT, "small", "homemade", LocalDate.now(),
//                LocalDate.now(), 13, 78, "gloglo"));
//        System.out.println(couponsDBDAO.getAllCoupons());
//        System.out.println(couponsDBDAO.getOneCoupon(15));
//        couponsDBDAO.addCoupon(new Coupon(2, Category.ELECTRICITY, "hashmal", "Thunder", LocalDate.now(),
//                LocalDate.now(), 20, 350, "ACDC"));
//        System.out.println(couponsDBDAO.getAllCoupons());

//        couponsDBDAO.deleteCoupon(2);
//        couponsDBDAO.deleteCoupon(3);
//        couponsDBDAO.deleteCoupon(4);
//        couponsDBDAO.deleteCoupon(5);
//        couponsDBDAO.deleteCoupon(6);
//        couponsDBDAO.deleteCoupon(7);
//        couponsDBDAO.deleteCoupon(8);
//        couponsDBDAO.deleteCoupon(9);
//        couponsDBDAO.deleteCoupon(10);
//        couponsDBDAO.deleteCoupon(11);
//        couponsDBDAO.deleteCoupon(12);
//        couponsDBDAO.deleteCoupon(13);
//        couponsDBDAO.deleteCoupon(14);


//        System.out.println(couponsDBDAO.getOneCoupon(3));

//        couponsDBDAO.updateCoupon(new Coupon(18,3, Category.ELECTRICITY, "popo", "ozbakistan", LocalDate.now(),
//                LocalDate.now(), 17, 45, "lgog"));
//        couponsDBDAO.addCouponPurchase(2, 18);
//        couponsDBDAO.deleteCouponPurchase(2, 18);
//        customersDBDAO.updateCustomer(new Customer(4, "Jay-Z", "Z", "jayz@z.com", "852369"));
//        couponsDBDAO.addCouponPurchase(4, 16);

//        System.out.println(companiesDBDAO.isCompanyExists(new Company(54)));
//        System.out.println(companiesDBDAO.isCompanyExistsByName("sean"));
//        System.out.println(couponsDBDAO.getAllCompanyCoupons(3));
//        couponsDBDAO.addCouponPurchase(4,20);
//        couponsDBDAO.addCouponPurchase(5,20);
//        couponsDBDAO.addCouponPurchase(7,20);

//        couponsDBDAO.deleteCouponPurchaseByCustomerId(7);
//        System.out.println(customersDBDAO.isCustomerExits("sdfg@tyj.com", "12gf89"));
//        couponsDBDAO.addCouponPurchase(5, 23);

//        DataBaseManager.reCreateAllTables();



//        companiesDBDAO.addCompany(new Company("shosho", "asd@cds.com", "45678"));
//        companiesDBDAO.addCompany(new Company("tlutlu", "qwe@mli.com", "010236"));
//

//        couponsDBDAO.addCoupon(new Coupon(1, Category.FOOD, "good" ,"description", LocalDate.now(), LocalDate.now(), 1, 23, "image"));
//        couponsDBDAO.addCoupon(new Coupon(2, Category.ELECTRICITY, "bad" ,"description", LocalDate.now(), LocalDate.now(), 0, 29, "image"));

//        customersDBDAO.addCustomers(new Customer("sean" , "weiz", "sean@weiz.com", "102030"));
//        customersDBDAO.addCustomers(new Customer("kanye" , "west", "kanye@ye.com", "789456"));
//        customersDBDAO.addCustomers(new Customer("nitzan" , "theking", "nitzan@good.com", "147258"));
//        couponsDBDAO.addCouponPurchase(1, 2);
//        couponsDBDAO.addCoupon(new Coupon(1, Category.RESTAURANT, "tasty" ,"description",
//                LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 5), 5, 23, "image"));

//        System.out.println(couponsDBDAO.getAllCouponsOfCustomerByCategory(2, Category.FOOD));

//        System.out.println(couponsDBDAO.getAllCouponsOfCustomerByMaxPrice(2, 24));
//        couponsDBDAO.deleteCouponByEndDateBefore(LocalDate.now());
//        couponsDBDAO.deleteCouponPurchaseByEndDateBefore(LocalDate.now());
//        couponsDBDAO.addCoupon(new Coupon(1, Category.FOOD, "good" ,"description",
//                LocalDate.of(1900, 2, 12), LocalDate.of(2022, 1, 1), 1, 23, "image"));
//        couponsDBDAO.addCouponPurchase(1, 5);
    }
}
