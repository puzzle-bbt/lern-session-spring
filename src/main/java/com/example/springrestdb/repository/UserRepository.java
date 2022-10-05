package com.example.springrestdb.repository;

import com.example.springrestdb.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserRepository extends CrudRepository<User, Long>, QueryByExampleExecutor<User> {
}
