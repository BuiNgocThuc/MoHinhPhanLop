/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.repository.UsageRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public class UsageServiceImpl implements UsageService{
    @Autowired
    private UsageRepository usageRepository;

    @Override
    public void save(Usage usage) {
        usageRepository.save(usage);
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

    
}
