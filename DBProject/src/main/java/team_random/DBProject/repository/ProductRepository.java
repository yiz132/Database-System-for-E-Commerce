package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
    Product findById(int id);
    List<Product> findByCategory(String category);
}
