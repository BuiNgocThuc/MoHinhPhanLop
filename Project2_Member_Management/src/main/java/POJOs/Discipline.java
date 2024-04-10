/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import jakarta.persistence.*;

import java.sql.Timestamp;
/**
 *
 * @author buing
 */
@Entity
@Table(name = "xuly")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaXL")
    private int id;

    @Column(name = "HinhThucXL")
    private String description;

    @Column(name = "SoTien")
    private int fine;

    @Column(name = "NgayXuLy")
    private Timestamp date;

    @Column(name = "TrangThaiXL")
    private int status;

    @ManyToOne
    @JoinColumn(name = "MaTV")
    private Member member;

    public Discipline() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
