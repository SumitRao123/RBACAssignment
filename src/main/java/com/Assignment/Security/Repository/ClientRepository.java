package com.Assignment.Security.Repository;

import com.Assignment.Security.Entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client,String> {

}
