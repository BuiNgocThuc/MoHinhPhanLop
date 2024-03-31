/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author buing
 */
@Entity
@Table(name = "thanhvien")
public class Member {

    @Id
    @Column(name = "MaTV")
    private int id;

    @Column(name = "HoTen")
    private String name;

    @Column(name = "Khoa")
    private String department;

    @Column(name = "Nganh")
    private String major;

    @ManyToMany
    @JoinTable(name = "thongtinsd", 
            joinColumns = @JoinColumn(name = "MaTV"), 
            inverseJoinColumns = @JoinColumn(name = "MaTB")) 
    private Set<Device> devices = new HashSet<>();

    public Member() {

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Member{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", department='" + department + '\''
                + ", major='" + major + '\''
                + '}';
    }
}
