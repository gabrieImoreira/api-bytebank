package com.gams.apibytebank.controller;

import com.gams.apibytebank.controller.dto.ClientDto;
import com.gams.apibytebank.controller.dto.ClientNewDto;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.repository.ClientRepository;
import com.gams.apibytebank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientService service;

    @GetMapping
    public List<ClientDto> toList(){
        List<Client> clients = service.findAll();
        return ClientDto.convert(clients);
    }

    @GetMapping(value = "/{id}") //return dto
    public ResponseEntity<ClientDto> find(@PathVariable Integer id) { //@Path is to 'linkar' the id above
        Optional<Client> client = Optional.ofNullable(service.search(id)); //connected with @AutowiredClient service above
        if (client.isPresent()) {
            return ResponseEntity.ok(new ClientDto(client.get())); //return the response and found obj
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Integer id, @RequestBody @Valid ClientDto objDto) {
        Client obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientDto> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ClientDto> insert(@Valid @RequestBody ClientNewDto objDto){
        Client obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build(); //create new item in category

    }


}
