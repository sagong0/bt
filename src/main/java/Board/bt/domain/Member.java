package Board.bt.domain;

import Board.bt.domain.enums.MemberRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Member {
    private Long midx;

    @Size(min = 5, max = 10)
    @NotBlank(message = "사용자 아이디를 확인해주세요.")
    private String userId;

    @NotEmpty
    private String userPw;
    @NotEmpty
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

    public Member() {
    }

    public Member(Long midx, String userId, String userPw, String username, int age, String gender, String email, MemberRole role, int point, String profileImgUrl, LocalDateTime createdAt) {
        this.midx = midx;
        this.userId = userId;
        this.userPw = userPw;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.role = role;
        this.point = point;
        this.profileImgUrl = profileImgUrl;
        this.createdAt = createdAt;
    }
}
