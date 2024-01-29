package Board.bt.domain.form;

import Board.bt.domain.enums.MemberRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter @Setter @ToString
public class MemberEditForm {
    @NotNull
    private Long midx;
    @NotEmpty
    private String userId;
    @Email(message = "올바른 이메일 형식을 사용해주세요.")
    private String email;
    @Range(min = 20 ,max = 80,message = "20세 이상 80이하만 가입 가능합니다.")
    private int age;
    private MemberRole role;
}
