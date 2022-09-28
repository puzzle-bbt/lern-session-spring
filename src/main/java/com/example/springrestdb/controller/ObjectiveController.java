package com.example.springrestdb.controller;

import com.example.springrestdb.model.Objective;
import com.example.springrestdb.repository.ObjectiveRepository;
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
    ObjectiveRepository objectiveRepository;

    @GetMapping("")
    public List<Objective> getAllObjectives() {
        LOG.info("Get all objectives");
        return (List<Objective>) objectiveRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Objective> getObjective(@PathVariable long id) {
        LOG.info("getAllObjectives with id '{}'", id);
        return objectiveRepository.findById(id);
    }

    @GetMapping({"findByName/{name}", "findByNameAndOrganisation/{name}/{organisation}"})
    public List<Objective>  getObjectiveByName(@PathVariable String name, @PathVariable Optional<String> organisation) {
        LOG.info("getAllObjectives with name '{}'", name);
        if (organisation.isPresent()) {
            LOG.info("find Objectives with name '{}' and organisation '{}'", name, organisation.get());
        } else {
            LOG.info("find Objectives with name '{}'", name);
        }
        // Find only by name
        return objectiveRepository.findByName(name);
    }
}
