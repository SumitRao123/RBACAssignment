package com.Assignment.Security.Service;

import com.Assignment.Security.Entity.Client;
import com.Assignment.Security.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageService {

    @Autowired
    ClientRepository clientRepository;

    public void addClient(Client client){
        clientRepository.save(client);
    }
    public  void removeClient(String id){
        clientRepository.deleteById(id);
    }
    public Client getById(String id){
         return clientRepository.findById(id).orElse(null);
    }
    public List<Client> getAll(){
         return clientRepository.findAll();
    }




}
