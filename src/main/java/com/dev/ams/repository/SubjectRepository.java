package com.dev.ams.repository;

import com.dev.ams.model.Subject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SubjectRepository extends CrudRepository<Subject, String> {

    @Query(value = "SELECT s FROM Subject s WHERE s.name = :subjectName")
    public Iterable<Subject> findBySubjectName(@Param("subjectName") String subjectName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Subject s WHERE s.name = :subjectName")
    public void deleteBySubjectName(@Param("subjectName") String subjectName);
}
