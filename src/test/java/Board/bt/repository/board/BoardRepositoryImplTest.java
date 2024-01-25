package Board.bt.repository.board;

import Board.bt.domain.Board;
import Board.bt.repository.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

class BoardRepositoryImplTest {
    @Autowired
    private final BoardRepositoryImpl boardRepository;

    @Autowired
    BoardRepositoryImplTest(BoardRepositoryImpl boardRepository) {
        this.boardRepository = boardRepository;

    }




}