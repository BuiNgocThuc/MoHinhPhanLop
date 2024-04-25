/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringWeb.model;

import com.google.protobuf.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "xuly")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaXL")
    private Integer id;

    @Column(name = "HinhthucXL")
    private String description;

    @Column(name = "Sotien")
    private Integer fine;

    @Column(name = "NgayXL")
    private Timestamp date;

    @Column(name = "TrangthaiXL")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "MaTV")
    private Member member;
}