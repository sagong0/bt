package Board.bt.controller;

import Board.bt.domain.Board;
import Board.bt.service.CdnService;
import Board.bt.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardServiceImpl boardService;
    private final CdnService cdnService;

    @GetMapping("/boardList")
    public String boardList() {

        return "board/boardList";
    }

    @GetMapping("/write")
    public String boardFormCreate() {
        return "board/boardForm";
    }

    @PostMapping("/createBoard")
    public String createBoard(@ModelAttribute Board board,
                              @RequestParam(required = false, value = "file")
                              MultipartFile file) {
        if (file.getSize() == 0) {
            boardService.saveBoard(board);
            return "redirect:/board/boardList";
        } else {
            board.setFileUrl(cdnService.fileUpload(file));
            board.setFileName(file.getOriginalFilename());
            boardService.saveBoard(board);
        }
        System.out.println(board);
        return "redirect:/board/boardList";
    }
}
