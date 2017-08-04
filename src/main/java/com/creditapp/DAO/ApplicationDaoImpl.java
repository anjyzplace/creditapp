package com.creditapp.DAO;

import com.creditapp.Entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


@Repository("mySql")
public class ApplicationDaoImpl implements ApplicationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class ApplicationRowMapper implements RowMapper<Application> {

        @Override
        public Application mapRow(ResultSet resultSet, int i) throws SQLException {
            Application application = new Application();
            application.setId(resultSet.getInt("id"));
            application.setFirstName(resultSet.getString("firstname"));
            application.setLastName(resultSet.getString("lastname"));
            application.setDateOfBirth(resultSet.getDate("dob"));
            application.setResStatus(resultSet.getString("resident_status"));
            application.setIncome(resultSet.getDouble("income"));
            application.setEmpStatus(resultSet.getString("employment_status"));
            application.setNoOfDependants(resultSet.getInt("no_of_dep"));
            application.setAddressYears(resultSet.getInt("address_years"));
            application.setAddressMonths(resultSet.getInt("address_months"));
            application.setCreditLimit(resultSet.getDouble("credit_limit"));
            return application;

        }
    }

    @Override
    @Qualifier("mySql")
    public List<Application> getApplications(){
        final String sql = "SELECT * FROM application";
        List<Application> applicationList = jdbcTemplate.query(sql, new ApplicationRowMapper());
        return applicationList;
    }

    @Override
    public Application Create(Application application) {
        final String sql = "INSERT INTO application (firstname, lastname, dob, resident_status, income," +
                " employment_status, no_of_dep, address_years, address_months, credit_limit  ) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";
        final String firstname = application.getFirstName();
        final String lastname = application.getLastName();
        final Date dob = application.getDateOfBirth();
        final String resident_status = application.getResStatus();
        final Double income = application.getIncome();
        final String employment_status = application.getEmpStatus();
        final int no_of_dep = application.getNoOfDependants();
        final int address_years = application.getAddressYears();
        final int address_months = application.getAddressMonths();
        final Double credit_limit = application.getCreditLimit();
        jdbcTemplate.update(sql, new Object[]{firstname, lastname, dob, resident_status, income, employment_status, no_of_dep, address_years, address_months, credit_limit });
        return application;
    }

    @Override
    public Application Update(Application application, int id) {
        final String sql = "UPDATE application SET firstname = ?, lastname = ?, dob = ?, resident_status = ?, income = ?, employment_status = ?, no_of_dep =?, address_years= ?, address_months= ?, credit_limit= ? WHERE id = ?";
        //final int id = application.getId();
        final String firstname = application.getFirstName();
        final String lastname = application.getLastName();
        final Date dob = application.getDateOfBirth();
        final String resident_status = application.getResStatus();
        final Double income = application.getIncome();
        final String employment_status = application.getEmpStatus();
        final int no_of_dep = application.getNoOfDependants();
        final int address_years = application.getAddressYears();
        final int address_months = application.getAddressMonths();
        final Double credit_limit = application.getCreditLimit();
        jdbcTemplate.update(sql, new Object[]{firstname, lastname, dob, resident_status, income, employment_status, no_of_dep, address_years, address_months, credit_limit, id});
        final String sql2 = "SELECT id, firstname, lastname, dob, resident_status, income, employment_status, no_of_dep, address_years, address_months, credit_limit FROM application WHERE id = ?";
        return jdbcTemplate.queryForObject(sql2, new ApplicationRowMapper(), id);
    }

    @Override
    public Application Delete(int id) {
        final String sqlinfo = "SELECT id, firstname, lastname FROM application WHERE id = ?";
        Application application = jdbcTemplate.queryForObject(sqlinfo, new ApplicationRowMapper(), id);
        final String sql = "DELETE FROM application WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return application;
    }

    @Override
    public Application getSingleApplication(int id) {
        final String sql = "SELECT * FROM application WHERE id = ?";
        Application application = jdbcTemplate.queryForObject(sql, new ApplicationRowMapper(), id);
        return application;
    }
}
