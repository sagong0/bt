package Board.bt.repository.board;

import Board.bt.domain.Board;
import Board.bt.domain.dto.BoardDto;
import Board.bt.repository.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final BoardMapper boardMapper;

    @Override
    public void saveBoard(Board board) {
         boardMapper.saveBoard(board);
    }

    @Override
    public List<Board> findAllBoard(BoardSearchCond cond) {
       return boardMapper.findAllBoard(cond);
    }
    @Override
    public Optional<Board> findBoardById(Long boardId) {
        return boardMapper.findBoardById(boardId);
    }

    @Override
    public int getTotalCount(BoardSearchCond cond) {
        return boardMapper.countBoard(cond);
    }
}
