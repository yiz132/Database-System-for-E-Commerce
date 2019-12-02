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
    Map<String, List<Product>> groupByCategory();
    Map<String,Integer> groupByName();
    List<Product> showAllProducts();
    List<Product> roughSearch(String input);
}
