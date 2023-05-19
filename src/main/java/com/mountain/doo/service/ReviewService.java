package com.mountain.doo.service;


import com.mountain.doo.dto.page.Search;
import com.mountain.doo.dto.review.ReviewDetailResponseDTO;
import com.mountain.doo.dto.review.ReviewListResponseDTO;
import com.mountain.doo.dto.review.ReviewRewriteRequestDTO;
import com.mountain.doo.dto.review.ReviewWriteRequestDTO;
import com.mountain.doo.entity.Review;
import com.mountain.doo.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class ReviewService {

    //repository에 의존

    private final ReviewMapper reviewRepository;


    // 게시글 전체목록 처리
    public List<ReviewListResponseDTO> getList(Search page){
        return reviewRepository.findAll(page)
                .stream()
                .map(ReviewListResponseDTO::new)
                .collect(toList());
    }

    // 게시글 상세조회 처리
    public ReviewDetailResponseDTO getDetail(int reviewNo){
        Review review = reviewRepository.findOne(reviewNo);

        //조회수 상승 처리
        reviewRepository.upViewCount(reviewNo);


        return new ReviewDetailResponseDTO(review);
    }

    // 글 등록 처리
    public boolean register(ReviewWriteRequestDTO dto){
        Review review = new Review(dto);
        return reviewRepository.save(review);
    };

    // 글 삭제 처리
    public boolean delete(int boardNo){
        return reviewRepository.deleteReview(boardNo);
    }

    // 글 수정 처리
    public boolean modify(ReviewRewriteRequestDTO dto){
        return reviewRepository.modifyReview(new Review(dto));
    }

    //페이징 처리 위한 count 처리
    public int getCount(Search search) {
        return reviewRepository.reviewCount(search);
    }

}
