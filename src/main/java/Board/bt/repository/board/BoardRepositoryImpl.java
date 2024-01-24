package Board.bt.repository.board;

import Board.bt.domain.Board;
import Board.bt.domain.Member;
import Board.bt.repository.mapper.BoardMapper;
import Board.bt.repository.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final BoardMapper boardMapper;

    @Override
    public Board saveBoard(Board board) {
        return boardMapper.saveBoard(board);
    }

    @Override
    public List<Board> findAllBoard(BoardSearchCond cond) {
        return null;
    }

    @Override
    public Optional<Board> findBoardById(Long boardId) {
        return boardMapper.findBoardById(boardId);
    }
}
