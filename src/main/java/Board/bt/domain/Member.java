package Board.bt.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Member {
    private Long idx;
    private String username;
    private String userpw;
    private int point;
    private String profileImgUrl;
    private LocalDateTime createdAt;
}
