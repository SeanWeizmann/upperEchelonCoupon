package coupon_project.tester;

import coupon_project.beans.Category;
import coupon_project.beans.Company;
import coupon_project.beans.Coupon;
import coupon_project.beans.Customer;

import java.time.LocalDate;

public class Constants {

    public static final String SU = "Successful";

    public static int thisYear = LocalDate.now().getYear();
    public static LocalDate endOfTheYear = LocalDate.of(thisYear, 12, 31);
    public static LocalDate startOfTheYear = LocalDate.of(thisYear, 1, 1);

    public static final Company COMPANY1 = new Company(1, "BestBuy", "bestbuy@gmail.com", "1234");
    public static final Company COMPANY2 = new Company(2, "McDonald's", "mcdonlad@gmail.com", "1234");
    public static final Company COMPANY3 = new Company(3, "Booking", "booking@gmail.com", "1234");
    public static final Company COMPANY4 = new Company(4, "roho", "loho@gmail.com", "1234");

    public static final Customer CUSTOMER1 = new Customer(1, "Bil", "Gates", "bilgates@gmail.com", "1234");
    public static final Customer CUSTOMER2 = new Customer(2, "Alicia", "Keys", "aliciakeys@gmail.com", "1234");
    public static final Customer CUSTOMER3 = new Customer(3, "Kanye", "West", "kanyewest@gmail.com", "1234");

    public static final Coupon COUPON1 = new Coupon(1, 1, Category.ELECTRICITY, "1+1McBook",
            "you buy one mc and get the other one for free",
            startOfTheYear, endOfTheYear, 4, 20, "image");

    public static final Coupon COUPON2 = new Coupon(2, 1, Category.ELECTRICITY, "1+1Iphone",
            "you buy one Iphone and get the other one for free",
            startOfTheYear, endOfTheYear, 4, 40, "image");

    public static final Coupon COUPON3 = new Coupon(3, 3, Category.VACATION, "20% discount on vacation",
            "get 20% discount on your next vacation",
            startOfTheYear, endOfTheYear, 4, 20, "image");

    public static final Coupon COUPON4 = new Coupon(4, 3, Category.VACATION, "jeep trip",
            "with the luxury jeep",
            startOfTheYear, endOfTheYear, 4, 40, "image");

    public static final Coupon COUPON5 = new Coupon(5, 2, Category.FOOD, "vegan meal",
            "why come to Mcdonald's if you're vegan",
            startOfTheYear, endOfTheYear, 4, 40, "image");


    public static final Coupon COUPON6 = new Coupon(6, 2, Category.FOOD, "kids meal",
            "with Tom and Jerry toys",
            startOfTheYear, endOfTheYear, 4, 40, "image");

    public static final Coupon COUPON7 = new Coupon(7, 2, Category.RESTAURANT, "MCoffee",
            "2 masala chai for 40 rupees :)",
            startOfTheYear, endOfTheYear, 4, 40, "image");

    public static final Coupon COUPON8 = new Coupon(6, 2, Category.RESTAURANT, "indian street food",
            "samosa or special tali with ginger lemon honey tea for 120 rupees :)",
            startOfTheYear, endOfTheYear, 4, 40, "image");

    public static final Coupon COUPON9 = new Coupon(9, 2, Category.FOOD, "sushi",
            "why come to Mcdonald's if you're vegan",
            startOfTheYear, endOfTheYear, 0, 40, "image");


    public static final void printTest(String s) {
        System.out.println("==========\ttest " + s + "\t==========");
    }
}
