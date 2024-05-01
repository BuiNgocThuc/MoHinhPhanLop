/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.repository;

import com.project3.Member_Management_SpringBoot.model.Device;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author buing
 */
@Repository
public interface DeviceRepository extends CrudRepository<Device, Integer>{
    @Query("SELECT d FROM Device d LEFT JOIN Usage u ON d.id = u.device.id AND u.paidTime IS NULL AND u.borrowedTime IS NOT NULL WHERE u.device IS NULL")
    List<Device> findAvailableDevices();
 
    @Query("SELECT d FROM Device d LEFT JOIN Usage u ON d.id = u.device.id AND u.paidTime IS NULL AND u.borrowedTime IS NOT NULL WHERE u.device IS NULL AND d.name LIKE ?1")
    List<Device> findByNameLike(String name);
}
