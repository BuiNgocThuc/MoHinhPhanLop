/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project3.Member_Management_SpringBoot.model.Usage;

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
}