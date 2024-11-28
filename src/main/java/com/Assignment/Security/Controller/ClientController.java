package com.Assignment.Security.Controller;

import com.Assignment.Security.Entity.Client;

import com.Assignment.Security.Service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class ClientController {

     @Autowired
     private ManageService manageService = new ManageService();


    @GetMapping
    public List<Client> getClient(){
          return manageService.getAll();
     }


     @PostMapping("/modify")
     public ResponseEntity<?> addClient(@RequestBody Client client){
          manageService.addClient(client);
         return  ResponseEntity.ok("Good");
     }


     @PostMapping("/modify/delete/{id}")
     public ResponseEntity<?> deleteClient(@PathVariable  String id){
          manageService.removeClient(id);
          return ResponseEntity.ok("Client Deleted");
     }

}
