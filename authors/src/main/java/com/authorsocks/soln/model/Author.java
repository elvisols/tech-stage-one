package com.authorsocks.soln.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private Integer id;
    private String username;
    private String about;
    private Integer submitted;
    private Instant updated_at = Instant.now();
    private Integer submission_count;
    private Integer comment_count;
    private Instant created_at;
}

