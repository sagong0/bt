package Board.bt.config;

import Board.bt.repository.mapper.MemberMapper;
import Board.bt.repository.member.MemberRepository;
import Board.bt.repository.member.MemberRepositoryImpl;
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
