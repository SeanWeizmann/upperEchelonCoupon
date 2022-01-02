package coupon_project.db_util;

import java.sql.SQLException;

public class DataBaseManager {
    //    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String URL = "jdbc:mysql://localhost:3306/coupon_project?createDatabaseIfNotExist=true";

    public static final String USER_NAME = "root";
    public static final String USER_PASS = "12345678";

    public static final String CREATE_DB = "CREATE DATABASE IF NOT EXISTS coupon_project";
    public static final String DROP_DB = "DROP DATABASE coupon_project";
    public static final int MAX_CONNECTION = 10;
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `coupon_project` . `coupon` (\n" +
            " `number` INT NOT NULL AUTO_INCREMENT,\n" +
            " `discretion` VARCHAR(150) NOT NULL";

    public static final String DROP_TABLE = "DROP TABLE `coupon_project` , `coupon`";

    public static final String CREATE_COMPANIES_TABLE = "create table `companies`(\n" +
            "                    `id` int primary key auto_increment,\n" +
            "                    `name` varchar(30) not null,\n" +
            "                    `email` varchar(30) unique not null,\n" +
            "                    `password` varchar(30) not null\n" +
            ");";

    public static final String CREATE_CUSTOMERS_TABLE = "create table `customers`(\n" +
            "`id` int primary key auto_increment,\n" +
            "`first_name` varchar(30) not null,\n" +
            "`last_name` varchar(30) not null,\n" +
            "`Email` varchar(30) unique not null,\n" +
            "`password` varchar(30) not null\n" +
            ");";


    public static final String CREATE_COUPONS_TABLE = "create table `coupons` (\n" +
            "`id` int primary key auto_increment, \n" +
            "`company_id` int,\n" +
            "`category` varchar(30) not null,\n" +
            "`title` varchar(30) not null, \n" +
            "`description` varchar(200) not null, \n" +
            "`start_date` date not null, \n" +
            "`end_date` date not null, \n" +
            "`amount` int not null check (amount >= 0), \n" +
            "`price` double not null, \n" +
            "`image` varchar(300), \n" +
            "foreign key(`company_id`) references companies(`id`)" +
            ");";

    public static final String CREATE_CUSTOMERS_VS_COUPONS_TABLE = "create table `CUSTOMERS_VS_COUPONS` (\n" +
            "`customer_id` int, \n" +
            "`coupon_id` int, \n" +
            "primary key (customer_id, coupon_id), \n" +
            "foreign key (`customer_id`) references customers(`id`), \n" +
            "foreign key (`coupon_id`) references coupons(`id`) \n" +
            ");";

//    public static void createDataBase() throws SQLException {
//        DataBaseUtil.runQuery(CREATE_DB);
//    }

    public static void dropDataBase() throws SQLException {
        DataBaseUtil.runQuery(DROP_DB);
    }

    public static void createTable() throws SQLException {
        DataBaseUtil.runQuery(CREATE_COMPANIES_TABLE);
    }

    public static void dropTable() throws SQLException {
        DataBaseUtil.runQuery(DROP_TABLE);
    }

    public static void dropTable(String dropTableQuery) throws SQLException {
        DataBaseUtil.runQuery(dropTableQuery);
    }

    public static void dropTable(String... dropTableQuery) throws SQLException {
        for (String query : dropTableQuery) {
            DataBaseUtil.runQuery(query);
        }
    }

    public static void createTable(String createTableQuery) throws SQLException {
        DataBaseUtil.runQuery(createTableQuery);
    }

    public static void createAllTables() throws SQLException {
        createTable(CREATE_COMPANIES_TABLE);
        createTable(CREATE_CUSTOMERS_TABLE);
        createTable(CREATE_COUPONS_TABLE);
        createTable(CREATE_CUSTOMERS_VS_COUPONS_TABLE);
    }

    public static void reCreateAllTables() throws SQLException {
        String drop1 = "drop table customers_vs_coupons;";
        String drop2 = "drop table customers;";
        String drop3 = "drop table coupons;";
        String drop4 = "drop table companies;";
        dropTable(drop1, drop2, drop3, drop4);
        createTable(CREATE_COMPANIES_TABLE);
        createTable(CREATE_CUSTOMERS_TABLE);
        createTable(CREATE_COUPONS_TABLE);
        createTable(CREATE_CUSTOMERS_VS_COUPONS_TABLE);
    }

}
