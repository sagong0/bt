package Board.bt.service.board;

import Board.bt.domain.Board;
import Board.bt.domain.dto.BoardDto;
import Board.bt.repository.board.BoardRepositoryImpl;
import Board.bt.repository.board.BoardSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        List<Board> boardList = Collections.emptyList();
        int totalCount = boardRepository.getTotalCount(cond);
        if(totalCount>0){
            cond.setTotalPages((int) Math.ceil((double) totalCount / cond.getPageSize()));
            boardList = boardRepository.findAllBoard(cond);
        }
        return boardList;
    }

    @Override
    public int getTotalCount(BoardSearchCond cond) {
        return boardRepository.getTotalCount(cond);
    }

    @Override
    public Optional<Board> findBoardById(Long boardId) {
        return boardRepository.findBoardById(boardId);
    }

    //조회수 증가
    @Override
    public void updateCount(Long boardId) {
        boardRepository.updateCount(boardId);
    }
}
