package team_random.DBProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private int pid; //product id
    private int cid; //customer id
    private int num; //counts
    private Date date;

    public int getId(){return this.id;}

    public void setProductId(int pid){
        this.pid = pid;
    }

    public int getProductId(){
        return pid;
    }

    public void setCustomerId(int cid){
        this.cid = cid;
    }

    public int getCustomerId(){
        return cid;
    }

    public void setNum(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }
}
