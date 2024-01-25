package Board.bt.repository.member;

import Board.bt.domain.Member;
import Board.bt.repository.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        List<Member> members = memberMapper.findAll();
        return members;
    }

}
