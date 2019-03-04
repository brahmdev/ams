package com.dev.ams.repository;

import com.dev.ams.model.Chapter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ChapterRepository extends CrudRepository<Chapter, String> {

    @Query(value = "SELECT c FROM Chapter c WHERE c.name = :chapterName")
    public Iterable<Chapter> findByChapterName(@Param("chapterName") String chapterName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Chapter c WHERE c.name = :chapterName")
    public void deleteByChapterName(@Param("chapterName") String chapterName);
}
