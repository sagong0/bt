package Board.bt.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Comment {
    private Long idx;
    private String writer;
    private String comment;
    private LocalDateTime createdAt;
    private Long board_id;
    private Long user_id;
}
