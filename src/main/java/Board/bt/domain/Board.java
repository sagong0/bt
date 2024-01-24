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
    private int like;
    private int disLike;
    private int count;
    private String fileUrl;
    private String fileName;
    private String writer;
    private Long memberId;
    private LocalDateTime createdAt;


    public Board(String title, String content, int like, int disLike, int count, String fileUrl, String fileName, String writer, Long memberId) {
        this.title = title;
        this.content = content;
        this.like = like;
        this.disLike = disLike;
        this.count = count;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.writer = writer;
        this.memberId = memberId;
    }
}
