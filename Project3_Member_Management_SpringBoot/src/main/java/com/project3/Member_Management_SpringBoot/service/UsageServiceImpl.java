/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.repository.UsageRepository;

import java.util.List;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.repository.UsageRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
@RequiredArgsConstructor
public class UsageServiceImpl implements UsageService {

    private final UsageRepository usageRepository;

    private final DeviceService deviceService;

    private final MemberService memberService;

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
        if (existedUsage.isEmpty()) {
            save(usage);
            return true;
        }
        return false;
    }

    @Override
    public List<Usage> findOverdueReservation(Timestamp deadline) {
        return usageRepository.findOverdueReservation(deadline);
    }

    @Override
    public List<Usage> getBorrowedDevices() {
        return usageRepository.findByBorrowedTimeNotNullAndPaidTimeIsNull();
    }

    @Override
    public List<Device> getAvailableDevices() {
        return usageRepository.findAvailableDevices();
    }

    @Override
    public Usage findById(Integer ID) {
        return usageRepository.findById(ID).get();
    }

    @Override
    public void returnDevice(Usage usage) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        usage.setPaidTime(currentTimestamp);
        saveUsage(usage);
    }

    @Override
    public void borrowDevice(Usage usage) {
        int memberID = usage.getMember().getId();
        int deviceID = usage.getDevice().getId();
        Member member = memberService.findById(memberID);
        Device device = deviceService.findDeviceById(deviceID);
        usage.setMember(member);
        usage.setDevice(device);
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        usage.setBorrowedTime(currentTimestamp);
        saveUsage(usage);
    }

    @Override
    public List<Usage> findByMemberIdAndBorrowedTimeNotNull(Integer memberId) {
        return usageRepository.findByMemberIdAndBorrowedTimeNotNull(memberId);
    }
    @Override
    public List<Usage> findUsageListYetPaid(Integer deviceId) {
        return usageRepository.findUsageListYetPaid(deviceId);
    }

    @Override
    public List<Usage> findUsageListYetPaidLikeId(Integer deviceIdPattern) {
        return usageRepository.findUsageListYetPaidLikeId(deviceIdPattern);
    }
}
