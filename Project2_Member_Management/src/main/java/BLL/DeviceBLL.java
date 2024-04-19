package BLL;

import DAL.DeviceDAL;
import DAL.baseDAL;
import POJOs.Device;
import POJOs.Usage;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;

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
        try
        {
            Device existingDevice = baseDeviceDAL.getById(device.getId());
            if (existingDevice != null)
            {
                System.err.println("Thiết bị đã tồn tại trong cơ sở dữ liệu với ID đã cho.");
                return false;
            }
            baseDeviceDAL.save(device);
            System.out.println("Thiết bị đã được lưu thành công vào cơ sở dữ liệu.");
            return true;
        } catch (Exception e)
        {
            System.err.println("Đã xảy ra lỗi khi lưu thiết bị vào cơ sở dữ liệu:");
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDevice(Device device) {
        try
        {
            baseDeviceDAL.update(device);
            System.out.println("Thiết bị đã được cập nhật thành công trong cơ sở dữ liệu.");
            return true;
        } catch (Exception e)
        {
            System.err.println("Đã xảy ra lỗi khi cập nhật thiết bị trong cơ sở dữ liệu:");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDevice(int id) {
        try
        {
            Device d = getDeviceById(id);
            baseDeviceDAL.delete(d);
            return true;
        } catch (Exception e)
        {
            System.err.println("Đã xảy ra lỗi khi xóa thiết bị trong cơ sở dữ liệu:");
            e.printStackTrace();
            return false;
        }
    }

    public List<Device> selectDeviecByYear(int year) {
        return deviceDAL.selectDeviceByYear(year);
    }

    public int deleteDeviecByYear(int year) {
        try
        {
            int count = deviceDAL.deleteDeviceByYear(year);
            return count;
        } catch (Exception e)
        {
            System.err.println("Đã xảy ra lỗi khi xóa thiết bị theo năm:");
            e.printStackTrace();
            return 0;
        }
    }

    public List<Device> searchDevice(String keyword) {
        String validKeyword = keyword.trim().toLowerCase();
        return deviceDAL.searchDevice(validKeyword);
    }

    public List<Device> queryDeviceByName(String name, int flag) {
        return deviceDAL.queryDeviceByName(name, flag);
    }

//    public List<Device> statisticDeviceIsBorrowing(LocalDate startDate, LocalDate endDate) {
//        Timestamp startTimestamp = null;
//        Timestamp endTimestamp = null;
//        if (startDate != null)
//        {
//            startTimestamp = Timestamp.valueOf(startDate.atStartOfDay());
//        }
//        if (endDate != null)
//        {
//            endTimestamp = Timestamp.valueOf(endDate.atStartOfDay());
//        }
//        return deviceDAL.statisticBorrowingDevice(startTimestamp, endTimestamp);
//    }

    public int importExcel(File file) {
        int importedRecords = deviceDAL.importExcel(file);
        if (importedRecords > 0)
        {
            System.out.println("Import thành công " + importedRecords + " bản ghi.");
        } else
        {
            System.out.println("Không có bản ghi nào được nhập.");
        }
        return importedRecords;
    }

    public Long queryBorrowedCount(int ID, LocalDate startDate, LocalDate endDate, int flag) {
        Device device = getDeviceById(ID);
        
        Timestamp startTimestamp = null;
        Timestamp endTimestamp = null;
        if (startDate != null)
        {
            startTimestamp = Timestamp.valueOf(startDate.atStartOfDay());
        }
        if (endDate != null)
        {
            endTimestamp = Timestamp.valueOf(endDate.atStartOfDay());
        }
        
        return deviceDAL.queryBorrowedCount(device, startTimestamp, endTimestamp, flag);
    }

}
