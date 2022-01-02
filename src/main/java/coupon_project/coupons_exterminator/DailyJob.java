package coupon_project.coupons_exterminator;

import coupon_project.beans.Coupon;
import coupon_project.dbDao.CouponsDBDAO;


import java.time.LocalDate;
import java.util.List;

public class DailyJob extends Thread {

    CouponsDBDAO couponsDBDAO = new CouponsDBDAO();
    private final long DAY = 1000 * 60 * 60 * 24;


    @Override
    public void run() {
        System.out.println("Daily has started");
        while (true) {
            try {
                LocalDate today = LocalDate.now();
                couponsDBDAO.deleteCouponPurchaseByEndDateBefore(today);
                couponsDBDAO.deleteCouponByEndDateBefore(today);
                Thread.sleep(DAY);
            } catch (InterruptedException e) {
                System.out.println("Daily Job exterminator shut down");
                break;
            }
        }

    }
}
