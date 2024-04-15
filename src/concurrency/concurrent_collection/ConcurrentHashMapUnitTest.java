package concurrency.concurrent_collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapUnitTest {

    private Map<Integer, Integer> frequencyMap;

    @BeforeEach
    public void setup() {
        frequencyMap = new ConcurrentHashMap<>();
        frequencyMap.put(0, 0);
        frequencyMap.put(1, 0);
        frequencyMap.put(2, 0);
    }

    @AfterEach
    public void teardown() {
        frequencyMap.clear();
    }

    private static void sleep(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}