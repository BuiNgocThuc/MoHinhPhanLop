/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Device;
import java.util.List;

import com.project3.Member_Management_SpringBoot.model.Usage;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public interface UsageService {
    List<Usage> getAllUsage();

    Usage getUsageById(Integer id);

    Usage saveUsage(Usage usage);

    void deleteUsageById(Integer id);

    List<Usage> findByMemberIdAndReserveTimeNotNull(Integer memberId);
    List<Usage> findByMemberIdAndBorrowedTimeNotNull(Integer memberId);
    @Autowired
    void save(Usage usage);
    void deleteAll(Iterable<Usage> usages);
    Boolean reserveDevice(Usage usage);
    List<Usage> findOverdueReservation(Timestamp deadline);
    List<Usage> getBorrowedDevices();
    List<Device> getAvailableDevices();
    Usage findById(Integer ID);
    void returnDevice(Usage usage);
    void borrowDevice(Usage usage);
}
