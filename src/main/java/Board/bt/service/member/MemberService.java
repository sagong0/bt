package Board.bt.service.member;

import Board.bt.domain.Member;
import Board.bt.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원가입
    public int join(Member member){

       return this.memberRepository.save(member);
    }

    // 아이디 중복체크
    public String userIdCheck(String userId){
        Optional<Member> findMember = this.memberRepository.findOneByUserId(userId);

//        log.info("findMember = {}", findMember.get());

        if(findMember.isEmpty()){
            // 사용 가능한 아이디
            return "canuse";
        } else{
            return "nouse";
        }

    }
}
