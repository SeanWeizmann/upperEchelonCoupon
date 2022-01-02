package coupon_project.login;

import coupon_project.Exceptions.LoginException;
import coupon_project.facade.AdminFacade;

public class Tester {
    public static void main(String[] args) {
        //admin
        try {
            AdminFacade admin = (AdminFacade) LoginManager.getInstance()
                    .login("admin@admin.com","admin",ClientType.ADMINISTRATOR);
            System.out.println("User logged successfully");
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }


    }
}
