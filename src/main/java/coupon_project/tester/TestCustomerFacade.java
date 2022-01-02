package coupon_project.tester;

import coupon_project.beans.Category;
import coupon_project.exceptions.InvalidException;
import coupon_project.exceptions.LoginException;
import coupon_project.exceptions.NoFoundException;
import coupon_project.facade.CustomerFacade;
import coupon_project.login.ClientType;
import coupon_project.login.LoginManager;
import coupon_project.utils.ArtUtils;
import coupon_project.utils.TablePrinter;
import static coupon_project.tester.Constants.*;

public class TestCustomerFacade {

    CustomerFacade customerFacade;

    public void testAll(){
        System.out.println(ArtUtils.startTestingCustomerFacade);
        testLogin();
        testAddCouponPurchase();
        testGetAllCustomerCoupons();
        testGetAllCustomerCouponsByCategory();
        testGetAllCustomerCouponByMaxPrice();
        testGetCustomerDetail();
    }

    public void testLogin(){
        try {
            System.out.println("========== test customer login ============");
            System.out.print("test customer login false: ");
            customerFacade = (CustomerFacade) LoginManager.getInstance().login("asd@gmail.com", "45612", ClientType.CUSTOMER);
        }catch (LoginException err){
            System.out.println(err.getMessage());
        }try {
            System.out.print("test customer login true: ");
            customerFacade = (CustomerFacade) LoginManager.getInstance().login(CUSTOMER1.getEmail(), CUSTOMER1.getPassword(), ClientType.CUSTOMER);
        }catch (LoginException err){
            System.out.println(err.getMessage());
        }
    }

    public void testAddCouponPurchase(){
        try{
            System.out.println("=========test successful add coupon purchase==========");
            customerFacade.addCouponPurchase(1, 1);
            customerFacade.addCouponPurchase(1, 2);
            customerFacade.addCouponPurchase(2, 6);
            customerFacade.addCouponPurchase(2, 5);
            System.out.println(SU);
            System.out.println("=========test failed add coupon purchase==========");
            customerFacade.addCouponPurchase(1,1);
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCustomerCoupons(){
        try {
            printTest("successful get all customer's coupons");
//            System.out.println(customerFacade.getAllCustomerCoupon(5));
            TablePrinter.print(customerFacade.getAllCustomerCoupon(1));
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCustomerCouponsByCategory(){
        try {
            printTest("successful get all customer's coupons by category");
//            System.out.println(customerFacade.getAllCustomerCouponsByCategory(2, Category.RESTAURANT));
            TablePrinter.print(customerFacade.getAllCustomerCouponsByCategory(1, Category.ELECTRICITY));
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCustomerCouponByMaxPrice(){
        try {
            printTest("successful get all customer's coupons by max price");
//            System.out.println(customerFacade.getAllCustomerCouponsByMaxPrice(2, 22));
            TablePrinter.print(customerFacade.getAllCustomerCouponsByMaxPrice(1, 22));
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetCustomerDetail(){
        try {
            printTest("successful get customer detail");
//            System.out.println(customerFacade.getCustomerDetail(10));
            TablePrinter.print(customerFacade.getCustomerDetail(1));
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }
}
