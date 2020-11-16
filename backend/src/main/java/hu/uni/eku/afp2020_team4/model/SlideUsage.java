package hu.uni.eku.afp2020_team4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SlideUsage {
    private Integer usageId;
    private UUID userId;
    private Integer slideId;
    private Date timestamp;
}