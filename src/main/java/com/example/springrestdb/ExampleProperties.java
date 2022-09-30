package com.example.springrestdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "example")
public class ExampleProperties {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleProperties.class);
    private String applicationName;
    private List<String> companies;
    private Map<String,String> fruits;
    private Server server;

    public ExampleProperties() {
        LOG.info("constructor ExampleProperties");
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        LOG.info("set applicationName: '{}'", applicationName);
        this.applicationName = applicationName;
    }
    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }

    public Map<String, String> getFruits() {
        return fruits;
    }

    public void setFruits(Map<String, String> fruits) {
        this.fruits = fruits;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public static class Server {
        private String name;
        private String host;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            LOG.info("setName: '{}'", name);
            this.name = name;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            LOG.info("setMyhost: '{}'", host);
            this.host = host;
        }
    }
}
