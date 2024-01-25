package Board.bt.service.board;

import Board.bt.domain.Board;
import Board.bt.repository.board.BoardRepositoryImpl;
import Board.bt.repository.board.BoardSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepositoryImpl boardRepository;

    @Override
    public void saveBoard(Board board) {
        boardRepository.saveBoard(board);
    }

    @Override
    public List<Board> findAllBoard(BoardSearchCond cond) {


        return boardRepository.findAllBoard(cond);
    }

    @Override
    public Optional<Board> findBoardById(Long boardId) {
        return boardRepository.findBoardById(boardId);
    }
}
