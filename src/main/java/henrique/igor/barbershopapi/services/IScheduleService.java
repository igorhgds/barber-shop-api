package henrique.igor.barbershopapi.services;

import henrique.igor.barbershopapi.entities.Schedule;

public interface IScheduleService {

    Schedule save(final Schedule entity);

    void delete(final long id);
}
