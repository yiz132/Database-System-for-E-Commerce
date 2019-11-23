package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Home_Customers")
public class Home_customer extends Customer{
    @Id
    @GeneratedValue
    private String marriage_status;
    private int age;
    private String gender;
    private int income;
    public Home_customer(){
        super();
    }

    public void setMarriage_status(String status){
        marriage_status = status;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setIncome(int income){
        this.income = income;
    }
}
