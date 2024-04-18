/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import jakarta.persistence.*;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
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
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "SDT")
    private String phone;
    
    @Column(name = "Email")
    private String email;
    
    @OneToMany(mappedBy = "memberID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Discipline> disciplines;
    

    @ManyToMany
    @JoinTable(name = "thongtinsd", 
            joinColumns = @JoinColumn(name = "MaTV"), 
            inverseJoinColumns = @JoinColumn(name = "MaTB"))
    private List<Device> devices = new ArrayList<>();

    public Member() {
        
    }

    public Member(int id, String name, String department, String major, String phone, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.major = major;
        this.phone = phone;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
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
