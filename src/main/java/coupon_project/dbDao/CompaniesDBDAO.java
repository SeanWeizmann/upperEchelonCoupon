package coupon_project.dbDao;


import coupon_project.beans.Company;
import coupon_project.dao.CompaniesDAO;
import coupon_project.db_util.DataBaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompaniesDBDAO implements CompaniesDAO {


    @Override
    public boolean isCompanyExists(String userName, String password) throws SQLException {
        String query = "select id from companies where email =\"" + userName + "\" and password =\"" + password + "\"";
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public boolean isCompanyExists(Company company) throws SQLException {
        String query = "select id from companies where id =" + company.getId();
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public boolean isCompanyExists(int companyId) throws SQLException {
        String query = "select id from companies where id =" + companyId;
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public boolean isCompanyExists(String companyEmail) throws SQLException {
        String query = "select id from companies where email =\"" + companyEmail + "\"";
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

    @Override
    public void addCompany(Company company) {
        String query = "insert into companies values(0,?,?,?);";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void updateCompany(Company company) {
        String query = "Update companies Set Email = ? , password = ? where id = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getEmail());
        params.put(2, company.getPassword());
        params.put(3, company.getId());
        DataBaseUtil.runQuery(query, params);
    }

    @Override
    public void deleteCompany(int companyId) {
        String query = "DELETE FROM companies where id =" + companyId;
        DataBaseUtil.runQuery(query);
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException {
        String query = "select id, name, Email from companies";
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        List<Company> companies = new ArrayList<>();
        while (resultset.next()) {
            int companyId = resultset.getInt(1);
            String companyName = resultset.getString(2);
            String companyEmail = resultset.getString(3);
            companies.add(new Company(companyId, companyName, companyEmail));
        }
        return companies;
    }

    @Override
    public Company getOneCompany(int companyId) throws SQLException {
        String query = "select id, name, Email from companies where id=" + companyId;
        ResultSet resultSet = DataBaseUtil.runQueryForResult(query);
        resultSet.next();
        int id = resultSet.getInt(1);
        String companyName = resultSet.getString(2);
        String companyEmail = resultSet.getString(3);
        return new Company(id, companyName, companyEmail);
    }

    public boolean isCompanyExistsByName(String name) throws SQLException {
        String query = "select id from companies where name = \"" + name + "\"";
        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
        return resultset.next();
    }

//    public boolean isCompanyExistsByEmail(String email) throws SQLException {
//        String query = "select id from companies where email =" + email;
//        ResultSet resultset = DataBaseUtil.runQueryForResult(query);
//        return resultset.next();
//    }

//    public void updateCompanyByAdmin(Company company) {
//        String query = "Update companies Set Email = ? where id = ?";
//        Map<Integer, Object> params = new HashMap<>();
//        params.put(1, company.getEmail());
//        params.put(4, company.getId());
//        DataBaseUtil.runQuery(query, params);
//    }
}
