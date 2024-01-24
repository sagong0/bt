package Board.bt.repository.board;

import Board.bt.domain.Board;
import Board.bt.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository {
    Board saveBoard(Board board);
    List<Board> findAllBoard(BoardSearchCond cond);
    Optional<Board> findBoardById(Long boardId);

}
