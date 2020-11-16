package hu.uni.eku.afp2020_team4.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlideUsageCreateRequestDto {
    private Integer usageId;
    private UUID guestId;
    private Integer slideId;
    private Date timestamp;
}