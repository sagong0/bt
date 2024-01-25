package Board.bt.domain.dto;

import Board.bt.domain.enums.MemberRole;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
    private String userId, userPw, username;
    private int age;
    private String gender, email;
    private MemberRole role;
}
