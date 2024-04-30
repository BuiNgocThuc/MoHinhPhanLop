
package com.project3.Member_Management_SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project3.Member_Management_SpringBoot.annotation.RestrictTo;

@Controller()
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping("/")
    @RestrictTo({ "user" })
    public String user() {
        return "users/profile";
    }
}
