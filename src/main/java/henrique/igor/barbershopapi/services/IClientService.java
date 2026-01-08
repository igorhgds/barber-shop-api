package henrique.igor.barbershopapi.services;

import henrique.igor.barbershopapi.entities.Client;

public interface IClientService {

    Client save(final Client entity);

    Client update(final Client entity);

    void delete(final long id);
}
