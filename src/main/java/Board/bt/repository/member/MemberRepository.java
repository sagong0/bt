package Board.bt.repository.member;

import Board.bt.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {
    void save(Member member);
    List<Member> findAll();
}
