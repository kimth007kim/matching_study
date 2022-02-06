package matchTeam.crewcrew.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import matchTeam.crewcrew.entity.board.Board;
import matchTeam.crewcrew.entity.board.BoardApproach;

import java.time.LocalDate;

@Getter
public class BoardSaveResponseDTO {
    private Long id;
    private String title;
    private String boardContent;
    private Integer recruitedCrew;
    private Integer totalCrew;
    private BoardApproach approach;
    private Long categoryId;
    private LocalDate expiredDate;

    @Builder
    public BoardSaveResponseDTO(Board res) {
        this.id = res.getId();
        this.title = res.getTitle();
        this.boardContent = res.getBoardContent();
        this.recruitedCrew = res.getRecruitedCrew();
        this.totalCrew = res.getTotalCrew();
        this.approach = res.getApproach();
        this.categoryId = res.getCategory().getId();
        this.expiredDate = res.getExpiredDate();
    }
}
