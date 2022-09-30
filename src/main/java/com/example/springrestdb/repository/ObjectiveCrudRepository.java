package com.example.springrestdb.repository;

import com.example.springrestdb.model.Objective;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectiveCrudRepository extends CrudRepository<Objective, Long> {
    List<Objective> findByName(@Param("name") String name);

    // this is the SpEL (Spring Expression Language)
    @Query("from Objective o where mod(o.id, 2)=0")
    List<Objective> findByEvenId();

    @Query(value = "select * from objective o where mod(o.id, 2)=1", nativeQuery = true)
    List<Objective> findByOddId();


}
