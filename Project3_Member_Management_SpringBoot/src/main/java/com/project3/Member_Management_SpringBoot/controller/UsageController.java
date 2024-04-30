package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.annotation.RestrictTo;
import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.DeviceService;
import com.project3.Member_Management_SpringBoot.service.UsageService;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsageController {

    @Autowired
    private UsageService usageService;

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/reservation")
    public String reserseDevice(@ModelAttribute("usage") Usage usage, HttpSession session) {
        Member member = (Member) session.getAttribute("user");

        usage.setMember(member);
        Boolean reserve = usageService.reserveDevice(usage);
        if (reserve)
        {
            return "redirect:/reservation_test?success";
        }
        return "redirect:/reservation_test?unavailable";
    }

    @GetMapping("/reservation")
    @RestrictTo(
    {
        "user"
    })
    public String reservation(Model theModel) {
        List<Device> availableDevices = deviceService.getAvailableDevices();
        theModel.addAttribute("availableDevices", availableDevices);
        Usage usage = new Usage();
        theModel.addAttribute("usage", usage);
        Device device = new Device();
        theModel.addAttribute("device", device);
        return "users/reservation";
    }

    @GetMapping("/reservation_test")
    @RestrictTo(
    {
        "user"
    })
    public String reservation_test(Model theModel) {
        List<Device> availableDevices = deviceService.getAvailableDevices();
        theModel.addAttribute("availableDevices", availableDevices);
        Usage usage = new Usage();
        theModel.addAttribute("usage", usage);
        Device device = new Device();
        theModel.addAttribute("device", device);
        return "users/reservation_test";
    }
    
    @PostMapping("/searchDevice")
    public String searchDeviceByName(@ModelAttribute("device") Device device, Model theModel) {
        String name = device.getName();
        if(name.isEmpty()) {
            return reservation_test(theModel);
        }
        List<Device> results = deviceService.searchDeviceByName(name);
         theModel.addAttribute("availableDevices", results);
        Usage usage = new Usage();
        theModel.addAttribute("usage", usage);
        theModel.addAttribute("device", device);
        return "users/reservation_test";
    }
    

}
