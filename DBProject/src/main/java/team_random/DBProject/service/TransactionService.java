package team_random.DBProject.service;

import team_random.DBProject.model.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionService {
    void save(Transaction transaction);
    Transaction findById(int id);
    Map<String,Integer> sortBySalesAll();
    Map<String,Integer> sortByProfitsAll();
    //return map of product name to its total sales group by product names sorted by sales volume(in a given region)
    Map<String,Integer> sortBySalesInRegion(int region_id);
    Map<String,Integer> sortByProfitsInRegion(int region_id);
    //return
    Map<String,Integer> sortBySalesInStore(int store_id);
    Map<String,Integer> sortByProfitsInStore(int store_id);
    List<Transaction> findAllByCid(int cid);
}
