package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team_random.DBProject.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    Transaction findById(int id);
    default List<Transaction> findByStoreId(int storeId){
        //mySQL to find
        List<Transaction> res = new ArrayList<>();
        return res;
    }
    default  List<Transaction> findByRegionId(int regionId){
        //mySQL to find transactions for a region id and rank them;
        List<Transaction> res = new ArrayList<>();
        return res;
    }
}
