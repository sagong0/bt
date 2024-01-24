package Board.bt.config;

import Board.bt.repository.board.BoardRepository;
import Board.bt.repository.board.BoardRepositoryImpl;
import Board.bt.repository.mapper.BoardMapper;
import Board.bt.repository.mapper.MemberMapper;
import Board.bt.repository.member.MemberRepository;
import Board.bt.repository.member.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {
    private final MemberMapper memberMapper;
    private final BoardMapper boardMapper;

    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl(memberMapper);
    }
    public BoardRepository boardRepository(){
        return new BoardRepositoryImpl(boardMapper);
    }

}
