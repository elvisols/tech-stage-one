package com.authorsocks.soln.helper;

import com.authorsocks.soln.model.Author;

import java.util.Comparator;

public class CommentSorter implements Comparator<Author> {

    @Override
    public int compare(Author o1, Author o2) {
        if(o1.getComment_count() < o2.getComment_count()) {
            return 1;
        } else if(o1.getComment_count() > o2.getComment_count()) {
            return -1;
        } else {
            return 0;
        }
    }
}
