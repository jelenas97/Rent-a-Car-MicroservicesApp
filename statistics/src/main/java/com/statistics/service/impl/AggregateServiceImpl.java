package com.statistics.service.impl;


import com.statistics.dto.CommentAndRateDTO;
import com.statistics.model.Comment;
import com.statistics.model.Rate;
import com.statistics.repository.CommentRepository;
import com.statistics.repository.RateRepository;
import com.statistics.service.AggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregateServiceImpl implements AggregateService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    RateRepository rateRepository;


    @Override
    public CommentAndRateDTO getCommentedAndRatedRequ(Long id) {

        CommentAndRateDTO dto = new CommentAndRateDTO();

        List<Comment> commList = this.commentRepository.findByUserId(id);
        if(commList!=null) {
            List<Long> comRentRequIdList = new ArrayList<>();
            for (Comment c : commList) {
                comRentRequIdList.add(c.getRentRequestId());
            }
            dto.setCommentedRentRequests(comRentRequIdList);
        }

        List<Rate> rateList = this.rateRepository.findByClientId(id);
        if(rateList!=null) {
            List<Long> rateRentRequIdList = new ArrayList<>();
            for (Rate r : rateList) {
                rateRentRequIdList.add(r.getRentRequestId());
            }
            dto.setRatedRentRequests(rateRentRequIdList);
        }
        return dto;
    }
}
