package Board.bt.domain.dto;

import Board.bt.repository.board.BoardSearchCond;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto extends BoardSearchCond {
    private Long idx;
    private String title;
    private String content;
    private Integer boardLike;
    private Integer dislike;
    private Integer count;
    private String fileUrl;
    private String fileName;
    private String writer;
    private Long memberId;
    private String createdAt;
    private BoardSearchCond boardSearchCond;

}
