package team_random.DBProject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
    Product findById(int id);
    List<Product> findByCategory(String category);

    @Query(value = "SELECT DISTINCT category FROM products ",nativeQuery = true)
    List<String> findAllCategories();

    void deleteByName(String name);

    @Query(value = "SELECT * FROM products ", nativeQuery = true)
    List<Product> findAllProducts();

    List<Product> findProductByNameContains(String input);

    List<Product> findAllBySalesperson_id(int salesperson_id);
}
