package com.dev.ams.repository;

import com.dev.ams.model.Board;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BoardRepository extends CrudRepository<Board, String> {

    @Query(value = "SELECT b FROM Board b WHERE b.name = :boardName and b.institute.id = :instituteId")
    public Optional<Board> findByBoardName(Integer instituteId, @Param("boardName") String boardName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Board b WHERE b.id = :boardId and b.institute.id = :instituteId")
    public void deleteByBoardId(@Param("instituteId") Integer instituteId, @Param("boardId") Integer boardId);

    @Query(value = "SELECT b FROM Board b WHERE b.institute.id = :instituteId")
    public Iterable<Board> findByAllBoardInstituteId(Integer instituteId);
}
