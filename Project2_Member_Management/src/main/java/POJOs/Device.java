/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author buing
 */
@Entity
@Table(name = "thietbi")
public class Device {

    @Id
    @Column(name = "MaTB")
    private int id;

    @Column(name = "TenTB")
    private String name;

    @Column(name = "MoTaTB")
    private String description;
    
    @OneToMany(mappedBy = "device", cascade = CascadeType.REMOVE)
    private List<Usage> listUsage;

    @ManyToMany(mappedBy = "devices")
    private Set<Member> members = new HashSet<>();

    public Device() {

    }

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

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public List<Usage> getListUsage() {
        return listUsage;
    }

    public void setListUsage(List<Usage> listUsage) {
        this.listUsage = listUsage;
    }
    

    @Override
    public String toString() {
        return "Device{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + '}';
    }
}
