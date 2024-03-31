/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.project2_member_management.Main;

import BLL.MemberBLL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buing
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        MemberBLL memberBLL = new MemberBLL();
        System.out.println("Oke");
    }
}
