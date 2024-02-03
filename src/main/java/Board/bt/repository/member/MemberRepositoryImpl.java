package Board.bt.repository.member;

import Board.bt.domain.Member;
import Board.bt.repository.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
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
    public void updateMember(Long midx) {
        log.info("midx = {}",midx);
        log.info("midxClass={}",midx.getClass());
        memberMapper.updateMember(midx);
    }
}
