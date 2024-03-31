
package com.project2_member_management.Main;

import BLL.DeviceBLL;
import POJOs.Device;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Hello World!");
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        DeviceBLL dvBLL = new DeviceBLL();
        List<Device> devices = dvBLL.timeStatisticIsBorrowing("2024-02-10", "2024-02-15");
        
        for(Device d : devices) {
            System.out.println("id: " + d.getId());
            System.out.println("name: " + d.getName());
            System.out.println("mota: " + d.getDescription());
        }
    }
}
