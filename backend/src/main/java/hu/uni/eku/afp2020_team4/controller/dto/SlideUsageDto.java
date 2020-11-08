package hu.uni.eku.afp2020_team4.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class SlideCreateRequestDto {
    private UUID userId;
    private String slideId;
    private Date usageDate;
}