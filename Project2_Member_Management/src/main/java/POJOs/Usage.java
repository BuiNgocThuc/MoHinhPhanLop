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
@Table(name = "thongtinsd")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "MaTV")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "MaTB")
    private Device device;

    @Column(name = "TGVao")
    private Timestamp enteredTime;

    @Column(name = "TGMuon")
    private Timestamp borrowedTime;

    @Column(name = "TGTra")
    private Timestamp paidTime;
    
    @Column(name = "TGDatCho")
    private Timestamp reserveTime;

    public Usage() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Timestamp getEnteredTime() {
        return enteredTime;
    }

    public void setEnteredTime(Timestamp enteredTime) {
        this.enteredTime = enteredTime;
    }

    public Timestamp getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(Timestamp borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public Timestamp getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Timestamp paidTime) {
        this.paidTime = paidTime;
    }

    public Timestamp getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Timestamp reserveTime) {
        this.reserveTime = reserveTime;
    }
    
    

    @Override
    public String toString() {
        if (enteredTime == null) { //
            return "Usage_borrowed{" +
                    "id=" + id +
                    ", member=" + member.toString() +
                    ", device=" + device.toString() +
                    ", borrowedTime=" + borrowedTime +
                    ", paidTime=" + paidTime +
                    '}';
        }
        return "Usage_entered{" +
                "id=" + id +
                ", member=" + member.toString() +
                ", enteredTime=" + enteredTime +
                '}';
    }
}
