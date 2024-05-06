    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
     */
    package com.project3.Member_Management_SpringBoot.repository;

    import com.project3.Member_Management_SpringBoot.model.Device;
    import com.project3.Member_Management_SpringBoot.model.Member;
    import com.project3.Member_Management_SpringBoot.model.Usage;

    import java.util.List;

    import java.sql.Timestamp;
    import java.util.Date;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    /**
     *
     * @author buing
     */
    @Repository
    public interface UsageRepository extends CrudRepository<Usage, Integer> {
        Usage findMemberById(Integer id);

        @Query("SELECT u FROM Usage u WHERE u.member.id = :memberId AND u.reserveTime IS NOT NULL")
        List<Usage> findByMemberIdAndReserveTimeNotNull(@Param("memberId") Integer memberId);

        @Query("SELECT u FROM Usage u WHERE u.device = ?1 AND DATE(u.reserveTime) = ?2")
        List<Usage> checkValidateDevice(Device selectedDevice, Date reserveDate);

        @Query(value = "SELECT * FROM `thongtinsd` u WHERE DATE_ADD(u.tgdatcho, INTERVAL 1 HOUR) <=  :deadline", nativeQuery = true)
        List<Usage> findOverdueReservation(Timestamp deadline);
        @Query("SELECT u FROM Usage u WHERE u.member.id = :memberId AND u.paidTime IS NOT NULL")
        public List<Usage> findByMemberIdAndBorrowedTimeIsNotNull(@Param("memberId") Integer memberId);
        @Query("SELECT m FROM Member m JOIN FETCH m.usages WHERE m.id = :memberId")
        Member findMemberWithUsages(@Param("memberId") Integer memberId);

    }
