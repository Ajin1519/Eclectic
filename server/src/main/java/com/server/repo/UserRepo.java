package com.server.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.server.bean.Users;
@Repository
public interface UserRepo extends MongoRepository<Users,String>{
    Optional<Users> findByUserName(String userName);
}
