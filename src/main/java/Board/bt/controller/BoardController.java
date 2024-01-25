package Board.bt.controller;

import Board.bt.domain.Board;
import Board.bt.repository.board.BoardSearchCond;
import Board.bt.service.CdnService;
import Board.bt.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {
    private final BoardServiceImpl boardService;
    private final CdnService cdnService;

    @GetMapping("/boardList")
    public String boardList(Model model, BoardSearchCond cond) {
        List<Board> boards = boardService.findAllBoard(cond);
        model.addAttribute("boards",boards);
        log.info("board1 = {}",boards.get(1));
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
        log.info("createdBoard={}",board);
        return "redirect:/board/boardList";
    }
}
