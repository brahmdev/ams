package com.dev.ams.repository;

import com.dev.ams.model.Branch;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BranchRepository extends CrudRepository<Branch, String> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Branch b WHERE b.id = :branchId")
    public void deleteByBranchId(@Param("branchId") Integer branchId);

    @Query(value = "SELECT b FROM Branch b WHERE b.institute.id = :instituteId")
    public Iterable<Branch> findAllBranchByInstituteId(Integer instituteId);
}
