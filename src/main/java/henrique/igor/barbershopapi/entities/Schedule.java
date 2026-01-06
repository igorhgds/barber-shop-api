package henrique.igor.barbershopapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "SCHEDULES", uniqueConstraints = {
        @UniqueConstraint(name = "UK_SCHUDULE_INTERVAL", columnNames = {"start_at", "end_at"})
})
@Getter
@Setter
@ToString
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "start_at")
    private OffsetDateTime startAt;

    @Column(nullable = false, name = "end_at")
    private OffsetDateTime endtAt;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client = new Client();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Schedule schedule)) return false;
        return Objects.equals(id, schedule.id)
                && Objects.equals(startAt, schedule.startAt)
                && Objects.equals(endtAt, schedule.endtAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startAt, endtAt);
    }
}
