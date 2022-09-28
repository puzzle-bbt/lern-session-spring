package com.example.springrestdb.repository;

import com.example.springrestdb.model.Objective;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectiveRepository extends CrudRepository<Objective, Long> {
    List<Objective> findByName(@Param("name") String name);
}
