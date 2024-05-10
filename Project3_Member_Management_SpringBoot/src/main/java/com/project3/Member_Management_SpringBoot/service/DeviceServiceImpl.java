/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.repository.DeviceRepository;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> findAllDevices() {
        return (List<Device>) deviceRepository.findAll();
    }
    
    @Override
    public List<Device> getAvailableDevices() {
        return deviceRepository.findAvailableDevices();
    }

    @Override
    public List<Device> searchDeviceByName(String name) {
        return deviceRepository.findByNameLike("%" + name + "%");
    }

    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device findDeviceById(int id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDeviceById(int id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public List<Device> findAllDevicesLikeId(int deviceId) {
        return deviceRepository.findAllDevicesLikeId(deviceId);
    }

    @Override
    public Integer statisticsBorrowedDevice(String name, Date startDate, Date endDate) {
        Timestamp startDateTimestamp = null;
        Timestamp endDateTimestamp = null;
        if (startDate != null)
        {
            startDateTimestamp = new Timestamp(startDate.getTime());
        }
        if (endDate != null)
        {
            endDateTimestamp = new Timestamp(endDate.getTime());
        }
        List<Device> devices = deviceRepository.statisticsBorrowedDevice("%" + name + "%", startDateTimestamp, endDateTimestamp);

        return devices.size();
    }

    @Override
    public Integer statisticsBorrowingDevice(Date startDate, Date endDate) {
        Timestamp startDateTimestamp = null;
        Timestamp endDateTimestamp = null;
        if (startDate != null)
        {
            startDateTimestamp = new Timestamp(startDate.getTime());
        }
        if (endDate != null)
        {
            endDateTimestamp = new Timestamp(endDate.getTime());
        }
        List<Device> devices = deviceRepository.statisticsBorrowingDevice(startDateTimestamp, endDateTimestamp);

        return devices.size();
    }

    @Override
    public Page<Device> findAllByNameOrID(String query, Pageable pageable) {
        return deviceRepository.findAllByNameOrID(query, pageable);
    }
}
