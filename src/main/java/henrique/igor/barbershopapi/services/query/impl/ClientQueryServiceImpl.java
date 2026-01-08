package henrique.igor.barbershopapi.services.query.impl;

import henrique.igor.barbershopapi.entities.Client;
import henrique.igor.barbershopapi.exceptions.*;
import henrique.igor.barbershopapi.repositories.ClientRepository;
import henrique.igor.barbershopapi.services.query.ClientQueryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository clientRepository;

    @Override
    public Client findById(long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Não foi encontrado o cliente de id " + id));
    }

    @Override
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @Override
    public void verifyPhone(String phone) {
        if (clientRepository.existsByPhone(phone)) {
            var message = "O telefone " + phone + " já está em uso";
            throw new PhoneAlreadyUsedException(message);
        }
    }

    @Override
    public void verifyPhone(long id, String phone) {
        var optional = clientRepository.findByPhone(phone);
        if (optional.isPresent() && optional.get().getId() != id) {
            var message = "O telefone " + phone + " já está em uso";
            throw new PhoneAlreadyUsedException(message);
        }
    }

    @Override
    public void verifyEmail(String email) {
        if (clientRepository.existsByEmail(email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new EmailAlreadyUsedException(message);
        }
    }

    @Override
    public void verifyEmail(long id, String email) {
        var optional = clientRepository.findByPhone(email);
        if (optional.isPresent() && optional.get().getId() != id) {
            var message = "O e-mail " + email + " já está em uso";
            throw new PhoneAlreadyUsedException(message);
        }
    }
}
