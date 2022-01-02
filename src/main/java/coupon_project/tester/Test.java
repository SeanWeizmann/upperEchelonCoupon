package coupon_project.tester;

import coupon_project.coupons_exterminator.DailyJob;
import coupon_project.db_util.ConnectionPool;
import coupon_project.db_util.DataBaseManager;

public class Test {

    public static void testAll(){
        try{
            DataBaseManager.reCreateAllTables();
            DailyJob dailyJob = new DailyJob();
            dailyJob.start();
            TestAdminFacade testAdminFacade = new TestAdminFacade();
            TestCompanyFacade testCompanyFacade = new TestCompanyFacade();
            TestCustomerFacade testCustomerFacade = new TestCustomerFacade();
            testAdminFacade.testAll();
            testCompanyFacade.testAll();
            testCustomerFacade.testAll();
            dailyJob.interrupt();
            ConnectionPool.getInstance().closeAllConnection();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

}
