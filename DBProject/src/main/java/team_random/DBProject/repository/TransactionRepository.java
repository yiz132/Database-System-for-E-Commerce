package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team_random.DBProject.model.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findById(int id);
    List<Transaction> findByPid(int pid);
    @Query(value = "SELECT DISTINCT t.id,t.cid,t.date,t.num,t.pid FROM transactions t, products p, salespersons sp WHERE sp.sid = ?1 AND sp.pid = t.pid ",nativeQuery = true)
    List<Transaction> findByStoreId(int storeId);
    @Query(value = "SELECT DISTINCT t.id,t.cid,t.date,t.num,t.pid FROM transactions t, products p, salespersons sp, regions r WHERE sp.id = r.manager_id AND sp.pid = t.pid AND r.id = ?1 ",nativeQuery = true)
    List<Transaction> findByRegionId(int regionId);

    @Query(value = "SELECT * FROM transactions t WHERE t.cid = ?1 ",nativeQuery = true)
    List<Transaction> findAllByCid(int cid);
    //select P.name,sum(num)
    //from  `transactions`T, `products`P
    //where T.pid=P.id
    //GROUP BY P.name
    @Query(value = "SELECT DISTINCT p.name, sum(t.num) FROM transactions t, products p WHERE t.pid = p.id group by p.name ORDER BY sum(t.num)",nativeQuery = true)
    Map<String,Integer> groupTransByName();

    @Query(value = "SELECT DISTINCT p.name,sum(t.num*p.price) FROM transactions t, products p " +
            "WHERE t.pid = p.id group by p.name ORDER BY sum(t.num*p.price)",nativeQuery = true)
    Map<String,Integer> sortTransByProfits();

    @Query(value = "SELECT p.name,sum(t.num) FROM transactions t, products p, salespersons sp, stores s " +
            "WHERE t.pid = p.id AND p.salesperson_id = sp.id AND sp.sid = s.id AND s.rid = ?1 GROUP BY p.name ORDER BY sum(t.num)",nativeQuery = true)
    Map<String,Integer> groupTransByNameInRegion(int region_id);

    @Query(value = "SELECT p.name,sum(t.num*p.price) FROM transactions t, products p, salespersons sp, stores s " +
            "WHERE t.pid = p.id AND p.salesperson_id = sp.id AND sp.sid = s.id AND s.rid = ?1 GROUP BY p.name ORDER BY sum(t.num*p.price)",nativeQuery = true)
    Map<String,Integer> sortTransByProfitsInRegion(int region_id);

    @Query(value = "SELECT p.name,sum(t.num) FROM transactions t, products p, salespersons sp " +
            "WHERE t.pid = p.id AND p.salesperson_id = sp.id AND sp.sid = s.id GROUP BY p.name ORDER BY sum(t.num)", nativeQuery = true)
    Map<String,Integer> groupTransByNameInStore(int store_id);

    @Query(value = "SELECT p.name,sum(t.num*p.price) FROM transactions t, products p, salespersons sp " +
            "WHERE t.pid = p.id AND p.salesperson_id = sp.id AND sp.sid = s.id GROUP BY p.name ORDER BY sum(t.num*p.price)", nativeQuery = true)
    Map<String,Integer> sortTransByProfitsInStore(int store_id);
}