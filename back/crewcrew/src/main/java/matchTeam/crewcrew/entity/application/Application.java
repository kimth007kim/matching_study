package matchTeam.crewcrew.entity.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import matchTeam.crewcrew.entity.board.Board;
import matchTeam.crewcrew.entity.user.User;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "application", indexes = {
        @Index(name = "fk_application_board_idx", columnList = "board_id"),
        @Index(name = "fk_application_user_idx", columnList = "uid")
})
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User uid;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "progress")
    private Integer progress;

    @Builder
    public Application(Board board, User uid, String progress) {
        this.board = board;
        this.uid = uid;
        this.commentary = commentary;
        this.progress= 1;
    }
}