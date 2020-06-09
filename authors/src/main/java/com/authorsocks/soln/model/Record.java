package com.authorsocks.soln.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<Author> data;
}
