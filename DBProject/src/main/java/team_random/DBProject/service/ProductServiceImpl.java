package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.Product;
import team_random.DBProject.repository.ProductRepository;
import team_random.DBProject.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteByName(String name) {
        productRepository.deleteByName(name);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Map<String, List<Product>> groupByCategory() {
        List<String> categories = productRepository.findAllCategories();
        Map<String,List<Product>> map = new HashMap<>();
        for (String category : categories){
            List<Product> products = productRepository.findByCategory(category);
            map.put(category,products);
        }
        return map;
    }

    @Override
    public List<Product> showAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public List<Product> roughSearch(String input) {
        return productRepository.findProductByNameContains(input);
    }

    public static void main(String[] args){
        ProductServiceImpl productService = new ProductServiceImpl();
        Map<String,List<Product>> map = productService.groupByCategory();
    }
}
