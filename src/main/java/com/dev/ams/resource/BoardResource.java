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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/boards")
public class BoardResource {

    @Autowired
    BoardRepository boardRepository;

    @RequestMapping(value = "/{instituteId}/{boardName}", method = RequestMethod.GET)
    public Optional<Board> getBoard(@PathVariable("instituteId") Integer instituteId, @PathVariable("boardName") String boardName) {
        return boardRepository.findByBoardName(instituteId, boardName);
    }

    @RequestMapping(value = "/{instituteId}", method = RequestMethod.GET)
    public Iterable<Board> getAllBoards(@PathVariable Integer instituteId) {
        return boardRepository.findAllBoardByInstituteId(instituteId);
    }

    @RequestMapping(value = "/{instituteId}/lookup", method = RequestMethod.GET)
    public Map<Integer, String> getAllBoardsLookUp(@PathVariable Integer instituteId) {
        Iterable<Board> boards = boardRepository.findAllBoardByInstituteId(instituteId);
        Map<Integer, String> boardLookUp = new HashMap<Integer, String>();
        for (Board board: boards) {
            boardLookUp.put(board.getId(), board.getCode());
        }
        return boardLookUp;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Board saveOrUpdateBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @RequestMapping(value = "/{boardId}", method = RequestMethod.DELETE)
    public void deleteBoard(@PathVariable("boardId") Integer boardId) {
        boardRepository.deleteByBoardId(boardId);
    }


}
