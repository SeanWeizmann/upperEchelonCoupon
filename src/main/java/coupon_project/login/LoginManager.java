package coupon_project.login;

import coupon_project.exceptions.LoginException;
import coupon_project.facade.AdminFacade;
import coupon_project.facade.ClientFacade;
import coupon_project.facade.CompanyFacade;
import coupon_project.facade.CustomerFacade;
import coupon_project.utils.DataUtils;

public class LoginManager {

    private static LoginManager instance = null;

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    public ClientFacade login(String email, String password, ClientType clientType) throws LoginException {
        switch (clientType) {
            case ADMINISTRATOR:
                ClientFacade adminFacade = new AdminFacade();
                if (!adminFacade.login(email, password)) {
                    throw new LoginException("Invalid user name or password");
                }
                System.out.println(DataUtils.getLocalDateTime() + " -" + email + "- was logged ");
                return adminFacade;

            case COMPANY:
                ClientFacade companyFacade = new CompanyFacade();
                if (!companyFacade.login(email, password)) {
                    throw new LoginException("Invalid user name or password");
                }
                System.out.println(DataUtils.getLocalDateTime() + " -" + email + "- was logged ");
                return companyFacade;

            case CUSTOMER:
                ClientFacade customerFacade = new CustomerFacade();
                if (!customerFacade.login(email, password)) {
                    throw new LoginException("Invalid user name or password");
                }
                System.out.println(DataUtils.getLocalDateTime() + " -" + email + "- was logged");
                return customerFacade;
        }
        return null;
    }
}
