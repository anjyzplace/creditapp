package com.creditapp.DAO;

import com.creditapp.Entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            return application;

        }
    }

    @Override
    @Qualifier("mySql")
    public List<Application> getApplications(){
        final String sql = "SELECT id, firstname, lastname FROM application";
        List<Application> applicationList = jdbcTemplate.query(sql, new ApplicationRowMapper());
        return applicationList;
    }

    @Override
    public Application Create(Application application) {
        final String sql = "INSERT INTO application (firstname, lastname)  VALUES (?,?)";
        final String firstname = application.getFirstName();
        final String lastname = application.getLastName();
        jdbcTemplate.update(sql, new Object[]{firstname, lastname});
        return application;
    }

    @Override
    public Application Update(Application application) {
        final String sql = "UPDATE application SET firstname = ?, lastname = ? WHERE id = ?";
        final int id = application.getId();
        final String firstname = application.getFirstName();
        final String lastname = application.getLastName();
        jdbcTemplate.update(sql, new Object[]{firstname, lastname, id});
        final String sql2 = "SELECT id, firstname, lastname FROM application WHERE id = ?";
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
}
