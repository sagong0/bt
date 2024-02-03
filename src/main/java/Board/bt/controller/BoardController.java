package Board.bt.controller;

import Board.bt.domain.Board;
import Board.bt.domain.Member;
import Board.bt.repository.board.BoardSearchCond;
import Board.bt.service.CdnService;
import Board.bt.service.board.BoardServiceImpl;
import Board.bt.utils.session.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {
    private final BoardServiceImpl boardService;
    private final CdnService cdnService;

    @GetMapping("/boardList")
    public String boardList(Model model,
                            @ModelAttribute("cond") BoardSearchCond cond) {
        List<Board> boards = boardService.findAllBoard(cond);
        model.addAttribute("boards", boards);
        model.addAttribute("cond",cond);
        return "board/boardList";
    }

    @GetMapping("/write")
    public String boardFormCreate(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        log.info("member={}", member);
        model.addAttribute("member", member);
        return "board/boardForm";
    }

    @PostMapping("/createBoard")
    public String createBoard(@ModelAttribute Board board,
                              @RequestParam(required = false, value = "file")
                              MultipartFile file) {
        log.info("board={}",board);
        if (file.getSize() == 0) {
            boardService.saveBoard(board);
            return "redirect:/board/boardList";
        } else {
            board.setFileUrl(cdnService.fileUpload(file));
            board.setFileName(file.getOriginalFilename());
            boardService.saveBoard(board);
        }
        return "redirect:/board/boardList";
    }
    @GetMapping("/{boardId}")
    public String boardDesc(@PathVariable(name="boardId") Long boardId,Model model,HttpSession session){

        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Optional<Board> board = boardService.findBoardById(boardId);
        if(board.isEmpty()){
            return "redirect:/board/boardList";
        }
        boardService.updateCount(board.get().getIdx());
        model.addAttribute("board",board.get());
        model.addAttribute("member",member);
        log.info("board={}",board.get());
        log.info("member={}",member);
        return "board/board";
    }
}
