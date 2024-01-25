package Board.bt.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString

public class Board {
    private Long idx;
    private String title;
    private String content;
    private Integer like;
    private Integer dislike;
    private Integer count;
    private String fileUrl;
    private String fileName;
    private String writer;
    private Long memberId;
    private LocalDateTime createdAt;



}
