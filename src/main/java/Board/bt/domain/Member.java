package Board.bt.domain;

import Board.bt.domain.enums.MemberRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Member {
    private Long idx;

    @Size(min = 5, max = 10)
    @NotBlank(message = "사용자 아이디를 확인해주세요.")
    private String userId;

    private String userPw;
    private String username;

    @Range(min = 20, max = 100)
    private int age;
    private String gender;

    @Email
    private String email;
    private MemberRole role;
    private int point;
    private String profileImgUrl;
    private LocalDateTime createdAt;
}
