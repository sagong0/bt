package Board.bt.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Board {
    private Long idx;
    private String title;
    private String content;
    private int like;
    private int disLike;
    private int count;
    private String fileUrl;
    private String fileName;
    private String writer;
    private LocalDateTime createdAt;
}
