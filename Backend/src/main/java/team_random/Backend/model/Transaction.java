package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Transact")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    private int customer_id;
    private int product_id;
    private int num; //inventory
    private String date;
}
