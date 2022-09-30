package com.example.springrestdb.controller;

import com.example.springrestdb.model.Objective;
import com.example.springrestdb.repository.KeyResultCrudRepository;
import com.example.springrestdb.repository.ObjectiveCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/objectives")
public class ObjectiveController {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectiveController.class);

    @Autowired
    ObjectiveCrudRepository objectiveCrudRepository;
    @Autowired
    KeyResultCrudRepository keyResultCrudRepository;

    @GetMapping("")
    public List<Objective> getAllObjectives() {
        LOG.info("Get all objectives");
        return (List<Objective>) objectiveCrudRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Objective> getObjective(@PathVariable long id) {
        LOG.info("getAllObjectives with id '{}'", id);
        return objectiveCrudRepository.findById(id);
    }

    @GetMapping({"findByName/{name}", "findByNameAndOrganisation/{name}/{organisation}"})
    public List<Objective>  getObjectiveByName(@PathVariable String name, @PathVariable Optional<String> organisation) {
        LOG.info("getAllObjectives with name '{}'", name);
        if (organisation.isPresent()) {
            LOG.info("find Objectives with name '{}' and organisation '{}'", name, organisation.get());
        } else {
            LOG.info("find Objectives with name '{}'", name);
        }
        return objectiveCrudRepository.findByName(name);
    }

    @GetMapping("findByEvenId")
    public List<Objective> findByEvenId() {
        LOG.info("findByEvenId");
        return objectiveCrudRepository.findByEvenId();
    }

    @GetMapping("findByOddId")
    public List<Objective> findByOddId() {
        LOG.info("findByOddId");
        return objectiveCrudRepository.findByOddId();
    }
}
