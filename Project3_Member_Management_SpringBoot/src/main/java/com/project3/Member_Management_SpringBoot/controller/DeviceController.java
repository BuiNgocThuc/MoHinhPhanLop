package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

}
