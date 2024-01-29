package Board.bt.repository.board;

import Board.bt.domain.Board;
import Board.bt.domain.dto.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository {
    void saveBoard(Board board);
    List<Board> findAllBoard(BoardSearchCond cond);
    Optional<Board> findBoardById(Long boardId);
    int getTotalCount(BoardSearchCond cond);
    void updateCount(Long boardId);

}
