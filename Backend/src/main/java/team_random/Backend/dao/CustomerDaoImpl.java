package team_random.Backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import team_random.Backend.model.Customer;
import team_random.Backend.model.Login;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void register(Customer customer) {
        String sql = "insert into users values(?,?,?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getPassword(), customer.getAddress());
    }

    @Override
    public Customer validateCustomer(Login login) {
        String sql = "select * from Customers where customer_name = ' " + login.getUsername()+ " ' and password = ' "+
                login.getPassword() + "'";
        List<Customer> customers = jdbcTemplate.query(sql,new CustomerMapper());
        return customers.size() > 0 ? customers.get(0) : null;
    }

    @Override
    public <S extends Customer> S save(S s) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    private class CustomerMapper implements RowMapper<Customer> {
        public Customer mapRow (ResultSet rs, int args1) throws SQLException{
            Customer customer = new Customer();
            customer.setName(rs.getString("customer_name"));
            customer.setPassword(rs.getString("password"));
            customer.setAddress(rs.getString("address"));
            return customer;
        }
    }
}
