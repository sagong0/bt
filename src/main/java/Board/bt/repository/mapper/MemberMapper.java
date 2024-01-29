package Board.bt.repository.mapper;

import Board.bt.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    int save(Member member);
    List<Member> findAll();

    Optional<Member> findOneByUserId(String userId);

    Optional<Member> findByIdx(Long idx);

    int updateMember(Long idx);
}
