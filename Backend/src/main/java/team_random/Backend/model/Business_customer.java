package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Business_Customers")
public class Business_customer extends Customer {
    @Id
    @GeneratedValue
    private int annual_gross;
    private String business_category;

    public void setAnnual_gross(int gross){
        this.annual_gross = gross;
    }

    public void setBusiness_category(String category){
        this.business_category = category;
    }
}
