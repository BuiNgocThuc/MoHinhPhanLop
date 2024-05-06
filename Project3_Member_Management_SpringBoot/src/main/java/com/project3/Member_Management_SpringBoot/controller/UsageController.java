package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.DeviceService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import com.project3.Member_Management_SpringBoot.service.UsageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UsageController {
    private final UsageService usageService;
    
    @GetMapping("/showListBorrowedDevices")
    public String showListBorrowedDevices(Model theModel) {
        List<Usage> borrowedDevices = usageService.getBorrowedDevices();
        theModel.addAttribute("borrowedDevices", borrowedDevices);
        return "members/borrowedDevice-table";
    }

    @GetMapping("/showFormRegisterBorrowDevice")
    public String showFormRegisterBorrowDevice(Model theModel) {
        List<Device> availableDevices = usageService.getAvailableDevices();
        theModel.addAttribute("availableDevices", availableDevices);
        Usage usage = new Usage();
        theModel.addAttribute("usage", usage);
        return "members/borrowedDevice-form";
    }

    @GetMapping("/returnDevice")
    public String returnDevice(@RequestParam("usageId") Integer ID, Model theModel) {
        Usage usage = usageService.findById(ID);
        usageService.returnDevice(usage);
        return "redirect:/admin/usages/showListBorrowedDevices";
    }

    @PostMapping("/borrowDevice")
    public String borrowDevice(@ModelAttribute("usage") Usage usage) {
        usageService.borrowDevice(usage);
        return "redirect:/admin/usages/showFormRegisterBorrowDevice";
    }
}
