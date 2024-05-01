/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.repository.UsageRepository;

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
}
