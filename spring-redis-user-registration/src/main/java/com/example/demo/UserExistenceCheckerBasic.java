package com.example.demo;
import org.redisson.Redisson;  
import org.redisson.api.RedissonClient;  
import org.redisson.config.Config;  
import org.redisson.api.RMap;  
  
public class UserExistenceCheckerBasic {  
  
    // Redis hash map name to store user information  
    private static final String USER_HASH_NAME = "users";  
  
    public static void main(String[] args) {  
        // Create a Redisson client  
        RedissonClient redisson = createRedissonClient();  
  
        // Retrieve the hash map to store user information  
        RMap<String, String> users = redisson.getMap(USER_HASH_NAME);  
  
        // Add a user to the hash map  
        users.put("user123", "someUserInfo"); // Here "someUserInfo" could be a JSON string, UUID, etc.  
  
        // Check if a user exists  
        boolean exists = users.containsKey("user123");  
        System.out.println("User 'user123' exists? " + exists);  
  
        // Check for a non-existent user  
        exists = users.containsKey("user456");  
        System.out.println("User 'user456' exists? " + exists);  
  
        // Shutdown the Redisson client  
        redisson.shutdown();  
    }  
  
    // Helper method to create a Redisson client  
    private static RedissonClient createRedissonClient() {  
        Config config = new Config();  
        config.useSingleServer()  
                .setAddress("redis://127.0.0.1:6379") // Adjust to your Redis address  
                .setPassword("password"); // Provide your Redis password if any  
  
        return Redisson.create(config);  
    }  
}