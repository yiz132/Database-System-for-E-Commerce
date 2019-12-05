package team_random.DBProject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import team_random.DBProject.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
    Product findById(int id);
    @Query(value = "SELECT * FROM products p WHERE p.category= ?1 ", nativeQuery = true)
    List<Product> findALLByCategory(String category);

    @Query(value = "SELECT DISTINCT category FROM products ",nativeQuery = true)
    List<String> findAllCategories();

    void deleteByName(String name);

    @Query(value = "SELECT * FROM products ", nativeQuery = true)
    List<Product> findAllProducts();

    List<Product> findProductByNameContains(String input);

    @Query(value = "SELECT * FROM products WHERE products.salesperson_id = ?1 ",nativeQuery = true)
    List<Product> findAllBySalesperson_id(int salesperson_id);

    @Query(value = "SELECT * FROM products WHERE products.salesperson_id = :id AND products.name LIKE %:keyword%", nativeQuery = true)
    List<Product> roughSearchForSalesperson(@Param("id") int id,
                                            @Param("keyword") String keyword);

    @Query(value ="SELECT * FROM products WHERE (:category = 'AllCategories' OR products.category=:category)  AND products.name LIKE %:keyword% ",nativeQuery = true)
    List<Product> sortAllProductsWithCategory(@Param("keyword") String search_keyword,
                                              @Param("category") String category);
}
