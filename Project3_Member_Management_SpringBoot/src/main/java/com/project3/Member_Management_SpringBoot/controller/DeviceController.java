package com.project3.Member_Management_SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.DeviceService;
import com.project3.Member_Management_SpringBoot.service.UsageService;

import java.util.List;

@Controller
public class DeviceController {

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UsageService usageService;

    @GetMapping("/admin/device-management")
    public String deviceManagement(Model model) {
        List<Device> devices = deviceService.findAllDevices();
        model.addAttribute("devices", devices);
        return "admin/device_management/deviceList";
    }

    @GetMapping("/admin/device-management/add")
    public String addDeviceForm(Model model) {
        model.addAttribute("device", new Device());
        return "admin/device_management/addDeviceForm";
    }

    @PostMapping("/add-device")
    public String addDeviceSubmit(@ModelAttribute Device device) {
        deviceService.saveDevice(device);
        return "redirect:/admin/device-management/add";
    }

    @GetMapping("/admin/device-management/{id}")
    public String editDeviceForm(@PathVariable int id, Model model) {
        Device device = deviceService.findDeviceById(id);
        model.addAttribute("device", device);
        return "admin/device_management/editDeviceForm";
    }

    @PostMapping("/edit-device/{id}")
    public String editDeviceSubmit(@PathVariable int id, @ModelAttribute Device updatedDevice) {
        Device existingDevice = deviceService.findDeviceById(id);
        if (existingDevice != null) {
            existingDevice.setName(updatedDevice.getName());
            existingDevice.setDescription(updatedDevice.getDescription());
            deviceService.saveDevice(existingDevice);
        }
        return "redirect:/admin/device-management/" + id;
    }

    @PostMapping("/delete-device/{id}")
    public String deleteDevice(@PathVariable int id) {
        List<Usage> usageList = usageService.findUsageListYetPaid(id);
        System.out.println(usageList.size());
        if (!usageList.isEmpty()) {
            String err = "The device is on loan or scheduled so cannot be deleted!";
            return "redirect:/admin/device-management?err=" + err;
        }

        deviceService.deleteDeviceById(id);
        String success = "Delete device successfully";
        return "redirect:/admin/device-management?success=" + success;
    }

    @PostMapping("/batch-delete")
    public String batchDeleteDevice(@RequestParam("deviceSelect") int deviceId, @RequestParam("yearInput") int year) {
        String idString = String.valueOf(deviceId) + String.valueOf(year);
        List<Usage> usageList = usageService.findUsageListYetPaidLikeId(Integer.parseInt(idString));
        System.out.println(usageList.size());
        if (!usageList.isEmpty()) {
            String err = "The device is on loan or scheduled so cannot be deleted!";
            return "redirect:/admin/device-management?err=" + err;
        }
        List<Device> devices = deviceService.findAllDevicesLikeId(Integer.parseInt(idString));

        for (Device device : devices) {
            deviceService.deleteDeviceById(device.getId());

        }
        String success = "Batch delete devices successfully";
        return "redirect:/admin/device-management?success=" + success;

    }

}
