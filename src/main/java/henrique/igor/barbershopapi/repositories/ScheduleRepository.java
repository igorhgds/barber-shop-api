package henrique.igor.barbershopapi.repositories;

import henrique.igor.barbershopapi.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByStartAtGreaterThanEqualAndEndAtLessThenEqualOrderByStartAtEndAt(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt);

    boolean existsStartAtAndEndAt(final OffsetDateTime startAt, final OffsetDateTime endAt);
}
