package com.nagpal.bala.playgroundapp.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.TrackingArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.support.caching.CacheAccessor;
import io.lettuce.core.support.caching.CacheFrontend;
import io.lettuce.core.support.caching.ClientSideCaching;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RedisCacheMain {

    private static final String REDIS_URL = "redis://localhost:6379/";

    public static void main(String[] args) {
        RedisClient redisClient = RedisClient
               .create(REDIS_URL);

        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("track:key", "Hello, Redis!");

//        String value = syncCommands.get("track:key");
//        System.out.println("value = " + value);

        Map<String, String> clientCache = new ConcurrentHashMap<>();
//        CacheFrontend<String, String> frontend = ClientSideCaching.enable(CacheAccessor.forMap(clientCache), connection,
//                TrackingArgs.Builder.enabled().bcast().prefixes("track:"));
//
//        while(true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
////            syncCommands.clientCaching(true);
//            String clinetValue = frontend.get("track:key");
//            System.out.println("clinetValue = " + clinetValue);
//        }
          optInClientCache(syncCommands, clientCache, connection);
          bcastClientCache(clientCache, connection);

    }

    private static void optInClientCache(RedisCommands<String, String> syncCommands,
                                         Map<String, String> clientCache, StatefulRedisConnection<String, String> connection) {

        CacheFrontend<String, String> frontend = ClientSideCaching.enable(CacheAccessor.forMap(clientCache), connection,
                TrackingArgs.Builder.enabled().optin());

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            syncCommands.clientCaching(true);
            String clinetValue = frontend.get("track:key");
            System.out.println("clinetValue = " + clinetValue);
        }
    }

    private static void bcastClientCache(Map<String, String> clientCache, StatefulRedisConnection<String, String> connection) {

        CacheFrontend<String, String> frontend = ClientSideCaching.enable(CacheAccessor.forMap(clientCache), connection,
                TrackingArgs.Builder.enabled().bcast().prefixes("track:"));

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String clinetValue = frontend.get("track:key");
            System.out.println("clinetValue = " + clinetValue);
        }
    }
}
