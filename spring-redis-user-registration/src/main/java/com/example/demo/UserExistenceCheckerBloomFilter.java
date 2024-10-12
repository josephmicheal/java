package com.example.demo;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class UserExistenceCheckerBloomFilter {

    // Name of the Bloom Filter in Redis
    private static final String BLOOM_FILTER_NAME = "user_existence_filter";

    public static void main(String[] args) {
        // Create a Redisson client
        RedissonClient redisson = createRedissonClient();

        // Retrieve or create a Bloom Filter instance
        // Expected number of elements and false positive probability are parameters
        RBloomFilter<String> bloomFilter = redisson.getBloomFilter(BLOOM_FILTER_NAME);
        bloomFilter.tryInit(100000L, 0.001); // Initialize the Bloom Filter with expected elements and false positive rate

        // Add a user to the Bloom Filter
        bloomFilter.add("user123");

        // Check if a user exists
        boolean exists = bloomFilter.contains("user123"); // Should return true
        // if it returns true then we can check again db as well to make sure this is not due to the false positive
        System.out.println("User 'user123' exists? " + exists);

        // Check for a non-existent user (might falsely report as true due to Bloom Filter's nature)
        exists = bloomFilter.contains("user456"); // Assuming not added, should ideally return false, but could be a false positive
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