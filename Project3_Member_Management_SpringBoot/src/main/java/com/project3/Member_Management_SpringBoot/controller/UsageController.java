package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.UsageService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsageController {

    @Autowired
    private UsageService usageService;

    @GetMapping("/reservation-device")
    public String getReservationDevice(Model theModel, HttpSession session, HttpServletResponse response)
            throws IOException {
        Member member = (Member) session.getAttribute("user");

        if (member == null) {
            response.sendRedirect("/loginPage");
            return null;
        }

        theModel.addAttribute("member", member);

        List<Usage> usages = usageService.findByMemberIdAndReserveTimeNotNull(member.getId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Usage usage : usages) {
            if (usage.getBorrowedTime() != null) {
                LocalDateTime borrowedTime = usage.getBorrowedTime().toLocalDateTime();
                usage.setBorrowedTimeString(borrowedTime.format(formatter));
            }
            if (usage.getReserveTime() != null) {
                LocalDateTime reserveTime = usage.getReserveTime().toLocalDateTime();
                usage.setReserveTimeString(reserveTime.format(formatter));
            }
        }

        
        for (Usage usage : usages) {
          System.out.println(usage.getReserveTimeString());
        }

        theModel.addAttribute("usages", usages);

        return "reservation-device";
    }
}
