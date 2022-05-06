package matchTeam.crewcrew.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import matchTeam.crewcrew.dto.board.BoardSaveRequestDTO;
import matchTeam.crewcrew.entity.application.Application;
import matchTeam.crewcrew.entity.board.Board;
import matchTeam.crewcrew.entity.user.User;
import matchTeam.crewcrew.repository.board.BoardRepository;
import matchTeam.crewcrew.repository.board.CategoryRepository;
import matchTeam.crewcrew.repository.user.UserRepository;
import matchTeam.crewcrew.response.exception.board.NotExistBoardInIdException;
import matchTeam.crewcrew.response.exception.category.NotExistCategoryException;
import matchTeam.crewcrew.util.customException.UserNotFoundException;


@NoArgsConstructor
@Getter
public class ApplicationSaveRequestDTO {

    @ApiParam(value = "해당 게시판에 지원하기를 요청한 유저의 uid")
    private Long uid;

    @ApiParam(value = "지원하기를 요청받은 게시판의 id")
    private Long boardId;

    @ApiParam(value = "한줄소개")
    private String commentary;

    public Application toEntity(ApplicationSaveRequestDTO req,
                                User user, Board board){

        return Application.builder()
                .board(board)
                .user(user)
                .commentary(req.getCommentary()).build();

    }
}
