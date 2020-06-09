package com.authorsocks.soln.helper;

import com.authorsocks.soln.model.Author;

import java.util.Comparator;

public class SubmissionSorter implements Comparator<Author> {

    @Override
    public int compare(Author o1, Author o2) {
        if(o1.getSubmission_count() < o2.getSubmission_count()) {
            return 1;
        } else if(o1.getSubmission_count() > o2.getSubmission_count()) {
            return -1;
        } else {
            return 0;
        }
    }
}
