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

    public <Integer> Device getDeviceById(int id) {
        return baseDeviceDAL.getById(id);
    }

    public boolean insertDevice(Device device) {
        try {
            Device existingDevice = baseDeviceDAL.getById(device.getId());
            if (existingDevice != null) {
                System.err.println("Thiết bị đã tồn tại trong cơ sở dữ liệu với ID đã cho.");
                return false;
            }
            baseDeviceDAL.save(device);
            System.out.println("Thiết bị đã được lưu thành công vào cơ sở dữ liệu.");
            return true;
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi khi lưu thiết bị vào cơ sở dữ liệu:");
            e.printStackTrace();
            return false;
        }
    }

    public void updateDevice(Device device) {
        baseDeviceDAL.update(device);
    }

    public void deleteDevice(int id) {
        Device device = getDeviceById(id);
        baseDeviceDAL.delete(device);
    }

    public void changeStatus(int id) {
        Device device = getDeviceById(id);
        device.setStatus(0);
        updateDevice(device);
    }

    public List<Device> statisticDeviceBorrowed(String name, String startDate, String endDate) throws ParseException {
        return deviceDAL.statisticDeviceBorrowed(name, startDate, endDate);
    }

    public List<Device> statisticDeviceIsBorrowing(String name, String startDate, String endDate)
            throws ParseException {
        return deviceDAL.statisticDeviceIsBorrowing(name, startDate, endDate);
    }
}
