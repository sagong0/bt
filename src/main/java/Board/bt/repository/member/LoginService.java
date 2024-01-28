package Board.bt.repository.member;

import Board.bt.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null : 로그인 실패
     */
    public Member login(String userId, String password){

        return memberRepository.findOneByUserId(userId)
                .filter(m -> m.getUserPw().equals(password))
                .orElse(null);
    }
}
