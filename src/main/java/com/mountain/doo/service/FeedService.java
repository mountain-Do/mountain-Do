package com.mountain.doo.service;


import com.mountain.doo.dto.feed.FeedDetailResponseDTO;
import com.mountain.doo.dto.feed.FeedListResponseDTO;
import com.mountain.doo.dto.feed.FeedRewriteRequestDTO;
import com.mountain.doo.dto.feed.FeedWriteRequestDTO;
import com.mountain.doo.dto.page.ClubSearch;
import com.mountain.doo.dto.page.Page;
import com.mountain.doo.dto.page.Search;
import com.mountain.doo.entity.Feed;
import com.mountain.doo.repository.FeedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.*;


@Service
@RequiredArgsConstructor
public class FeedService {

    //repository에 의존

    private final FeedMapper feedRepository;


    // 게시글 전체목록 처리
    public List<FeedListResponseDTO> getList(Search page){
        return feedRepository.findAll(page)
                .stream()
                .map(FeedListResponseDTO::new)
                .collect(toList());
    }

    // 게시글 상세조회 처리
    public FeedDetailResponseDTO getDetail(int feedNo){
        Feed feed = feedRepository.findOne(feedNo);

        //조회수 상승 처리
        feedRepository.upViewCount(feedNo);

        return new FeedDetailResponseDTO(feed);
    }

    // 글 등록 처리
    public boolean register(FeedWriteRequestDTO dto){
        Feed feed = new Feed(dto);
        return feedRepository.save(feed);
    };

    // 글 삭제 처리
    public boolean delete(int boardNo){
        return feedRepository.deleteFeed(boardNo);
    }

    // 글 수정 처리
    public boolean modify(FeedRewriteRequestDTO dto){
        return feedRepository.modifyFeed(new Feed(dto));
    }

    //페이징 처리 위한 count 처리
    public int getCount(Search search) {
        return feedRepository.feedCount(search);
    }

}
