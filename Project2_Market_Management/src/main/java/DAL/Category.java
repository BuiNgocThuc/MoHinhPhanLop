
package DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    
    @OneToMany(mappedBy = "category")
    private List<Vegetable> listVegetable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }  

    public List<Vegetable> getListVegetable() {
        return listVegetable;
    }

    public void setListVegetable(List<Vegetable> listVegetable) {
        this.listVegetable = listVegetable;
    }

    void setDescripton(String description) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
