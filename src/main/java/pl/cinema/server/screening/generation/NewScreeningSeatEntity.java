package pl.cinema.server.screening.generation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
@Table(name = "screening_seats")
class NewScreeningSeatEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(STRING)
    private FreeSeatStatus status;

    private Long row;
    private Long number;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private NewScreeningEntity screening;
}
