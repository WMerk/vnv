package com.vnv.Model;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.johm.JOhm;

import javax.annotation.PostConstruct;

@Profile("prod")
@Component
public class Database {

    private static Logger log = LoggerFactory.getLogger(Database.class);

    public static Session neo4j = null;

    private static final String host = "dhbw-projekt.data.kit.edu";
    private static final int redisPort = 6379;

    @Value("${database.redis.password}")
    private String redisPassword;
    @Value("${database.neo4j.password}")
    private String neo4jPassword;
    @Value("${database.neo4j.user}")
    private String neo4jUser;

    @PostConstruct
    public void init() {
        log.debug("init DB");
        initRedis();
        initNeo4j();
    }

    private void initRedis() {
        log.debug("init Redis");
        JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(), host, redisPort,
                redis.clients.jedis.Protocol.DEFAULT_TIMEOUT, redisPassword);
        JOhm.setPool(jedisPool);
    }

    private void initNeo4j() {
        log.debug("init Neo4j");
        Driver driver = GraphDatabase.driver( "bolt://"+host, AuthTokens.basic( neo4jUser, neo4jPassword ) );
        neo4j = driver.session();
    }
}

