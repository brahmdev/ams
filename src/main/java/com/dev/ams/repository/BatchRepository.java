package com.dev.ams.repository;

import com.dev.ams.model.Batch;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BatchRepository extends CrudRepository<Batch, String> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Batch b WHERE b.id = :batchId")
    public void deleteByBatchId(@Param("batchId") Integer batchId);

    @Query(value = "SELECT b FROM Batch b WHERE b.standard.id IN (\n" +
            "\tSELECT id FROM Standard s WHERE s.board.id IN (\n" +
            "\t\tSELECT id FROM Board b WHERE b.branch.id IN (\n" +
            "\t\t\tSELECT id FROM Branch b WHERE b.id = :branchId\n" +
            "        )\n" +
            "    )\n" +
            ")")
    Iterable<Batch> findAllBatchByBranchId(Integer branchId);

    @Query(value = "SELECT b FROM Batch b WHERE b.standard.id = :standardId")
    Iterable<Batch> findAllBatchByStandardId(Integer standardId);
}
