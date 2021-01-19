package pl.cinema.server.screening.query.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Table(name = "screening_seats")
public class ScreeningSeatReadEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(STRING)
    private SeatStatus status;

    private Long row;
    private Long number;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private ScreeningReadEntity screening;
}
