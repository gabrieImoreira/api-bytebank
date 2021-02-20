package com.gams.apibytebank.repository;

import com.gams.apibytebank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

   // List<Client> findByAccountId(Integer id);

}
