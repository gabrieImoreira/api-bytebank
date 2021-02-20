package com.gams.apibytebank.service;

import com.gams.apibytebank.controller.dto.ClientDto;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.repository.ClientRepository;
import com.gams.apibytebank.service.exceptions.DataIntegrityException;
import com.gams.apibytebank.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repo;


    public Client update(Client obj) {
        Client newObj = search(obj.getId()); //verify if exists id
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        search(id);
        try {
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir pq há entidades relacionadas");
        }
    }

    public Client search(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
    }

    public List<Client> findAll() {
        return repo.findAll();
    }

    private void updateData(Client newObj, Client obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setOccupation(obj.getOccupation());
        newObj.setType(obj.getType());
    }
}
