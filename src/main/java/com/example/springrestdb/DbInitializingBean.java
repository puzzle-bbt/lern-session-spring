package com.example.springrestdb;

import com.example.springrestdb.model.Objective;
import com.example.springrestdb.repository.ObjectiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInitializingBean implements InitializingBean {
    private static final Logger LOG = LoggerFactory.getLogger(DbInitializingBean.class);

    @Autowired
    ObjectiveRepository objectiveRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("Prepare the database");

        createObjective("Objective 1");
        createObjective("Objective 2");
        createObjective("Objective 3");
        createObjective("Objective 4");
        LOG.info("Create {} Objectives.", this.objectiveRepository.count());
    }

    private void createObjective(String name) {
        Objective objective = new Objective();
        objective.setName(name);
        this.objectiveRepository.save(objective);
    }
}
