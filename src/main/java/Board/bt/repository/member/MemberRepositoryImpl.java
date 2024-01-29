package Board.bt.repository.member;

import Board.bt.domain.Member;
import Board.bt.repository.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{

    private final MemberMapper memberMapper;

    @Override
    public int save(Member member) {
        return this.memberMapper.save(member);
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public Optional<Member> findOneByUserId(String userId) {
        return memberMapper.findOneByUserId(userId);
//        return findAll().stream()
//                .filter(m -> m.getUserId().equals(userId))
//                .findFirst();
    }

    @Override
    public Optional<Member> findByIdx(Long idx) {
        return memberMapper.findByIdx(idx);
    }

    @Override
    public int updateMember(Long midx) {
        return memberMapper.updateMember(midx);
    }
}
