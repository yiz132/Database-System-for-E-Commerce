package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    Transaction findById(int id);
}
