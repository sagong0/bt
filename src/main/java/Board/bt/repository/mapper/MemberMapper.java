package Board.bt.repository.mapper;

import Board.bt.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    int save(Member member);
    List<Member> findAll();
}
