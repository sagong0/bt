package Board.bt.repository.mapper;

import Board.bt.domain.Board;
import Board.bt.repository.board.BoardSearchCond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void saveBoard(Board board);

    List<Board> findAllBoard(BoardSearchCond cond);
}
