package henrique.igor.barbershopapi.services;

import henrique.igor.barbershopapi.entities.Client;

public interface ClientService {

    Client save(final Client entity);

    Client update(final Client entity);

    void delete(final long id);
}
