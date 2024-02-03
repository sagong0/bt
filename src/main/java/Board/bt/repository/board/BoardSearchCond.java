package Board.bt.repository.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
@ToString
public class BoardSearchCond {
    private String keyword;       // 검색 키워드 (검색어)
    private String searchType;    // 검색 유형
    private int currentPageNo;    // 현재 페이지
    private int recordsPerPage;   // 페이지 당 출력 게시글
    private int pageSize;         // 페이지 사이즈
    private int totalPages;       // 페이징 된 페이지 수
    public int getStartPage() {
        return (currentPageNo - 1) * recordsPerPage;
    }
    public BoardSearchCond() {
        this.currentPageNo =  currentPageNo < 1 ? 1 : currentPageNo;
        this.recordsPerPage = 10;
        this.pageSize = 10;
    }

}
