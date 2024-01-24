package Board.bt.repository;

import Board.bt.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void save(Member member);
    List<Member> findAll();
}
