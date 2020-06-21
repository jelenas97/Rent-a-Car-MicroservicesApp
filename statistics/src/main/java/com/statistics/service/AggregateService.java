package com.statistics.service;


import com.statistics.dto.CommentAndRateDTO;

public interface AggregateService {

    CommentAndRateDTO getCommentedAndRatedRequ(Long id);
}
