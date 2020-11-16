package hu.uni.eku.afp2020_team4.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class SlideUsageDto {
    private Integer usageId;
    private UUID userId;
    private Integer slideId;
    private Date timestamp;
}