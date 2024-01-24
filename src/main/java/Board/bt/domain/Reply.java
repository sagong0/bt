package Board.bt.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Reply {
    private Long idx;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
    private Long commentId;
    private Long memberId;
}
