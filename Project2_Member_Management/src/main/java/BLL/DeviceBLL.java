package BLL;

import DAL.DeviceDAL;
import DAL.baseDAL;
import POJOs.Device;
import POJOs.Usage;

import java.io.File;
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

    public boolean updateDevice(Device device) {
        try {
            baseDeviceDAL.update(device);
            System.out.println("Thiết bị đã được cập nhật thành công trong cơ sở dữ liệu.");
            return true;
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi khi cập nhật thiết bị trong cơ sở dữ liệu:");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDevice(int id) {
        try {
            Device d = getDeviceById(id);
            baseDeviceDAL.delete(d);
            return true;
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi khi xóa thiết bị trong cơ sở dữ liệu:");
            e.printStackTrace();
            return false;
        }
    }

    public List<Device> selectDeviecByYear(int year) {
        return deviceDAL.selectDeviecByYear(year);
    }
    
    public boolean deleteDeviecByYear (int year) {
        try {
            deviceDAL.deleteDeviceByYear(year);
            return true;
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi khi xóa thiết bị theo năm:");
            e.printStackTrace();
            return false;
        }
    }
 
    public List<Device> searchDevice(String keyword) {
        String validKeyword = keyword.trim().toLowerCase();
        return deviceDAL.searchDevice(validKeyword);
    }

    public List<Device> statisticDeviceBorrowed(String name, String startDate, String endDate) throws ParseException {
        return deviceDAL.statisticDeviceBorrowed(name, startDate, endDate);
    }

    public List<Device> statisticDeviceIsBorrowing(String name, String startDate, String endDate)
            throws ParseException {
        return deviceDAL.statisticDeviceIsBorrowing(name, startDate, endDate);
    }

    public int importExcel(File file) {
        int importedRecords = deviceDAL.importExcel(file);
        if (importedRecords > 0) {
            System.out.println("Import thành công " + importedRecords + " bản ghi.");
        } else {
            System.out.println("Không có bản ghi nào được nhập.");
        }
        return importedRecords;
    }

}
