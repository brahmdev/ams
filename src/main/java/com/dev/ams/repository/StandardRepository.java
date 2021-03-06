package com.dev.ams.repository;

import com.dev.ams.model.Standard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StandardRepository extends CrudRepository<Standard, String> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Standard s WHERE s.id = :standardId")
    public void deleteByStandardId(@Param("standardId") Integer standardId);

    @Query(value = "SELECT s FROM Standard s WHERE s.board.id IN (SELECT b.id from Board b WHERE b.branch.id = :branchId)")
    Iterable<Standard> findAllStandardByBranchId(Integer branchId);

    @Query(value = "SELECT s FROM Standard s WHERE s.id = :standardId")
    Standard findStandardById(Integer standardId);
}
