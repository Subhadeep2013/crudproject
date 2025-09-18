package com.example.crudproject.repository;

import com.example.crudproject.model.MongoPerson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPersonRepository extends MongoRepository<MongoPerson, String> {
}
