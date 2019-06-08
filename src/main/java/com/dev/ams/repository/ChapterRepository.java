package com.dev.ams.repository;

import com.dev.ams.model.Chapter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ChapterRepository extends CrudRepository<Chapter, String> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Chapter c WHERE c.id = :chapterId")
    public void deleteByChapterId(@Param("chapterId") Integer chapterId);

    @Query(value = "SELECT c FROM Chapter c where c.subject.id IN (\n" +
            "\tSELECT id FROM Subject sub WHERE sub.standard.id IN (\n" +
            "\tSELECT id FROM Standard s WHERE s.board.id IN (\n" +
            "\t\tSELECT id FROM Board b WHERE b.institute.id = :instituteId\n" +
            "    )\n" +
            "))")
    Iterable<Chapter> finAllChapterByInstituteId(Integer instituteId);
}
