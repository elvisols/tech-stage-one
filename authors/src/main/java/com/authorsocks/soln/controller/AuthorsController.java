package com.authorsocks.soln.controller;

import com.authorsocks.soln.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private AuthorService service;

    public AuthorsController(AuthorService service) {
        this.service = service;
    }

    /**
     * This function would retrieve the names of the most active authors(using submission_count as the criteria)
     * according to a set threshold.
     * @param threshold
     * @return list of authors
     * @throws Exception
     */
    @GetMapping("/active-list/{threshold}")
    public List<String> getUsernames(@PathVariable int threshold) throws Exception {

        return service.getUsernames(threshold);
    }

    /**
     * This function would retrieve the name of the author with the highest comment count.
     * @return author name
     */
    @GetMapping("/highest-comment-count")
    public String getUsernameWithHighestCommentCount() {

        return service.getUsernameWithHighestCommentCount();
    }

    /**
     * This function returns the list of the authors sorted by when their record was created according to a set threshold.
     * @param threshold
     * @return list of authors
     */
    @GetMapping("/created-list/{threshold}")
    public List<String> getUsernamesSortedByRecordDate(@PathVariable int threshold) {

        return service.getUsernamesSortedByRecordDate(threshold);
    }

}
