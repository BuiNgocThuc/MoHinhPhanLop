/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import java.util.List;

import com.project3.Member_Management_SpringBoot.model.Device;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.Member_Management_SpringBoot.model.Device;

/**
 *
 * @author buing
 */
@Service
public interface DeviceService {
    @Autowired
    List<Device> getAvailableDevices();
    List<Device> searchDeviceByName(String name);
    Device findById(Integer ID);
}
