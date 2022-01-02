package coupon_project.tester;

import coupon_project.beans.Category;
import coupon_project.beans.Coupon;
import coupon_project.exceptions.InvalidException;
import coupon_project.exceptions.LoginException;
import coupon_project.exceptions.NoFoundException;
import coupon_project.exceptions.SomethingWentWrong;
import coupon_project.facade.CompanyFacade;
import coupon_project.login.ClientType;
import coupon_project.login.LoginManager;
import coupon_project.utils.ArtUtils;
import coupon_project.utils.TablePrinter;
import static coupon_project.tester.Constants.*;
import java.time.LocalDate;

public class TestCompanyFacade {

    CompanyFacade companyFacade;
//    ArtUtils artUtils = new ArtUtils();

    public void testAll(){
        System.out.println(ArtUtils.startTestingCompany);
        testLogin();
        testAddCoupon();
        testUpdateCoupon();
        testDeleteCoupon();
        testGetAllCoupons();
        testGetAllCouponsForThatCompanyByCategory();
        testGetAllCouponsOfCompanyByMaxPrice();
        testGetCompanyDetails();
    }

    public void testLogin() {
        try {
            System.out.println("=========== test company login ===========");
            System.out.print("test login false: ");
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("bestbuy@gil.com", "1234", ClientType.COMPANY);
        }catch (LoginException err){
            System.out.println(err.getMessage());
        }
        try {
            System.out.print("test login true: ");
            companyFacade = (CompanyFacade) LoginManager.getInstance().login("bestbuy@gmail.com", "1234", ClientType.COMPANY);
        }catch (LoginException err){
            System.out.println(err.getMessage());
        }
    }

    public void testAddCoupon(){
        try{
            System.out.println("==========test successful add coupon==========");
            companyFacade.addCoupon(COUPON1);
            companyFacade.addCoupon(COUPON2);
            companyFacade.addCoupon(COUPON3);
            companyFacade.addCoupon(COUPON4);
            companyFacade.addCoupon(COUPON5);
            companyFacade.addCoupon(COUPON6);
            companyFacade.addCoupon(COUPON7);
            companyFacade.addCoupon(COUPON8);
            companyFacade.addCoupon(COUPON9);
            System.out.println("Coupons were added successfully");
            System.out.println("==========test failed add coupon==========");
            companyFacade.addCoupon(COUPON1);
        }catch (InvalidException err){
            System.out.println(err.getMessage());
        }
    }

    public void testUpdateCoupon(){
        try{
            printTest("successful update coupon");
            companyFacade.updateCoupon(new Coupon(6, 2, Category.ELECTRICITY, "market1", "popo",
                    startOfTheYear, endOfTheYear, 4, 65, "koko"));
            System.out.println(SU);
            printTest("failed update coupon");
            companyFacade.updateCoupon(new Coupon(8, 1, Category.ELECTRICITY, COUPON2.getTitle(), "popo",
                    LocalDate.now(), LocalDate.of(2022, 2, 4), 4, 65, "koko"));
        }catch (NoFoundException | InvalidException err){
            System.out.println(err.getMessage());
        }
        try {
            companyFacade.updateCoupon(new Coupon(1, 1, Category.ELECTRICITY, COUPON2.getTitle(), "popo",
                    LocalDate.now(), LocalDate.of(2022, 2, 4), 4, 65, "koko"));
        }catch (NoFoundException | InvalidException err){
            System.out.println(err.getMessage());
        }
    }

    public void testDeleteCoupon(){
        try {
            printTest("Successful delete coupon");
            companyFacade.deleteCoupon(7);
            companyFacade.deleteCoupon(8);
            System.out.println(SU);
            printTest("failed delete coupon");
            companyFacade.deleteCoupon(20);
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCoupons(){
        try {
            printTest("get all company's coupons");
//            System.out.println(companyFacade.getAllCoupons(2));
            TablePrinter.print(companyFacade.getAllCoupons(1));
        }catch (SomethingWentWrong err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCouponsForThatCompanyByCategory(){
        try {
//            System.out.println(companyFacade.getAllCouponsForThatCompanyByCategory(Category.FOOD, 3));
            printTest("Successful get company's coupons by category");
            TablePrinter.print(companyFacade.getAllCouponsForThatCompanyByCategory(Category.ELECTRICITY, 1));
            printTest("failed get company's coupons by category");
            TablePrinter.print(companyFacade.getAllCouponsForThatCompanyByCategory(Category.ELECTRICITY, 20));
        }catch (SomethingWentWrong err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCouponsOfCompanyByMaxPrice(){
        try {
            printTest("successful get company's coupons by max price");
//            System.out.println(companyFacade.getAllCouponsOfCompanyByMaxPrice(2, 48));
            TablePrinter.print(companyFacade.getAllCouponsOfCompanyByMaxPrice(1, 22.5));
            printTest("failed get company's coupons by max price");
            TablePrinter.print(companyFacade.getAllCouponsOfCompanyByMaxPrice(20, 22.5));
        }catch (SomethingWentWrong err){
        System.out.println(err.getMessage());
        }
    }

    public void testGetCompanyDetails(){
        try {
            printTest("successful get company detail");
//            System.out.println(companyFacade.getCompanyDetails(10));
            TablePrinter.print(companyFacade.getCompanyDetails(1));
            printTest("failed get company detail");
            TablePrinter.print(companyFacade.getCompanyDetails(20));
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }
}
