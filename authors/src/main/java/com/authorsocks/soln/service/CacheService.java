package com.authorsocks.soln.service;

import com.authorsocks.soln.model.Author;
import com.authorsocks.soln.model.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CacheService {

    private RestTemplate restTemplate;

    public CacheService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value="fetchAllRecords", key="#constant")
    public List<Author> fetchAllRecords(int constant) {

        log.info("getting records...");

        Record rec1 = restTemplate.getForObject("https://jsonmock.hackerrank.com/api/article_users/search?page=1", Record.class);
        Record rec2 = restTemplate.getForObject("https://jsonmock.hackerrank.com/api/article_users/search?page=2", Record.class);

        assert rec1 != null;
        List<Author> details = new ArrayList<>(rec1.getData());

        assert rec2 != null;
        details.addAll(rec2.getData());

        return details;
    }
}
