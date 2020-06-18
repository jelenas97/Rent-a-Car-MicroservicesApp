package com.statistics.service;

import com.statistics.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    Long addComment(CommentDTO dto);
    Long addCommentOwner(CommentDTO dto);
    List<CommentDTO> findProcessedAdvertisementComments(long id);
}
