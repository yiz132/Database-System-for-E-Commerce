package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Product")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    private int num; //inventory
    private String category;
    private String description;

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setNum(int num){
        this.num = num;
    }

    public void addNum(int num){
        this.num += num;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
