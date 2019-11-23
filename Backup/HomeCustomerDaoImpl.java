package team_random.Backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import team_random.Backend.model.HomeCustomer;
import team_random.Backend.model.Login;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HomeCustomerDaoImpl implements HomeCustomerDao {
    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void register(HomeCustomer customer) {
        String sql = "insert into users values(?,?,?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getPassword(), customer.getAddress());
    }

    @Override
    public HomeCustomer validateCustomer(Login login) {
        String sql = "select * from HomeCustomers where customer_name = ' " + login.getUsername()+ " ' and password = ' "+
                login.getPassword() + "'";
        List<HomeCustomer> customers = jdbcTemplate.query(sql, new HomeCustomerMapper());
        return customers.size() > 0 ? customers.get(0) : null;
    }

    @Override
    public <S extends HomeCustomer> S save(S s) {
        return null;
    }

    @Override
    public <S extends HomeCustomer> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<HomeCustomer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<HomeCustomer> findAll() {
        return null;
    }

    @Override
    public Iterable<HomeCustomer> findAllById(Iterable<Integer> iterable) {
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
    public void delete(HomeCustomer homeCustomer) {

    }

    @Override
    public void deleteAll(Iterable<? extends HomeCustomer> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    private static class HomeCustomerMapper implements RowMapper<HomeCustomer> {
        public HomeCustomer mapRow (ResultSet rs, int args1) throws SQLException{
            HomeCustomer customer = new HomeCustomer();
            customer.setName(rs.getString("customer_name"));
            customer.setPassword(rs.getString("password"));
            customer.setAddress(rs.getString("address"));
            return customer;
        }
    }
}
