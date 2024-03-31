package BLL;

import DAL.MemberDAL;
import DAL.baseDAL;
import POJOs.Member;
import POJOs.Device;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberBLL {

    private baseDAL<Member> baseMemberDAL;
    private MemberDAL memberDAL;

    public MemberBLL() {
        this.memberDAL = new MemberDAL();
        this.baseMemberDAL = new baseDAL<>(Member.class);
    }

    public List<Member> selectAll() {
        return baseMemberDAL.selectAll();
    }

    public Member getMemberById(int id) {
        return baseMemberDAL.getById(id);
    }

    public void insertMember(Member member) {
        baseMemberDAL.save(member);
    }

    public void updateMember(Member member) {
        baseMemberDAL.update(member);
    }

    public void deleteMember(int id) {
        baseMemberDAL.delete(id);
    }

    public List<Member> statisticByDepartment(String department) {
        return memberDAL.statisticByDepartment(department);
    }

    public List<Member> statisticByMajor(String major) {
        return memberDAL.statisticByMajor(major);
    }

    public List<Member> timeBasedStatistics(String startDate, String endDate) {
        return memberDAL.timeBasedStatistics(startDate, endDate);
    }
    public static void main(String[] args) {
         Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        DeviceBLL deviceBLL = new DeviceBLL();


        Device device = new Device();
        device.setId(1000028);
        device.setName("TV2");
        device.setDescription("TV2 test");
        device.setStatus(1);
        deviceBLL.insertDevice(device);

        List<Device> devices = deviceBLL.selectAll();
        devices.forEach(System.out::println);
    }
}
