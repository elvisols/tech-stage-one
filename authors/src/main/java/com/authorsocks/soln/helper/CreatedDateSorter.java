package com.authorsocks.soln.helper;

import com.authorsocks.soln.model.Author;

import java.util.Comparator;

public class CreatedDateSorter implements Comparator<Author> {

    @Override
    public int compare(Author o1, Author o2) {

        return -o1.getCreated_at().compareTo(o2.getCreated_at());
    }
}
