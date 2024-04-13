/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import jakarta.persistence.*;
import java.io.Serializable;

import java.sql.Timestamp;
/**
 *
 * @author buing
 */
@Entity
@Table(name = "xuly")
public class Discipline implements Serializable{
    @Id
    @Column(name = "MaXL")
    private int id;

    @Column(name = "HinhThucXL")
    private String description;

    @Column(name = "SoTien")
    private Integer fine;

    @Column(name = "NgayXL")
    private Timestamp date;

    @Column(name = "TrangThaiXL")
    private int status;

    @ManyToOne
    @JoinColumn(name = "MaTV")
    private Member memberID;

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

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Discipline{" + "id=" + id + ", description=" + description + ", fine=" + fine + ", date=" + date + ", status=" + status + ", memberID=" + memberID + '}';
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

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }
}