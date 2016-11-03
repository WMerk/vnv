package com.vnv;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.johm.JOhm;

import javax.annotation.PostConstruct;


/**
 * Created by Gabriel on 02.11.2016.
 */
@Component
public class Database {

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
        initRedis();
        initNeo4j();
    }

    private void initRedis() {
        JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(), host, redisPort,
                redis.clients.jedis.Protocol.DEFAULT_TIMEOUT, redisPassword);
        JOhm.setPool(jedisPool);
    }

    private void initNeo4j() {
        Driver driver = GraphDatabase.driver( "bolt://"+host, AuthTokens.basic( neo4jUser, neo4jPassword ) );
        neo4j = driver.session();
    }
}

