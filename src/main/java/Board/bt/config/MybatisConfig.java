package Board.bt.config;

import Board.bt.repository.MemberMapper;
import Board.bt.repository.MemberRepository;
import Board.bt.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {
    private final MemberMapper memberMapper;

    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl(memberMapper);
    }

}
