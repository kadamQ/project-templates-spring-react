package hu.uni.eku.afp2020_team4.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlideCreateRequestDto {
    private UUID guestId;
    private String slideId;
    private String watchId;
}