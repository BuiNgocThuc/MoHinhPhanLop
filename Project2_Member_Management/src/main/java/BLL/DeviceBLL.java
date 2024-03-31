package BLL;

import DAL.DeviceDAL;
import DAL.baseDAL;
import POJOs.Device;
import java.text.ParseException;

import java.util.List;

public class DeviceBLL {

    private baseDAL<Device> baseDeviceDAL;
    private DeviceDAL deviceDAL;

    public DeviceBLL() {
        this.deviceDAL = new DeviceDAL();
        this.baseDeviceDAL = new baseDAL<>(Device.class);
    }

    public List<Device> selectAll() {
        return baseDeviceDAL.selectAll();
    }

    public Device getDeviceById(int id) {
        return baseDeviceDAL.getById(id);
    }

    public void insertDevice(Device device) {
        baseDeviceDAL.save(device);
    }

    public void updateDevice(Device device) {
        baseDeviceDAL.update(device);
    }

    public void deleteDevice(int id) {
        baseDeviceDAL.delete(id);
    }
    
    public List<Device> statisticByName(String name) {
        return deviceDAL.statisticByName(name);
    }
    
     public List<Device> timeBasedStatistics(String startDate, String endDate) throws ParseException {
        return deviceDAL.timeBasedStatistics(startDate, endDate);
    }
     
    public List<Device> statisticIsBorrowing() {
        return deviceDAL.statisticIsBorrowing();
    }
     public List<Device> timeStatisticIsBorrowing(String startDate, String endDate) throws ParseException {
        return deviceDAL.timeStatisticIsBorrowing(startDate, endDate);
    }
}