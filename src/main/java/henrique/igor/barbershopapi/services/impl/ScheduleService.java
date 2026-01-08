package henrique.igor.barbershopapi.services.impl;

import henrique.igor.barbershopapi.entities.Schedule;
import henrique.igor.barbershopapi.repositories.ScheduleRepository;
import henrique.igor.barbershopapi.services.IScheduleService;
import henrique.igor.barbershopapi.services.query.ScheduleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService implements IScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleQueryService queryService;

    @Override
    public Schedule save(Schedule entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndtAt());
        return scheduleRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        scheduleRepository.deleteById(id);
    }
}
