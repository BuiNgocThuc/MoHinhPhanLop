/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface DeviceService {
    @Autowired
    List<Device> findAllDevices();

    List<Device> findAllDevicesLikeId(int deviceId);

    List<Device> getAvailableDevices();

    List<Device> searchDeviceByName(String name);

    Device saveDevice(Device device);

    Device findDeviceById(int id);

    void deleteDeviceById(int id);
}
