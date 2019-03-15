package com.dev.ams.repository;

import com.dev.ams.model.LectureSchedule;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LecturesRepository extends CrudRepository<LectureSchedule, Integer> {

    @Query(value = "SELECT l FROM LectureSchedule l WHERE l.subject.id = :subjectId")
    public Iterable<LectureSchedule> findBySubjectId(@Param("subjectId") String subjectId);

    @Query(value = "SELECT l FROM LectureSchedule l WHERE l.id = :lectureId")
    public Iterable<LectureSchedule> findByLectureId(@Param("lectureId") String lectureId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM LectureSchedule l WHERE l.subject.id = :subjectId")
    public void deleteBySubjectId(@Param("subjectId") String subjectId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM LectureSchedule l WHERE l.id = :lectureId")
    public void deleteByLectureId(@Param("lectureId") String lectureId);
}
