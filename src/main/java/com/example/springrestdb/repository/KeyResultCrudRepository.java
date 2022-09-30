package com.example.springrestdb.repository;

import com.example.springrestdb.model.KeyResult;
import com.example.springrestdb.model.Objective;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyResultCrudRepository extends CrudRepository<KeyResult, Long> {
    List<KeyResult> findByName(@Param("name") String name);
    List<KeyResult> findByobjective(@Param("objective") Objective objective);
    List<KeyResult> findByIdLessOrSameThat(long id);
    List<KeyResult> findByIdGreaterThat(long id);

    int count(long id);
    int countKeyResultsForTheAssociatedObjective(long id);
    int countKeyResultsForTheAssociatedObjectiveNative(long id);
}
