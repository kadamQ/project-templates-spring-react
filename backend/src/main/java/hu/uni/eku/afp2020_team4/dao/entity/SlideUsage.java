package hu.uni.eku.afp2020_team4.dao.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SlideUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer usageId;
    @Column
    private UUID userId;
    @Column
    private Integer slideId;
    @Column
    private Date timestamp;
}
