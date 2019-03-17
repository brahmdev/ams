package com.dev.ams.repository;

import com.dev.ams.model.StudentAttendance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentAttendanceRepository extends CrudRepository<StudentAttendance, Integer> {

    @Query(value = "SELECT s FROM StudentAttendance s WHERE s.studentDetails.id = :studentDetailsId")
    public Iterable<StudentAttendance> findByStudentDetailId(@Param("studentDetailsId") Integer studentDetailsId);

    @Query(value = "SELECT s FROM StudentAttendance s WHERE s.studentDetails.id = (SELECT sd.id " +
            "FROM StudentDetails sd WHERE sd.users.username = :studentName)")
    public Iterable<StudentAttendance> findAttendanceByStudentName(@Param("studentName") String studentName);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Standard s WHERE s.name = :standardName")
    public void deleteByStandardName(@Param("standardName") String standardName);
}