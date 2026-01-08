package henrique.igor.barbershopapi.services.impl;

import henrique.igor.barbershopapi.entities.Client;
import henrique.igor.barbershopapi.repositories.ClientRepository;
import henrique.igor.barbershopapi.services.IClientService;
import henrique.igor.barbershopapi.services.query.ClientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientQueryService queryService;

    @Override
    public Client save(Client entity) {
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return clientRepository.save(entity);
    }

    @Override
    public Client update(Client entity) {
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored = queryService.findById(entity.getId());
        stored.setName(entity.getName());
        stored.setEmail(entity.getEmail());
        stored.setPhone(entity.getPhone());

        return clientRepository.save(stored);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        clientRepository.deleteById(id);
    }
}
