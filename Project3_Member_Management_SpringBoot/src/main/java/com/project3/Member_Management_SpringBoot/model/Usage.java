package com.project3.Member_Management_SpringBoot.model;

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

    @Column(name = "tgvao", nullable = true)
    private Timestamp enteredTime;

    @Column(name = "tgmuon", nullable = true)
    private Timestamp borrowedTime;

    @Column(name = "tgtra", nullable = true)
    private Timestamp paidTime;

    @Column(name = "tgdatcho", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp reserveTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTV")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTB", nullable = true)
    private Device device;

    private String borrowedTimeString;
    private String reserveTimeString;

    public String getBorrowedTimeString() {
        return borrowedTimeString;
    }

    public void setBorrowedTimeString(String borrowedTimeString) {
        this.borrowedTimeString = borrowedTimeString;
    }

    public String getReserveTimeString() {
        return reserveTimeString;
    }

    public void setReserveTimeString(String reserveTimeString) {
        this.reserveTimeString = reserveTimeString;
    }
}
