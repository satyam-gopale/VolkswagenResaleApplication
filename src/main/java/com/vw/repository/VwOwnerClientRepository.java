package com.vw.repository;

import com.vw.entity.VwOwnerDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface VwOwnerClientRepository extends MongoRepository<VwOwnerDetail,Integer> {

}
