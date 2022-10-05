package com.example.springrestdb;

import com.example.springrestdb.model.KeyResult;
import com.example.springrestdb.model.Objective;
import com.example.springrestdb.model.User;
import com.example.springrestdb.repository.KeyResultCrudRepository;
import com.example.springrestdb.repository.ObjectiveCrudRepository;
import com.example.springrestdb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInitializingBean implements InitializingBean {
    private static final Logger LOG = LoggerFactory.getLogger(DbInitializingBean.class);

    @Autowired
    ObjectiveCrudRepository objectiveCrudRepository;

    @Autowired
    KeyResultCrudRepository keyResultCrudRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void afterPropertiesSet() {
        LOG.info("Prepare the database");

        createObjective("Objective 1");
        createObjective("Objective 2");
        createObjective("Objective 3");
        createObjective("Objective 4");
        LOG.info("Create {} Objectives.", this.objectiveCrudRepository.count());

        createUser("Fritz", "Müller", "fritz@puzzle.ch", 31);
        createUser("Franz", "Müller", "franz@puzzle.ch", 32);
        createUser("Peter", "Meier", "peter@meierag.ch", 33);
    }

    private void createObjective(String name) {
        Objective objective = new Objective();
        objective.setName(name);
        this.objectiveCrudRepository.save(objective);
        createKeyResult(name + " / KeyResult 1", objective);
        createKeyResult(name + " / KeyResult 2", objective);
    }

    private void createKeyResult(String name, Objective objective) {
        KeyResult keyResult = new KeyResult();
        keyResult.setName(name);
        keyResult.setObjective(objective);
        this.keyResultCrudRepository.save(keyResult);
    }

    private void createUser(String firstname, String lastname, String email, int age) {
        userRepository.save(User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .age(age)
                .build());
    }
}
