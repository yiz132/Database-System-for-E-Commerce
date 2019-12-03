package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.StoreManager;

import java.util.List;
import java.util.Map;

public interface StoreManagerRepository  extends CrudRepository<StoreManager, Integer> {
    StoreManager findByName(String name);
    StoreManager findById(int id);
    @Query(value = "SELECT p.name,p.price,sum(t.num),sum(t.num*p.price),inventory FROM store_managers sm,stores s,salespersons sp,products p, transactions t " +
            "where sm.id=?1 AND sm.store_name=s.name AND sp.sid=s.id AND p.salesperson_id=sp.id AND t.pid = p.id GROUP BY p.name ",nativeQuery = true)
    List<Map<String,String>> reviewAllByStoreManagerId(int store_mana_id);
}
