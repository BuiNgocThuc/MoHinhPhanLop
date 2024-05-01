/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project3.Member_Management_SpringBoot.model.Device;

/**
 *
 * @author buing
 */
@Service
public interface DeviceService {
    void addDevice(Device device);

    Device findDeviceById(Integer id);

    void updateDevice(Device device);

    void deleteDevice(Integer id);

    List<Device> findAllDevices();
}
