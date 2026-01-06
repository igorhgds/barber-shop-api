package henrique.igor.barbershopapi.services.query;

import henrique.igor.barbershopapi.entities.Schedule;

import java.time.OffsetDateTime;
import java.util.List;

public interface ScheduleQueryService {

    Schedule findById(final Long id);

    List<Schedule> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);

    void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt);
}
