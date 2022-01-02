package coupon_project.login;

import coupon_project.beans.Company;
import coupon_project.exceptions.InvalidException;
import coupon_project.exceptions.LoginException;
import coupon_project.facade.AdminFacade;

public class Tester {
    public static void main(String[] args) {
        //admin
        try {
            AdminFacade admin = (AdminFacade) LoginManager.getInstance()
                    .login("admin@admin.com","admin",ClientType.ADMINISTRATOR);
            System.out.println("User logged successfully");
        } catch (LoginException exception) {
            System.out.println(exception.getMessage());
        }




    }
}
