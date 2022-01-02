package coupon_project.facade;

import coupon_project.dao.CompaniesDAO;
import coupon_project.dao.CouponsDAO;
import coupon_project.dao.CustomersDAO;

public abstract class ClientFacade {

    protected final String WRONG = "Something went wrong- Please try again later";
    protected CompaniesDAO companiesDAO;
    protected CouponsDAO couponsDAO;
    protected CustomersDAO customersDAO;

    public abstract boolean login(String userName, String password);

}
