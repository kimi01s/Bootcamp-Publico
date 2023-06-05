package com.example.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

	UserModel findByEmail(String email);
}
