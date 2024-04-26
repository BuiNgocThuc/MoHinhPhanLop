/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.model;

/**
 *
 * @author buing
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thongtinsd")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTT")
    private Integer id;

    @Column(name = "TGVao")
    private Timestamp enteredTime;

    @Column(name = "TGMuon")
    private Timestamp borrowedTime;

    @Column(name = "TGTra")
    private Timestamp paidTime;

    @Column(name = "TGDatcho")
    private Timestamp reserveTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTV")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTB")
    private Device device;
}
