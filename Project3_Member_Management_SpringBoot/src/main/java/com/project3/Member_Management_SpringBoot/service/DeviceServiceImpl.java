/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.repository.DeviceRepository;

import java.util.List;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceRepository deviceRepository;
    
    @Override
    public List<Device> getAvailableDevices() {
        return deviceRepository.findAvailableDevices();
    }

    @Override
    public List<Device> searchDeviceByName(String name) {
        return deviceRepository.findByNameLike("%" + name + "%");
    }

    @Override
    public Device findById(Integer ID) {
        return deviceRepository.findById(ID).get();
    }
}
