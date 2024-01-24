package Board.bt.repository;

import Board.bt.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
    void save(Member member);
}
