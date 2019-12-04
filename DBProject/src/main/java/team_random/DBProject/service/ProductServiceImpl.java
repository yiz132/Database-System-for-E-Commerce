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
    public List<Product> groupByCategory(String category) {
        return productRepository.findALLByCategory(category);
    }

    @Override
    public List<Product> showAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public List<Product> roughSearch(String input) {
        return productRepository.findProductByNameContains(input);
    }

    @Override
    public List<Product> findBySalespersonId(int spId) {
        return productRepository.findAllBySalesperson_id(spId);
    }

    @Override
    public List<Product> roughSearchForSalesperson(int id, String keyword) {
        return productRepository.roughSearchForSalesperson(id,keyword);
    }

    @Override
    public List<Product> sortAllProductsWithCategory(String search_keyword, String category) {
        return productRepository.sortAllProductsWithCategory(search_keyword,category);
    }

}
