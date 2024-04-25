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
@Table(name = "thietbi")
public class Device {
    @Id
    @Column(name = "MaTB")
    private Integer id;

    @Column(name = "TenTB")
    private String name;

    @Column(name = "MotaTB")
    private String description;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<Usage> usages = new HashSet<>();
}
