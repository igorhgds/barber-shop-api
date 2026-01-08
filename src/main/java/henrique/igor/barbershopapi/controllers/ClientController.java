package henrique.igor.barbershopapi.controllers;

import henrique.igor.barbershopapi.controllers.request.SaveClientRequest;
import henrique.igor.barbershopapi.controllers.request.UpdateClientRequest;
import henrique.igor.barbershopapi.controllers.response.*;
import henrique.igor.barbershopapi.mappers.ClientMapper;
import henrique.igor.barbershopapi.services.IClientService;
import henrique.igor.barbershopapi.services.query.ClientQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService service;
    private final ClientQueryService queryService;
    private final ClientMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    SaveClientResponse save(@RequestBody @Valid SaveClientRequest request){
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("/{id}")
    UpdateClientResponse update(@PathVariable long id, @RequestBody @Valid UpdateClientRequest request){
        var entity = mapper.toEntity(id, request);
        service.update(entity);
        return mapper.toUpdateResponse(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable long id){
        service.delete(id);
    }

    @GetMapping("{id}")
    ClientDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }

    @GetMapping
    List<ListClientResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }
}
