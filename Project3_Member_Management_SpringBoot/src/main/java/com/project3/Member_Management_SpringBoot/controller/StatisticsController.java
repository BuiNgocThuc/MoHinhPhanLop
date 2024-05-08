/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.service.DeviceService;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author buing
 */
@Controller
@RequiredArgsConstructor
public class StatisticsController {

    private final MemberService memberService;
    private final DeviceService deviceService;
    private final DisciplineService disciplineService;

    // @GetMapping("/admin/dashboard")
    // public String dashboard(Model theModel) {
    // Integer memberCount = memberService.statisticsMember("CNTT", "Hệ thống thông
    // tin", null, null);
    // theModel.addAttribute("memberData", memberCount);
    // Integer borrowedDeviceData = deviceService.statisticsBorrowedDevice("Micro",
    // null, null);
    // theModel.addAttribute("borrowedDeviceData", borrowedDeviceData);
    // Integer borrowingDeviceData = deviceService.statisticsBorrowingDevice(null,
    // null);
    // theModel.addAttribute("borrowingDeviceData", borrowingDeviceData);
    // Integer resolvedDisciplineData = disciplineService.findByStatus(0);
    // theModel.addAttribute("resolvedDisciplineData", resolvedDisciplineData);
    // Integer totalFineData = disciplineService.findSumFine();
    // theModel.addAttribute("totalFineData", totalFineData);
    // Integer unresolvedDisciplineData = disciplineService.findByStatus(1);
    // theModel.addAttribute("unresolvedDisciplineData", unresolvedDisciplineData);
    //
    // return "admin/dashboard";
    // }
    @GetMapping("/admin/device/statictis")
    public String getDeviceStatistics(
            @RequestParam("search") String searchDeviceVal,
            @RequestParam("select") String selectDeviceVal,
            @RequestParam("startDate") String startDateDevice,
            @RequestParam("endDate") String endDateDevice) {
        // Here, you can process the received data, perform database queries,
        // or any other logic you need for generating statistics
        System.out.println(searchDeviceVal);
        System.out.println(selectDeviceVal);
        System.out.println(startDateDevice);
        System.out.println(endDateDevice);

//        // For example, you can create a JSON string manually
//        String jsonResponse = "{\"search\": \"" + searchDeviceVal + "\", \"select\": \"" + selectDeviceVal + "\", \"startDate\": \"" + startDateDevice + "\", \"endDate\": \"" + endDateDevice + "\"}";

        return "";
    }
}
