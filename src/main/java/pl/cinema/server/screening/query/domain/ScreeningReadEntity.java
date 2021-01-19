package pl.cinema.server.screening.query.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Table(name = "screenings")
public class ScreeningReadEntity {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String movieTitle;
    private String roomName;

    @OneToMany(mappedBy = "screening", orphanRemoval = true, fetch = LAZY)
    private List<ScreeningSeatReadEntity> seats;
}
