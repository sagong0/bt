package Board.bt.service.board;

import Board.bt.domain.Board;
import Board.bt.domain.dto.BoardDto;
import Board.bt.repository.board.BoardSearchCond;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    void saveBoard(Board board);
    List<Board> findAllBoard(BoardSearchCond cond);
    int getTotalCount(BoardSearchCond cond);
    Optional<Board> findBoardById(Long boardId);
}
