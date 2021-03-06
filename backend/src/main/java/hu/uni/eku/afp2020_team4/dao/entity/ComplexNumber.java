package hu.uni.eku.afp2020_team4.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComplexNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private double realPart;
    @Column
    private double imaginaryPart;
}
