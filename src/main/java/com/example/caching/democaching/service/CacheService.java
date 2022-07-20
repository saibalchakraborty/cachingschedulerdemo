package com.example.caching.democaching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CacheService {
	
	@Autowired
	private CacheManager cacheManager;
	
	private void evictAllCaches() {
		cacheManager.getCacheNames().stream().forEach(cache -> {
			log.info("Emptying cache : {}", cache);
			cacheManager.getCache(cache).clear();
		});
	}

	@Scheduled(fixedRate = 300000)
	public void evictAllCacheAtIntervals() {
		evictAllCaches();
	}
}
