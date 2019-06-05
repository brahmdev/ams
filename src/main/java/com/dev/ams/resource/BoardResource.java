package com.dev.ams.resource;

import com.dev.ams.model.Board;
import com.dev.ams.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/boards")
public class BoardResource {

    @Autowired
    BoardRepository boardRepository;

    @RequestMapping(value = "/{boardName}", method = RequestMethod.GET)
    public Optional<Board> getBoard(@PathVariable String boardName) {
        return boardRepository.findByBoardName(boardName);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Board saveOrUpdateBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @RequestMapping(value = "/{boardName}", method = RequestMethod.DELETE)
    public void deleteBoard(@PathVariable String boardName) {
        boardRepository.deleteByBoardName(boardName);
    }
}
