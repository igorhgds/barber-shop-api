package henrique.igor.barbershopapi.services.query.impl;

import henrique.igor.barbershopapi.entities.Schedule;
import henrique.igor.barbershopapi.exceptions.NotFoundException;
import henrique.igor.barbershopapi.exceptions.ScheduleAlreadyUsedException;
import henrique.igor.barbershopapi.repositories.ScheduleRepository;
import henrique.igor.barbershopapi.services.query.ScheduleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleQueryServiceImpl implements ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public Schedule findById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Agendamento não encontrado"));
    }

    @Override
    public List<Schedule> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return scheduleRepository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {
        if (scheduleRepository.existsByStartAtAndEndAt(startAt, endAt)){
            var message = "Já Existe um cliente agendado no horário solicitado";
            throw new ScheduleAlreadyUsedException(message);
        }
    }
}
