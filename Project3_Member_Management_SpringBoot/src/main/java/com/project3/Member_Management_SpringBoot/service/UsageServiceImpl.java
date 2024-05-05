/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.repository.UsageRepository;

import java.util.List;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.repository.UsageRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public class UsageServiceImpl implements UsageService {

    @Autowired
    private UsageRepository usageRepository;

    @Override
    public List<Usage> getAllUsage() {
        return (List<Usage>) usageRepository.findAll();
    }

    @Override
    public Usage getUsageById(Integer id) {
        return usageRepository.findById(id).orElse(null);
    }

    @Override
    public Usage saveUsage(Usage usage) {
        return usageRepository.save(usage);
    }

    @Override
    public void deleteUsageById(Integer id) {
        usageRepository.deleteById(id);
    }

    @Override
    public List<Usage> findByMemberIdAndReserveTimeNotNull(Integer memberId) {
        return usageRepository.findByMemberIdAndReserveTimeNotNull(memberId);
    }

    public void save(Usage usage) {
        usageRepository.save(usage);
    }
    
     @Override
    public void deleteAll(Iterable<Usage> usages) {
        usageRepository.deleteAll(usages);
    }
    
    @Override
    public Boolean reserveDevice(Usage usage) {
        Device selectedDevice = usage.getDevice();
        Date reserveDate = new Date(usage.getReserveTime().getTime());
        List<Usage> existedUsage = usageRepository.checkValidateDevice(selectedDevice, reserveDate);
        if (existedUsage.isEmpty())
        {
            save(usage);
            return true;
        }
         return false;
    }

    @Override
    public List<Usage> findOverdueReservation(Timestamp deadline) {
        return usageRepository.findOverdueReservation(deadline);
    }
}
