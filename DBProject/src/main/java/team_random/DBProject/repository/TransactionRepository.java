package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team_random.DBProject.model.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findById(int id);
    List<Transaction> findByPid(int pid);
    @Query(value = "SELECT DISTINCT t.id,t.cid,t.date,t.num,t.pid FROM transactions t, products p, salespersons sp WHERE sp.sid = ?1 AND sp.pid = t.pid ",nativeQuery = true)
    List<Transaction> findByStoreId(int storeId);
    @Query(value = "SELECT DISTINCT t.id,t.cid,t.date,t.num,t.pid FROM transactions t, products p, salespersons sp, regions r WHERE sp.id = r.manager_id AND sp.pid = t.pid AND r.id = ?1 ",nativeQuery = true)
    List<Transaction> findByRegionId(int regionId);
}