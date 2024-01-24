package Board.bt.repository;

import Board.bt.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{

    private final MemberMapper memberMapper;

    @Override
    public void save(Member member) {
        this.memberMapper.save(member);
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = memberMapper.findAll();
        System.out.println(members);
        return members;
    }

}
