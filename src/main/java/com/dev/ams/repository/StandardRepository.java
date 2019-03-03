package com.dev.ams.repository;

import com.dev.ams.model.Standard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StandardRepository extends CrudRepository<Standard, String> {

    @Query(value = "SELECT s FROM Standard s WHERE s.name = :standardName")
    public Optional<Standard> findByStandardName(@Param("standardName") String standardName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Standard s WHERE s.name = :standardName")
    public void deleteByStandardName(@Param("standardName") String standardName);
}
