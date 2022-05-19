package matchTeam.crewcrew.dto.application;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateApplyRequestDTO {

    @ApiModelProperty(value = "신청서 id")
    private Long apId;

    @ApiModelProperty(value = "신청서를 작성한 유저의 uid")
    private Long uid;

    @ApiModelProperty(value = "신청서의 상태(0: 참여거절, 1: 참여요청중, 2: 참여완료, 3: 참여취소)")
    private Integer statusCode;

    public UpdateApplyRequestDTO(Long apId, Long uid, Integer statusCode) {
        this.apId = apId;
        this.uid = uid;
        this.statusCode = statusCode;
    }
}
