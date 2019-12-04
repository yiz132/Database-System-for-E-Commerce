package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import team_random.DBProject.model.RegionManager;

import java.util.List;
import java.util.Map;

public interface RegionManagerRepository extends CrudRepository<RegionManager, Integer> {
    RegionManager findByName(String name);
    @Query(value = "SELECT r.name,sum(t.num) AS total_sales, sum(t.num*p.price) AS total_profits " +
            "FROM regions r, stores s, salespersons sp, products p, transactions t WHERE s.rid = r.id AND sp.sid = s.id " +
            "AND p.salesperson_id = sp.id AND t.pid=p.id GROUP BY r.name ", nativeQuery = true)
    List<Map<String, String>> showAllRegionsTrans();

    @Query(value = "SELECT s.name, sum(t.num) AS total_sales, sum(t.num*price) AS total_profits FROM " +
            "stores s, salespersons sp, products p, transactions t,region_managers rm, regions r WHERE " +
            "rm.id = ?1 AND r.name = rm.region_name AND sp.sid = s.id AND p.salesperson_id = sp.id AND t.pid=p.id GROUP BY s.name  ", nativeQuery = true)
    List<Map<String, String>> showTransInRegion(int region_manager_id);

    @Query(value = "SELECT s.name, sum(t.num) AS total_sales, sum(t.num*price) AS total_profits FROM " +
            "stores s, salespersons sp, products p, transactions t,region_managers rm, regions r WHERE " +
            "rm.id = :id AND r.name = rm.region_name AND sp.sid = s.id AND p.salesperson_id = sp.id AND t.pid=p.id AND s.name LIKE %:keyword% GROUP BY s.name  ", nativeQuery = true)
    List<Map<String, String>> reviewAllByStoreManager(@Param("id") int region_manager_id,
                                                      @Param("keyword") String search_keyword);
}
