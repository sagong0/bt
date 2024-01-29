package Board.bt.repository.member;

import Board.bt.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    int save(Member member);
    List<Member> findAll();

    Optional<Member> findOneByUserId(String userId);

    Optional<Member> findByIdx(Long midx);

    int updateMember(Long midx);
}
