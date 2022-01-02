package coupon_project.tester;

import coupon_project.coupons_exterminator.DailyJob;
import coupon_project.facade.AdminFacade;

public class Tester {
    public static void main(String[] args) {

//        TestAdminFacade testAdminFacade = new TestAdminFacade();
//        testAdminFacade.testAll();
//        TestCompanyFacade testCompanyFacade = new TestCompanyFacade();
//        testCompanyFacade.testAll();
//
        TestCustomerFacade testCustomerFacade = new TestCustomerFacade();
        testCustomerFacade.testAll();

//        try {
//            DailyJob dailyJob = new DailyJob();
////            dailyJob.setDaemon(true);
//            dailyJob.start();
//            Thread.sleep(1000);
//            dailyJob.interrupt();
//        }catch (InterruptedException err){
//
//        }
    }
}
