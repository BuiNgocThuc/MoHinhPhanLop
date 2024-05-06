package com.project3.Member_Management_SpringBoot.controller.user;

import com.project3.Member_Management_SpringBoot.annotation.AuthRequire;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import com.project3.Member_Management_SpringBoot.service.EmailService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import com.project3.Member_Management_SpringBoot.service.UsageService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private UsageService usageService;

    @GetMapping("/changePassword")
    public String changePassword() {
        return "users/changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(HttpSession session,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        Member member = (Member) session.getAttribute("user");
        if (!memberService.checkPasswordUser(member, oldPassword)) {
            return "redirect:/?wrongOldPassword";
        }
        member.setPassword(newPassword);
        memberService.saveMember(member);
        return "redirect:/?changePasswordSuccess";
    }

    @PostMapping(value = "/send-email")
    public void sendEmail(@RequestBody Member member) throws Exception {
        try {
            emailService.sendEmail(member);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @GetMapping("/violation_history")
    @AuthRequire
    public String violationHistory(HttpSession session, Model theModel) {
        Member member = (Member) session.getAttribute("user");
        List<Discipline> disciplinesByUser = disciplineService.findByMember(member);
        theModel.addAttribute("data", disciplinesByUser);
        return "users/violationHistory";
    }

    @GetMapping("/borrowedEquipment")
    @AuthRequire
    @Transactional
    public String getBorrowedEquipment(Model model, HttpSession session) throws IOException {
        Member member = (Member) session.getAttribute("user");
        if (member == null) {
            return "error";
        }
        Iterable<Usage> borrowedDevices = member.getUsages();
        model.addAttribute("borrowedDevices", borrowedDevices);
        return "users/detail-borrowed-device";
    }

    @GetMapping("/reservedDevicesList")
    @AuthRequire
    public String getReservationDevice(Model theModel, HttpSession session, HttpServletResponse response)
            throws IOException {
        Member member = (Member) session.getAttribute("user");

        if (member == null) {
            response.sendRedirect("/login");
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

        return "users/reservedDevicesList";
    }
}
