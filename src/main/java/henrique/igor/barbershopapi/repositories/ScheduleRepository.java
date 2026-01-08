package henrique.igor.barbershopapi.repositories;

import henrique.igor.barbershopapi.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt);

    @Query("SELECT COUNT(s) > 0 FROM Schedule s WHERE s.startAt < :endAt AND s.endAt > :startAt")
    boolean existsOverlapping(@Param("startAt") OffsetDateTime startAt, @Param("endAt") OffsetDateTime endAt);
}
