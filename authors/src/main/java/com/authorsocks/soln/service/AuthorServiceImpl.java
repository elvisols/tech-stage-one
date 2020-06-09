package com.authorsocks.soln.service;

import com.authorsocks.soln.helper.CommentSorter;
import com.authorsocks.soln.helper.CreatedDateSorter;
import com.authorsocks.soln.helper.SubmissionSorter;
import com.authorsocks.soln.model.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private static final int CONSTANT = 0; // an arbitrary constant key value

    private CacheService fromCache;

    public AuthorServiceImpl(CacheService fromCache) {
        this.fromCache = fromCache;
    }

    public List<String> getUsernames(Integer threshold) {

        List<String> result = new ArrayList<>();

        List<Author> detail = fromCache.fetchAllRecords(CONSTANT);

        detail.sort(new SubmissionSorter());

        for(int i = 0; i < threshold; i++) {
            result.add(detail.get(i).getUsername());
        }

        return result;

    }

    @Override
    public String getUsernameWithHighestCommentCount() {

        List<Author> detail = fromCache.fetchAllRecords(CONSTANT);

        detail.sort(new CommentSorter());

        return detail.get(0).getUsername();
    }

    @Override
    public List<String> getUsernamesSortedByRecordDate(Integer threshold) {

        List<String> result = new ArrayList<>();

        List<Author> detail = fromCache.fetchAllRecords(CONSTANT);

        detail.sort(new CreatedDateSorter());

        for(int i = 0; i < threshold; i++) {
            result.add(detail.get(i).getUsername());
        }

        return result;
    }

}
