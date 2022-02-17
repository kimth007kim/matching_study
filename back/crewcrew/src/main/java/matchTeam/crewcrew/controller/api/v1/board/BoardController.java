package matchTeam.crewcrew.controller.api.v1.board;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import matchTeam.crewcrew.dto.board.BoardResponseDTO;
import matchTeam.crewcrew.dto.board.BoardSaveRequestDTO;
import matchTeam.crewcrew.dto.board.BoardSaveResponseDTO;
import matchTeam.crewcrew.dto.board.BoardUpdateRequestDTO;
import matchTeam.crewcrew.response.ErrorCode;
import matchTeam.crewcrew.response.ResponseHandler;
import matchTeam.crewcrew.service.board.BoardHitService;
import matchTeam.crewcrew.service.board.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Board Controller", tags = "4. board")
@ApiOperation(value = "게시판 생성, 삭제, 수정, 조회")
@RequiredArgsConstructor //생성자 주입
@RestController
public class BoardController {

    private final BoardService boardService;
    private final BoardHitService boardHitService;

    @ApiOperation(value = "게시글 생성", notes = "게시글을 생성한다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/board")
    public ResponseEntity<Object> save(@RequestBody BoardSaveRequestDTO req){
        //유효한 리퀘스트인지 확인
        boardService.checkValidSave(req);

        BoardSaveResponseDTO saveBoard = boardService.save(req);

        //uid가 일치하는지 확인
        boardService.checkMathchingUid(req.getUid(), saveBoard.getUid());

        return ResponseHandler.generateResponse("게시글 생성 성공", HttpStatus.OK,saveBoard);
    }

    @ApiOperation(value = "게시글 조회(번호로 조회)", notes = "게시글 번호로 조회한다.")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/board/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        BoardResponseDTO findBoard = boardService.findById(id);
        boardHitService.updateHit(id);
        return ResponseHandler.generateResponse("게시글 번호로 조회 성공",HttpStatus.OK, findBoard);
    }

    @ApiOperation(value = "게시글 수정(게시글 번호로 수정)", notes = "게시글 번호로 수정한다.")
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/board/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody BoardUpdateRequestDTO req){
        boardService.checkValidUpdate(req);

        Long updateBoardId = boardService.update(id, req);
        BoardResponseDTO updateBoard = boardService.findById(updateBoardId);

        boardService.checkMathchingUid(req.getUid(), updateBoard.getUid());
        boardService.checkMathchingBoardId(id, updateBoard.getBoardId());
        return ResponseHandler.generateResponse("게시글 번호로 수정 성공",HttpStatus.OK, updateBoard);
    }

    @ApiOperation(value = "게시글 삭제(게시글 번호로 삭제)", notes = "게시글 번호로 삭제한다.")
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/board/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        boardService.delete(id);
        return ResponseHandler.generateResponse(id+"번 게시글이 삭제 성공", HttpStatus.OK, id);
    }


}
