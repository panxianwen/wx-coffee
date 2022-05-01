package com.yu.common.service.cache;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


// TODO 本地内存缓存(单机, 缓存的数据也不多就可以代替redis), 主要用来存储常用的大对象, 要小心OOM
public class LocalCache {


    // 封装本地缓存的值对象
    @Data
    private static class CacheItem<T> {
        private T value;
        private long expireTime;

        public CacheItem(T value) {
            this.value = value;
            this.expireTime = Long.MAX_VALUE; // 过期时间默认永久
        }

        // 缓存时间
        public CacheItem(T value, long ttl) {
            this.value = value;
            this.expireTime = System.currentTimeMillis() + ttl * 1000;
        }
    }

    // 本地缓存的值的保存地
    public static ConcurrentHashMap<String, CacheItem> localCacheMap = new ConcurrentHashMap<String, CacheItem>();

    // 获取缓存
    public static <T> T get(String key) {
        CacheItem<T> cacheItem = localCacheMap.get(key);
        if (cacheItem != null && System.currentTimeMillis() < cacheItem.getExpireTime())  // 存在且没过期
            return cacheItem.getValue();
        localCacheMap.remove(key);
        return null;
    }

    // 判断本地缓存里是否有某个key
    public static <T> boolean hasKey(String key) {
        CacheItem<T> cacheItem = localCacheMap.get(key);
        if (cacheItem == null)
            return false;
        if (System.currentTimeMillis() >= cacheItem.getExpireTime()) { // 过期了
            localCacheMap.remove(key);
            return false;
        }
        return true;
    }

    public static <T> CacheItem<T> set(String key, T value) {
        return localCacheMap.put(key, new CacheItem<T>(value));
    }

    // 单位：秒
    public static <T> CacheItem<T> set(String key, T value, long ttl) {
        return localCacheMap.put(key, new CacheItem<T>(value, ttl));
    }

    public static boolean del(String key) {
        return localCacheMap.remove(key) != null;
    }

    // 清理过期的缓存
    public static synchronized void clearCacheExpired() {
        ConcurrentHashMap<String, CacheItem> map = new ConcurrentHashMap<String, CacheItem>();
        long currentTimeStamp = System.currentTimeMillis();
        for (Map.Entry<String, CacheItem> entry : localCacheMap.entrySet())
            if (currentTimeStamp < entry.getValue().getExpireTime()) // 没有过期
                map.put(entry.getKey(), entry.getValue());
        localCacheMap = map;
        localCacheMap = null;
    }

}
