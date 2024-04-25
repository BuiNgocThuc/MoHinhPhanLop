/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringWeb.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author buing
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thanhvien")
public class Member {
    @Id
    @Column(name = "MaTV")
    private Integer id;

    @Column(name = "Hoten")
    private String name;

    @Column(name = "Khoa")
    private String department;

    @Column(name = "Nganh")
    private String major;

    @Column(name = "SDT")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Discipline> disciplines;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<Usage> usages = new HashSet<>();
}
