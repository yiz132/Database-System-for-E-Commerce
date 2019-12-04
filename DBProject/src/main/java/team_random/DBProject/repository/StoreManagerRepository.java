package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import team_random.DBProject.model.StoreManager;

import java.util.List;
import java.util.Map;

public interface StoreManagerRepository  extends CrudRepository<StoreManager, Integer> {
    StoreManager findByName(String name);
    StoreManager findById(int id);

    /**
     *
     * @param store_mana_id
     * @return product name, sum of sales of each product, sum of profits of each product
     */
    @Query(value = "SELECT p.name,sum(t.num) AS total_sales, sum(t.num*p.price) AS total_profits FROM store_managers sm,stores s,salespersons sp,products p, transactions t where sm.id = ?1 AND sm.store_name=s.name AND sp.sid=s.id AND p.salesperson_id=sp.id AND t.pid = p.id GROUP BY p.name ",nativeQuery = true)
    List<Map<String,String>> reviewAllByStoreManagerId(int store_mana_id);
    @Query(value = "SELECT p.name,sum(t.num) AS total_sales, sum(t.num*p.price) AS total_profits FROM store_managers sm,stores s,salespersons sp,products p, transactions t where sm.id = :id AND sm.store_name=s.name AND sp.sid=s.id AND p.salesperson_id=sp.id AND t.pid = p.id AND p.name LIKE %:keyword% GROUP BY p.name ",nativeQuery = true)
    List<Map<String, String>> searchProductsByKeywords(@Param("id")int id,
                                                       @Param("keyword") String search_keyword);
}
