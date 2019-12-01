package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team_random.DBProject.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findById(int id);
    List<Transaction> findByPid(int pid);
    @Query(value = "SELECT DISTINCT t.id,t.cid,t.date,t.num,t.pid FROM transactions t, products p, salespersons sp WHERE sp.sid = ?1 AND sp.pid = t.pid ",nativeQuery = true)
    List<Transaction> findByStoreId(int storeId);
}