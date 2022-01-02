package coupon_project.tester;

import coupon_project.beans.Company;
import coupon_project.beans.Customer;
import coupon_project.exceptions.InvalidException;
import coupon_project.exceptions.LoginException;
import coupon_project.exceptions.NoFoundException;
import coupon_project.exceptions.SomethingWentWrong;
import coupon_project.facade.AdminFacade;
import coupon_project.login.ClientType;
import coupon_project.login.LoginManager;
import coupon_project.utils.ArtUtils;
import coupon_project.utils.TablePrinter;
import org.checkerframework.checker.units.qual.C;


import static coupon_project.tester.Constants.*;

public class TestAdminFacade {
    AdminFacade admin;


    public void testAll() {
        System.out.println(ArtUtils.startTestingAdminFacade);
        testLogin();
        testAddCompany();
        testUpdateCompany();
        testDeleteCompany();
        testGetAllCompanies();
        testGetOneCompany();
        testAddCustomer();
        testUpdateCustomer();
        testDeleteCustomer();
        testGetAllCustomers();
        testGetOneCustomer();
    }


    public void testLogin() {
        System.out.println("========== test admin login ============");
        System.out.print("test login false: ");
        try {
            admin = (AdminFacade) LoginManager.getInstance()
                    .login("admin@admi.com", "admin", ClientType.ADMINISTRATOR);
            System.out.print("FAilED");
        } catch (LoginException e) {
            System.out.println( "(" + e.getMessage() + ")");
        }

        System.out.print("test login true: ");
        try {
            admin = (AdminFacade) LoginManager.getInstance()
                    .login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
            System.out.println("successes");
        } catch (LoginException e) {
            System.out.println("FAILED " + "(" + e.getMessage() + ")");
        }


    }

    public void testAddCompany() {
        try {
            System.out.println("==========test successful add company==========");
            admin.addCompany(COMPANY1);
            admin.addCompany(COMPANY2);
            admin.addCompany(COMPANY3);
            admin.addCompany(COMPANY4);
            System.out.println("companies added successfully");
            System.out.println("==========test failed add company==========");
            admin.addCompany(COMPANY1);
        } catch (InvalidException err) {
            System.out.println(err.getMessage());
        }
    }

    public void testUpdateCompany() {
        try {
            System.out.println("==========test successful update company==========");
            admin.updateCompany(new Company(COMPANY3.getId(), COMPANY3.getName(), "shekem@gmail.com", "7496"));
            System.out.println("Successful");
            System.out.println("==========test failed update company==========");
            admin.updateCompany(new Company(8, "wrong", "vcx@gmail.com", "456789"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            admin.updateCompany(new Company(COMPANY1.getId(), COMPANY1.getName(), COMPANY2.getEmail(), "00000"));
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

    public void testDeleteCompany() {
        try {
            System.out.println("==========test successful delete company==========");
            admin.deleteCompany(4);
            System.out.println("company deleted");
            System.out.println("==========test failed delete company==========");
            admin.deleteCompany(10);
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCompanies() {
        try {
            printTest("get all companies");
//            admin.getAllCompanies().forEach(System.out::println);
            TablePrinter.print(admin.getAllCompanies());
        } catch (SomethingWentWrong e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetOneCompany() {
        try {
            System.out.println("==========test successful get one company==========");
//            System.out.println(admin.getOneCompany(3));
            TablePrinter.print(admin.getOneCompany(1));
            System.out.println("==========test failed get one company==========");
            TablePrinter.print(admin.getOneCompany(10));
        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testAddCustomer() {
        try {
            printTest("successful add customer");
            admin.addCustomer(Constants.CUSTOMER1);
            admin.addCustomer(Constants.CUSTOMER2);
            admin.addCustomer(Constants.CUSTOMER3);
            System.out.println("successful");
            System.out.println("==========test failed add customer company==========");
            admin.addCustomer(CUSTOMER1);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testUpdateCustomer() {
        try {
            System.out.println("==========test successful update customer company==========");
            admin.updateCustomer(new Customer(CUSTOMER2.getId(), "Elon", "Mask", "elonmask@gmail.com", "456000"));
            System.out.println(SU);
            System.out.println("==========test failed update customer company==========");
            admin.updateCustomer(new Customer(10, "asdf","ret","sdf@asdf.com", "130"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }try {
            admin.updateCustomer(new Customer(1, "roho", "loho", "elonmask@gmail.com", "123789"));
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

    public void testDeleteCustomer() {
        try {
            System.out.println("==========test successful delete customer company==========");
            admin.deleteCustomer(3);
            System.out.println(SU);
            System.out.println("==========test failed delete customer company==========");
            admin.deleteCustomer(10);
        } catch (NoFoundException err) {
            System.out.println(err.getMessage());
        }
    }

    public void testGetAllCustomers() {
        try {
            printTest("get all customers");
//            admin.getAllCustomer().forEach(System.out::println);
            TablePrinter.print(admin.getAllCustomer());
        } catch (SomethingWentWrong err) {
            System.out.println(err.getMessage());
        }
    }

    public void testGetOneCustomer(){
        try {
            System.out.println("==========test successful get one customer==========");
//            System.out.println(admin.getOneCustomer(5));
            TablePrinter.print(admin.getOneCustomer(1));
            System.out.println("==========test failed get one company==========");
            TablePrinter.print(admin.getOneCustomer(10));
        }catch (NoFoundException err){
            System.out.println(err.getMessage());
        }
    }
}
