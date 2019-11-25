package team_random.DBProject.service;

import team_random.DBProject.model.Product;

public interface ProductService {
    void save(Product product);
    Product findByName(String name);
    Product findById(int id);
}
