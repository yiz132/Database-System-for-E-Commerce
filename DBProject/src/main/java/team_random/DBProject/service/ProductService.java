package team_random.DBProject.service;

import team_random.DBProject.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void save(Product product);
    Product findByName(String name);
    Product findById(int id);
    void deleteByName(String name);
    void deleteById(int id);
    List<Product> groupByCategory(String category);
    List<Product> showAllProducts();
    List<Product> roughSearch(String input);
    List<Product> findBySalespersonId(int spId);
}
