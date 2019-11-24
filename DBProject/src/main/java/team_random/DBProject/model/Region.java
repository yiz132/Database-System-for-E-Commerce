package team_random.DBProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Regions")
public class Region {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int manager_id;

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setManager_id(int mid){
        this.manager_id = mid;
    }

    public int getManager_id(){
        return manager_id;
    }
}
