package henrique.igor.barbershopapi.mappers;

import henrique.igor.barbershopapi.controllers.request.SaveClientRequest;
import henrique.igor.barbershopapi.controllers.request.UpdateClientRequest;
import henrique.igor.barbershopapi.controllers.response.*;
import henrique.igor.barbershopapi.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    Client toEntity(SaveClientRequest request);

    SaveClientResponse toSaveResponse(Client entity);

    @Mapping(target = "schedules", ignore = true)
    Client toEntity(Long id, UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(Client entity);

    ClientDetailResponse toDetailResponse(Client entity);

    List<ListClientResponse> toListResponse(List<Client> entities);
}
