package com.authorsocks.soln.service;

import java.util.List;

public interface AuthorService {

    List<String> getUsernames(Integer threshold);

    String getUsernameWithHighestCommentCount();

    List<String> getUsernamesSortedByRecordDate(Integer threshold);

}
