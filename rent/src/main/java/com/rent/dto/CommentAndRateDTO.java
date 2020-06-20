package com.rent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CommentAndRateDTO {

    private List<Long> commentedRentRequests;
    private List<Long> ratedRentRequests;
}
