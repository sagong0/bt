package Board.bt.repository.board;

import Board.bt.domain.Board;
import Board.bt.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {
    void saveBoard(Board board);
    List<Board> findAllBoard(BoardSearchCond cond);

}
