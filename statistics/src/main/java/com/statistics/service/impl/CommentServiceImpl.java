package com.statistics.service.impl;

import com.statistics.client.AuthenticationClient;
import com.statistics.dto.CommentDTO;
import com.statistics.dto.UserDTO;
import com.statistics.enumerations.ApproveStatus;
import com.statistics.model.Comment;
import com.statistics.repository.CommentRepository;
import com.statistics.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthenticationClient authenticationClient;

    @Override
    public Long addComment(CommentDTO dto) {

        Comment comment = new Comment();
        comment.setStatus(ApproveStatus.UNPROCESSED);
        comment.setAdvertisementId(dto.getAdvertisement_id());
        comment.setContent(dto.getContent());
        comment.setDate(dto.getDate());
        comment.setUserId(dto.getCommenter_id());
        comment.setRentRequestId(dto.getRent_request_id());

        Comment c =this.commentRepository.save(comment);

        return c.getId();
    }

    @Override
    public Long addCommentOwner(CommentDTO dto) {

        Comment comment = new Comment();
        comment.setStatus(ApproveStatus.APPROVED);
        comment.setAdvertisementId(dto.getAdvertisement_id());
        comment.setContent(dto.getContent());
        comment.setDate(dto.getDate());
        comment.setUserId(dto.getCommenter_id());

        Comment c =this.commentRepository.save(comment);

        return c.getId();
    }

    @Override
    public List<CommentDTO> findProcessedAdvertisementComments(long id) {

        List<Comment> comments = this.commentRepository.findByAdvertisementIdAndStatus(id, ApproveStatus.APPROVED);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for(Comment com : comments){
            UserDTO dto = this.authenticationClient.getUser(String.valueOf(com.getUserId()));
            commentDTOS.add(new CommentDTO(com , 0, dto));
        }

        return commentDTOS;
    }
}
