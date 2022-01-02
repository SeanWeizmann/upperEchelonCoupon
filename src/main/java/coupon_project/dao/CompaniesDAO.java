package coupon_project.dao;

import coupon_project.beans.Company;

import java.sql.SQLException;
import java.util.List;

public interface CompaniesDAO {

    /**
     * This method allows you to check if company exists in the DB
     * @param userName -search by email
     * @param password -search by password
     * @return true if company exits
     * @throws SQLException if connection is lost
     */
    boolean isCompanyExists(String userName, String password) throws SQLException;

    /**
     * This method allows you to check if company exists in the DB
     * @param company -you can search by any fields of the object
     * @return true if company exists
     * @throws SQLException if the connection is lost
     */
    boolean isCompanyExists(Company company) throws SQLException;

    /**
     * This method allows you to check if company exists in the DB
     * @param companyId -search by ID
     * @return true if company Exists
     * @throws SQLException if the connection is lost
     */
    boolean isCompanyExists(int companyId) throws SQLException;

    /**
     * This method allows you to check if company exists in the DB
     * @param companyEmail -searching by Email
     * @return true if company exist
     * @throws SQLException if the connection is lost
     */
    boolean isCompanyExists(String companyEmail) throws SQLException;

    /**
     * This method allows you to check if company exists in the DB
     * @param companyName -searching by Name
     * @return true if company exist
     * @throws SQLException if the connection is lost
     */
    boolean isCompanyExistsByName(String companyName)throws SQLException;

    /**
     * This method allows you to add a company and Save it to the DB
     * @param company -creating new object
     */
    void addCompany(Company company);

    /**
     * This method allows you to update an existing company
     * @param company -update the object
     */
    void updateCompany(Company company);

    /**
     * This method allows you to delete a company
     * @param companyId -deleting by ID
     */
    void deleteCompany(int companyId);

    /**
     * This method shows you the companies from the DB
     * @return list of companies
     * @throws SQLException if the list is empty
     */
    List<Company> getAllCompanies() throws SQLException;

    /**
     * This method allows you to retrieve a specific company from the DB
     * @param companyId -retrieve by ID
     * @return single company
     * @throws SQLException if the ID is not exist
     */
    Company getOneCompany(int companyId) throws SQLException;

}
