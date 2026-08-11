package org.xue.infrastructure.redis;

import org.redisson.api.*;

/**
 * Redis 服务
 */
public interface IRedisService {

    <T> void setValue(String key, T value);

    <T> void setValue(String key, T value, long expired);

    <T> T getValue(String key);

    <T> RQueue<T> getQueue(String key);

    <T> RBlockingQueue<T> getBlockingQueue(String key);

    <T> RDelayedQueue<T> getDelayedQueue(RBlockingQueue<T> rBlockingQueue);

    long incr(String key);

    long incrBy(String key, long delta);

    long decr(String key);

    long decrBy(String key, long delta);

    void remove(String key);

    boolean isExists(String key);

    void addToSet(String key, String value);

    boolean isSetMember(String key, String value);

    void addToList(String key, String value);

    String getFromList(String key, int index);

    <K, V> RMap<K, V> getMap(String key);

    void addToMap(String key, String field, String value);

    String getFromMap(String key, String field);

    <K, V> V getFromMap(String key, K field);

    void addToSortedSet(String key, String value);

    RLock getLock(String key);

    RLock getFairLock(String key);

    RReadWriteLock getReadWriteLock(String key);

    RSemaphore getSemaphore(String key);

    RPermitExpirableSemaphore getPermitExpirableSemaphore(String key);

    RCountDownLatch getCountDownLatch(String key);

    <T> RBloomFilter<T> getBloomFilter(String key);

}
