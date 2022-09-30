package com.example.springrestdb.controller;

import com.example.springrestdb.model.KeyResult;
import com.example.springrestdb.repository.KeyResultCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/keyresult")
public class KeyResultController {
    private static final Logger LOG = LoggerFactory.getLogger(KeyResultController.class);

    @Autowired
    KeyResultCrudRepository keyResultRepository;

    @GetMapping("")
    public List<KeyResult> getAllObjectives() {
        LOG.info("Get all KeyResults");
        return (List<KeyResult>) keyResultRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<KeyResult> getObjective(@PathVariable long id) {
        LOG.info("get all KeyResult with id '{}'", id);
        return keyResultRepository.findById(id);
    }

    @GetMapping("findByIdLessOrSameThat/{id}")
    public List<KeyResult> findByIdLessOrSameThat(@PathVariable long id) {
        LOG.info("findByIdLessOrSameThat '{}'", id);
        return keyResultRepository.findByIdLessOrSameThat(id);
    }

    @GetMapping("findByIdGreaterThat/{id}")
    public List<KeyResult> findByIdGreaterThat(@PathVariable long id) {
        LOG.info("findByIdGreaterThat '{}'", id);
        return keyResultRepository.findByIdGreaterThat(id);
    }

    @GetMapping("count/{id}")
    public Integer count(@PathVariable long id) {
        LOG.info("count '{}'", id);
        return keyResultRepository.count(id);
    }

    @GetMapping("countKeyResultsForTheAssociatedObjective/{id}")
    public Integer countKeyResultsForTheAssociatedObjective(@PathVariable long id) {
        LOG.info("countKeyResultsForTheAssociatedObjective '{}'", id);
        return keyResultRepository.countKeyResultsForTheAssociatedObjective(id);
    }

    @GetMapping("countKeyResultsForTheAssociatedObjectiveNative/{id}")
    public Integer countKeyResultsForTheAssociatedObjectiveNative(@PathVariable long id) {
        LOG.info("countKeyResultsForTheAssociatedObjectiveNative '{}'", id);
        return keyResultRepository.countKeyResultsForTheAssociatedObjectiveNative(id);
    }
}
