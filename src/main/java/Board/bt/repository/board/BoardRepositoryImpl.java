package Board.bt.repository.board;

import Board.bt.domain.Board;
import Board.bt.domain.Member;
import Board.bt.repository.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {


    @Override
    public void saveBoard(Board board) {

    }

    @Override
    public List<Board> findAllBoard(BoardSearchCond cond) {
        return null;
    }
}
