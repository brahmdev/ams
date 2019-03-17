package com.dev.ams.repository;

import com.dev.ams.model.LectureScheduleStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LectureStatusRepository extends CrudRepository<LectureScheduleStatus, Integer> {

    @Query(value = "SELECT l FROM LectureScheduleStatus l WHERE l.lectureSchedule.id = :lectureScheduleId")
    public Iterable<LectureScheduleStatus> findByStatusByScheduleId(@Param("lectureScheduleId") Integer lectureScheduleId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM LectureScheduleStatus l WHERE l.lectureSchedule.id = :lectureScheduleId")
    public void deleteByLectureScheduleByScheduleId(@Param("lectureScheduleId") Integer lectureScheduleId);

}

