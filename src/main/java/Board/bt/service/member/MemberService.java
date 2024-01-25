package Board.bt.service.member;

import Board.bt.domain.Member;
import Board.bt.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원가입
    public int join(Member member){

       return this.memberRepository.save(member);
    }
}
