package com.dev.ams.repository;

import com.dev.ams.model.Subject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SubjectRepository extends CrudRepository<Subject, String> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Subject s WHERE s.id = :subjectId")
    public void deleteBySubjectId(@Param("subjectId") Integer subjectId);

    @Query(value = "SELECT sub FROM Subject sub WHERE sub.standard.id IN (\n" +
            "\tSELECT id FROM Standard s WHERE s.board.id IN (\n" +
            "\t\tSELECT id FROM Board b WHERE b.branch.id = :branchId\n" +
            "    )\n" +
            ")")
    Iterable<Subject> findAllSubjectByBranchId(Integer branchId);
}
